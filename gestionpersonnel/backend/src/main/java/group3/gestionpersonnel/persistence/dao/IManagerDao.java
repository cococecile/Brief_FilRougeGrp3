package group3.gestionpersonnel.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group3.gestionpersonnel.persistence.entitties.ManagerDo;

/**
 * This interface extends Generic JpaRepository and passes it ManagerDo and Long
 * types. Acts as Repository for Manager service
 * 
 * @author Caroline(group3)
 */
@Repository
public interface IManagerDao extends JpaRepository<ManagerDo, Long> {

}
