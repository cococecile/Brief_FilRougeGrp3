package group3.gestionpersonnel.security.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserDao extends JpaRepository<UserDo, Long> {

	Optional<UserDo> findByUserName(String userName);

}
