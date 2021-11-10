package group3.gestionpersonnel.business.utils.mappers;

import group3.gestionpersonnel.business.services.interfaces.EmployeeService;
import group3.gestionpersonnel.persistence.entitties.EmployeeDo;
import group3.gestionpersonnel.presentation.model.EmployeeDto;

public class EmployeeMapper {
	
	private EmployeeService employeeService;
	
	private EmployeeDto convertToDto(EmployeeDo employeeDo) {
	    EmployeeDto employeeDto = modelMapper.map(employeeDo, EmployeeDto.class);
	    return employeeDto;
	}
	
	private EmployeeDo convertToEntity(EmployeeDto employeeDto) {
	    EmployeeDo employeeDo = modelMapper.map(employeeDto, EmployeeDo.class);
	 
	    if (employeeDto.getEmployeeId() != null) {
	        EmployeeDo oldEmployeeDo = employeeService.getById(employeeDto.getEmployeeId());
	        employeeDo.setRedditID(oldEmployeeDo.getRedditID());
	        employeeDo.setSent(oldEmployeeDo.isSent());
	    }
	    return employeeDo;
	}

}
