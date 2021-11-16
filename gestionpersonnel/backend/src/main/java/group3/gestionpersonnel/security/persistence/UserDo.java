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
	private int userId;
	
	@NaturalId
	@Column(name = "user_name", unique=true)
	@NotBlank
	private String userName;
	
	@Column(name= "user_password")
	@NotBlank
	private String userPassword;

	@Column(name="is_user_enabled")
	private Boolean isUserEnabled;
	

	public UserDo() {
	}

	public UserDo(int userId, @NotBlank String userName, @NotBlank String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
			}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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