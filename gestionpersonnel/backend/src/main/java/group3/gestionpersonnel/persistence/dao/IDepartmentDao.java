package group3.gestionpersonnel.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import group3.gestionpersonnel.persistence.entitties.DepartmentDo;

/**
 * This interface extends JpaRepository, specifying types to be DepartmentDo and
 * Long(department's id's type) This interface acts as repository for Department
 * Service.
 * 
 * @author Caroline(group3)
 */
@Repository
@Transactional
public interface IDepartmentDao extends JpaRepository<DepartmentDo, Long> {

}
