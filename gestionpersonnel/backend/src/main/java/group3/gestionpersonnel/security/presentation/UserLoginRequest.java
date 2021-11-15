package group3.gestionpersonnel.security.presentation;

import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import group3.gestionpersonnel.persistence.entitties.UserDo;


public class UserLoginRequest implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
    private String userName;

    @NotBlank
    private String userPassword;
    
    private Collection<? extends GrantedAuthority> authorities;
    
    public UserLoginRequest() {
		super();
	}

	public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static UserLoginRequest create(UserDo userDo) {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUserName(userDo.getUserName());
        userLoginRequest.setUserPassword(userDo.getUserPassword());
        return userLoginRequest;
    }

}
