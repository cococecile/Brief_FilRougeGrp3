package group3.gestionpersonnel.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailsService userDetailsService;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Crypt/Decrypt passwords
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
    


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //disable default spring security csrf token
        http.csrf().disable();

        //ask spring not to save sessions since token are saved on user's browser
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //ask spring to authorize all requests to login even without token.
        http.authorizeRequests().antMatchers("/api/auth/login").permitAll();

        //ask for authentication for alll other requests.
        http.authorizeRequests().anyRequest().authenticated();


    }

}
