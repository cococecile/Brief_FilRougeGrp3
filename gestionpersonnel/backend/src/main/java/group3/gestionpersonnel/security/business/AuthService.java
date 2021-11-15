package group3.gestionpersonnel.security.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.persistence.entitties.UserDo;
import group3.gestionpersonnel.security.persistence.IUserDao;
import group3.gestionpersonnel.security.presentation.UserLoginRequest;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private IUserDao userDao;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDo userDo = this.userDao.findByUserName(username)
                .orElseThrow(() ->
                new UsernameNotFoundException("User not found with username : " + username)
                        );

        return UserLoginRequest.create(userDo);
	}
	
	@Transactional
    public UserDetails loadUserById(Long id) {
        UserDo userDo = this.userDao.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
                );

        return UserLoginRequest.create(userDo);
    }

}
