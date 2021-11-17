package group3.gestionpersonnel.security.business;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * This class contains methods used to generate new tokens and check if existing ones are correct.
 * It will be used when a user tried to log in, and every time an HTTP request is sent, to make sure the logged in user is allowed to send these requests.
 * @author Alexandra HALL
 *
 */
@Component
public class JwtTokenProvider {
	
		
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

	    @Value("${app.jwtSecret}")
	    private String jwtSecret;

	    @Value("${app.jwtExpirationInMs}")
	    private int jwtExpirationInMs;

	    /**
	     * This method generates a token, which will be used as an identifier for the user during navigation on the app.
	     * @param authentication = An Authentication Bean, whose attribute UserPrincipal is needed
	     * @return a JWT with the following attributes:
	     * - the user's username as a Subject
	     * - the date the token was issued, set to now
	     * - the token's expiration date, which is calculated from the current time + the jwtExpirationDate variable
	     * - the encrypted secret as a signature
	     */
	    public String generateToken(Authentication authentication) {

	        User userPrincipal = (User) authentication.getPrincipal();

	        Date now = new Date();
	        Date expiryDate = new Date(now.getTime() + this.jwtExpirationInMs);

	        return Jwts.builder()
	                .setSubject(userPrincipal.getUsername())
	                .setIssuedAt(new Date())
	                .setExpiration(expiryDate)
	                .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
	                .compact();
	    }

	    /**
	     * This method is used to get the UserId from the token.
	     * @param token = the token we need to parse to get the userId
	     * @return the Subject from the token's claims, parsed to get the userId as a Long value
	     */
	    public Long getUserIdFromJWT(String token) {
	        Claims claims = Jwts.parser()
	                .setSigningKey(this.jwtSecret)
	                .parseClaimsJws(token)
	                .getBody();

	        return Long.parseLong(claims.getSubject());
	    }

	    /**
	     * This method checks if the token it's receiving is valid. Several exceptions can be caught:
	     * - the token's signature is wrong
	     * - the token hasn't been properly created
	     * - the token has expired
	     * - the token's format or configuration is invalid
	     * - the token is missing a claims attribute
	     * @param authToken = the token sent with the HTTP request
	     * @return a boolean that indicates if the token allows the user to go forward
	     */
	    public boolean validateToken(String authToken) {
	        try {
	            Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(authToken);
	            return true;
	        } catch (SignatureException ex) {
	            logger.error("Invalid JWT signature");
	        } catch (MalformedJwtException ex) {
	            logger.error("Invalid JWT token");
	        } catch (ExpiredJwtException ex) {
	            logger.error("Expired JWT token");
	        } catch (UnsupportedJwtException ex) {
	            logger.error("Unsupported JWT token");
	        } catch (IllegalArgumentException ex) {
	            logger.error("JWT claims string is empty.");
	        }
	        return false;
	    }


}
