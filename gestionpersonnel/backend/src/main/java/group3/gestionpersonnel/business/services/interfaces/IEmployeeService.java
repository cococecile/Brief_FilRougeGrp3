package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.persistence.entitties.EmployeeDo;
import group3.gestionpersonnel.presentation.model.EmployeeDto;

public interface IEmployeeService {

	EmployeeDto getEmployeeById(Long employeeId);

	void saveEmployee(EmployeeDo employeeToCreate);

	void deleteEmployeeById(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();


}
