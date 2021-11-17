package group3.gestionpersonnel.security.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.security.persistence.IUserDao;
import group3.gestionpersonnel.security.persistence.UserDo;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private IUserDao userDao;

	/**
	 * This method creates a Login Request for the user who's trying to login. It checks if the username exists in the database.
	 */
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDo userDo = this.userDao.findByUserName(username)
                .orElseThrow(() ->
                new UsernameNotFoundException("User not found with username : " + username)
                        );

		User springUser = new User(userDo.getUserName(), userDo.getUserPassword(), null);
        return springUser;
	}
	
	/**
	 * This method creates a Login Request for the user who's trying to login. It checks if the id exists in the database.
	 */
	@Transactional
    public UserDetails loadUserById(Long id) {
        UserDo userDo = this.userDao.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
                );
        User springUser = new User(userDo.getUserName(), userDo.getUserPassword(), null);

        return springUser;
    }

}
