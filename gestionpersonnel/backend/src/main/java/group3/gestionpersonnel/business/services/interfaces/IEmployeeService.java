package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.EmployeeDto;

/**
 * This interface contains methods to be implemented by
 * {@link group3.gestionpersonnel.business.services.impl.EmployeeServiceImpl
 * EmployeeServiceImpl} Methods are CRUD operations.
 * 
 * @author Alexandra HALL
 */
public interface IEmployeeService {

	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IEmployeeDao EmployeeDao}
     * to retrieve a {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
     * EmployeeDo} that has the given id, then maps it to its
     * {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto}
     * counterpart that is then returned
     * 
     * @param employeeId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
     *                  EmployeeDo} we want to retrieve
     * @return corresponding
     *         {@link group3.gestionpersonnel.presentation.model.EmployeeDto
     *         EmployeeDto}
     */
	EmployeeDto getEmployeeById(Long employeeId);

	/**
     * Maps an {@link group3.gestionpersonnel.presentation.model.EmployeeDto
     * EmployeeDto} to an
     * {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo EmployeeDo} and
     * forwards it to {@link group3.gestionpersonnel.persistence.dao.IEmployeeDao
     * IEmployeeDao} for database insertion.
     * @param employeeToCreate = an Employee object which contains the information about the employee we need to create or update
     */
	void saveEmployee(EmployeeDto employeeToCreate);

	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IEmployeeDao IEmployeeDao}
     * to delete a {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
     * EmployeeDo} thanks to its id.
     * 
     * @param employeeId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
     *                  EmployeeDo} to delete.
     */
	void deleteEmployeeById(Long employeeId);
	
	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IEmployeeDao IEmployeeDao}
     * to retrieve the List of all
     * {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo EmployeeDo}
     * then maps that List to a List of
     * {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto} and
     * returns it
     * 
     * @return a List of
     *         {@link group3.gestionpersonnel.presentation.model.EmployeeDto
     *         EmployeeDto} retrieved from database
     */
	List<EmployeeDto> getAllEmployees();


}
