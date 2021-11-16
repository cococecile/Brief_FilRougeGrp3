package group3.gestionpersonnel.security.persistence.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group3.gestionpersonnel.security.persistence.UserDo;

@Repository
public interface IUserDao extends JpaRepository<UserDo, Long> {

	UserDo findByUserName(String userName);

}
