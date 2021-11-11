package group3.gestionpersonnel.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group3.gestionpersonnel.persistence.entitties.EmployeeDo;

/**
 * This interface extends JPA Repository, replacing generic types with
 * EmployeeDo type and Long (for EmployeeDo's ID) This is the dao interface that
 * will be called by the EmployeeService.
 * 
 * @author Caroline(Group3)
 */
@Repository
public interface IEmployeeDao extends JpaRepository<EmployeeDo, Long> {
}