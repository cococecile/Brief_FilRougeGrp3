package group3.gestionpersonnel.security.presentation.models;

public class LoginRequest {
	
    private String userName;

    private String userPassword;
    
    public String getUserName() {
        return this.userName;
    }

    public void setUsernameOrEmail(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.userPassword;
    }

    public void setPassword(String password) {
        this.userPassword = password;
    }

}
