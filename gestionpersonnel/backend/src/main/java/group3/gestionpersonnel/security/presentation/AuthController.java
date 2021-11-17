package group3.gestionpersonnel.security.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import group3.gestionpersonnel.security.presentation.models.JwTAuthenticationResponse;
import group3.gestionpersonnel.security.presentation.models.LoginRequest;
import group3.gestionpersonnel.security.business.JwtTokenProvider;
import group3.gestionpersonnel.security.persistence.IUserDao;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		loginRequest.getUserName(),
                		loginRequest.getPassword()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = this.tokenProvider.generateToken(authentication);
       return ResponseEntity.ok(new JwTAuthenticationResponse(jwt, this.userDao.findByUserName(loginRequest.getUserName())));
    }


}
