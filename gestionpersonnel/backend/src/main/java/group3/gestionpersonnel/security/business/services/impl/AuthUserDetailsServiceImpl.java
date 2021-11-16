package group3.gestionpersonnel.security.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.security.persistence.UserDo;

@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       
        UserDo user = userService.findByUserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("User not found with username : "+userName);
        }

        //Insérer list autority ic        


    }
    
}
