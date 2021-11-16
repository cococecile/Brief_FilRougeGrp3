package group3.gestionpersonnel.security.presentation;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank
    private String userName;

    @NotBlank
    private String password;
    
    public String getUserName() {
        return this.userName;
    }

    public void setUsernameOrEmail(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
