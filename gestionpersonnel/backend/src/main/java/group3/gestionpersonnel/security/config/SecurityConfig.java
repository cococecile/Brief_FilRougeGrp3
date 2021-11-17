package group3.gestionpersonnel.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import group3.gestionpersonnel.security.business.AuthService;
import group3.gestionpersonnel.security.presentation.JwtAuthenticationEntryPoint;
import group3.gestionpersonnel.security.presentation.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
        )
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    AuthService authService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
        .userDetailsService(this.authService)
        .passwordEncoder(passwordEncoder());
    }

    /**
     * This method creates a Bean AuthenticationManager, whose authenticate() method is needed to check the user's credentials.
     */
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * This method gets an existing Password Encoder to ensure the user's password is stored safely
     * @return an Object PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * This method sets which pages a user is allowed to get when not logged in.
     * In this case, access to every page whose URL starts with .../api/auth/ is allowed even when not logged in.
     * The point is that the user cannot acces the signin page without being signed in unless we specifically allow it with this method. 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .cors()
        .and()
        .csrf()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(this.unauthorizedHandler)
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //don't bother creating a session
        .and()
        .authorizeRequests()
        .antMatchers("/",
                "/favicon.ico",
                "/**/*.png",
                "/**/*.gif",
                "/**/*.svg",
                "/**/*.jpg",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js")
        .permitAll()
        .antMatchers("/api/auth/**")
        .permitAll()
        //.antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
        //.permitAll()
        //.antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**")
        //.permitAll()
        .anyRequest()
        .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
