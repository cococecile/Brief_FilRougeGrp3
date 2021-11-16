package group3.gestionpersonnel.security.presentation;

import java.util.Collection;

import javax.validation.constraints.NotBlank;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import group3.gestionpersonnel.persistence.entitties.UserDo;


public class UserPrincipal implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotBlank
    private String userName;

    @NotBlank
    private String userPassword;
    
    private Collection<? extends GrantedAuthority> authorities;
    
    public UserPrincipal() {
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
	
	/**
	 * This method creates a Login Request from the username and password it's given as parameters
	 * @param userDo = the object User created from the username and password the method is being sent
	 * @return a Login Request with these parameters
	 */
	public static UserPrincipal create(UserDo userDo) {
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setUserName(userDo.getUserName());
        userPrincipal.setUserPassword(userDo.getUserPassword());
        return userPrincipal;
    }

}
