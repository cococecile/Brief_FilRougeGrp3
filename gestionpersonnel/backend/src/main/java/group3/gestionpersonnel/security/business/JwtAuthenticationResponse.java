package group3.gestionpersonnel.security.business;

import java.util.Optional;

import group3.gestionpersonnel.persistence.entitties.UserDo;

public class JwtAuthenticationResponse {
	
	private Optional<UserDo> userDo;
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken, Optional<UserDo> optional) {
        this.accessToken = accessToken;
        this.userDo = optional;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Optional<UserDo> getUser() {
        return this.userDo;
    }

    public void setUser(Optional<UserDo> user) {
        this.userDo = user;
    }

}
