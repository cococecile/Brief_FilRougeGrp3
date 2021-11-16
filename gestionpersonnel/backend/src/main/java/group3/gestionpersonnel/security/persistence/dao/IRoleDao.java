package group3.gestionpersonnel.security.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group3.gestionpersonnel.security.persistence.RoleDo;

@Repository
public interface IRoleDao extends JpaRepository<RoleDo, Long> {

	RoleDo findByRole(String userName);

}
