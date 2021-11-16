package group3.gestionpersonnel.security.business.services.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.security.business.services.interfaces.IUserService;
import group3.gestionpersonnel.security.persistence.UserDo;
import group3.gestionpersonnel.security.persistence.dao.IUserDao;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDao userDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDo findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
    
}
