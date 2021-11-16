package group3.gestionpersonnel.security.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.security.persistence.UserDo;
import group3.gestionpersonnel.security.persistence.dao.IUserDao;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public UserDo findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
    
}
