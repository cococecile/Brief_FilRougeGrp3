package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.business.services.interfaces.IEmployeeService;
import group3.gestionpersonnel.business.utils.NullChecker;
import group3.gestionpersonnel.business.utils.mappers.PreventRecursiveMapper;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IEmployeeDao;
import group3.gestionpersonnel.persistence.entitties.*;
import group3.gestionpersonnel.presentation.model.*;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeDao employeeDao;
	private ModelMapper mapper = PreventRecursiveMapper.getEmployeeMapper();
	
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDo> listFromDatabase = employeeDao.findAll();
		List<EmployeeDto> convertedList = new ArrayList<EmployeeDto>();
        if (listFromDatabase != null) {            
            for (EmployeeDo employeeFromDatabase : listFromDatabase) {
                EmployeeDto convertedEmployee = mapper.map(employeeFromDatabase, EmployeeDto.class);
                convertedList.add(convertedEmployee);
            }
        }
        return convertedList;
    }

	@Override
	public void saveEmployee(EmployeeDto employeeToCreate) {
		if (employeeToCreate != null
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeFirstName())
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeLastName()))
		 {
            EmployeeDo employeeConvertedForDatabase = mapper.map(employeeToCreate, EmployeeDo.class);
            System.out.println("EMPLOYEE : "+employeeConvertedForDatabase.toString());
            employeeDao.save(employeeConvertedForDatabase);
            return;
        }
        throw new NullBodyException(
                "One of the required fields is missing ! Please check all required fields are provided and retry.");
        }

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Optional<EmployeeDo> optEmployeeDo = employeeDao.findById(employeeId);
        if (optEmployeeDo.isPresent()) {
            EmployeeDo employeeDo = optEmployeeDo.get();
            EmployeeDto convertedResult = mapper.map(employeeDo, EmployeeDto.class);
            return convertedResult;
        }
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
	}

	@Override
	public void deleteEmployeeById(Long employeeId) {
		if (employeeId != null && employeeId != 0) {
            employeeDao.deleteById(employeeId);
            return;
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
		
	}
	  
}
