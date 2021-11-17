package group3.gestionpersonnel.security.presentation.models;

import java.util.Optional;

import group3.gestionpersonnel.security.persistence.UserDo;

public class JwTAuthenticationResponse {
	
	private Optional<UserDo> user;
    private String accessToken;
    private String tokenType = "Bearer";

    public JwTAuthenticationResponse(String accessToken, Optional<UserDo> optional) {
        this.accessToken = accessToken;
        this.user = optional;
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
        return this.user;
    }

    public void setUser(Optional<UserDo> user) {
        this.user = user;
    }

}
