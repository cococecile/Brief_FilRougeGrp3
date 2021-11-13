package group3.gestionpersonnel.business.utils.mappers;

import org.modelmapper.ModelMapper;

import group3.gestionpersonnel.persistence.entitties.EmployeeDo;
import group3.gestionpersonnel.presentation.model.EmployeeDto;

public class EmployeeMapper {
	
	ModelMapper modelMapper = new ModelMapper();
	
	private EmployeeDto convertToDto(EmployeeDo employeeDo) {
	    EmployeeDto employeeDto = modelMapper.map(employeeDo, EmployeeDto.class);
	    return employeeDto;
	}
	
	private EmployeeDo convertToEntity(EmployeeDto employeeDto) {
	    EmployeeDo employeeDo = modelMapper.map(employeeDto, EmployeeDo.class);

	    return employeeDo;
	}

}
