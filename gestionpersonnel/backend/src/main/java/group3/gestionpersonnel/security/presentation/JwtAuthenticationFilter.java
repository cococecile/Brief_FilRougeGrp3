package group3.gestionpersonnel.security.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import group3.gestionpersonnel.security.business.AuthService;
import group3.gestionpersonnel.security.business.JwtTokenProvider;
/**
 * This class filters HTTP requests and keeps track of those who have already been filtered so it doesn't needlessly do it again.
 * It extends the OncePerRequestFilter class from Spring, aptly named for it does exactly what it says: make sure a request is not filtered if an identical one is already logged
 * Useful when the user lands several times on the same page
 * @author Alexandra HALL
 *
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthService authService;

    /**
     * This method filters the HTTP requests it gets and logs them so it knows it doesn't need to check the JWT for each request
     * @param request = the request the method needs to check
     * @param response = the response the request got
     * @param filter = an imported filter from Spring
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            System.out.println("Entered try catch");
            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) {
                System.out.println("entered if");
                String userName = this.tokenProvider.getUserIdFromJWT(jwt);               
                UserDetails userDetails = this.authService.loadUserByUsername(userName);
                System.out.println("USERRRRR : "+userDetails.getUsername());
                List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), roles);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            this.logger.error("Could not set user authentication in security context", ex);
        }
        System.out.println("going next step");
         filterChain.doFilter(request, response);
    }
    
    /**
     * This method checks if the HTTP request has a token in its header and if so, extracts it.
     * @param request = the request whose token is needed
     * @return the request's token if it exists, null if it doesn't
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

}
