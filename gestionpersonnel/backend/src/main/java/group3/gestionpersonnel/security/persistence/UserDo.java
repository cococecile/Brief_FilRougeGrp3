package group3.gestionpersonnel.security.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="users")
public class UserDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@NaturalId
	@Column(name = "user_name")
	@NotBlank
	private String userName;
	
	@Column(name= "user_password")
	@NotBlank
	private String userPassword;

	@Column(name="is_user_enabled")
	private boolean isUserEnabled;

	public UserDo() {
		super();
	}

	public UserDo(Long userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public UserDo(String userName, String password, boolean b) {
		this.userName = userName;
		this.userPassword = password;
		this.isUserEnabled = b;
		

    }

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	

}
