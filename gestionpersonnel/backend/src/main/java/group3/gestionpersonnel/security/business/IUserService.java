package group3.gestionpersonnel.security.business;

import group3.gestionpersonnel.security.persistence.UserDo;

public interface IUserService {

    UserDo findByUserName(String Username);
    
}
