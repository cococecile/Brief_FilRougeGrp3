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

/**
 * This service manages business logic for CRUD operations concerning
 * {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
 * Employees} Performs transactions between Persistence and Model layers.
 * 
 * @author Alexandra HALL
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeDao employeeDao;
	private ModelMapper mapper = PreventRecursiveMapper.getEmployeeMapper();
	
	/**
	 * This method implements the getAllEmployees() method from {@link group3.gestionpersonnel.business.services.interfaces.IEmployeeService IEmployeeService}
	 */
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

	/**
	 * This method implements the saveEmployee(EmployeeDto employeeToCreate) method from {@link group3.gestionpersonnel.business.services.interfaces.IEmployeeService IEmployeeService}
	 */
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeToCreate) {
		if (employeeToCreate != null
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeFirstName())
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeLastName()))
		 {
            EmployeeDo employeeConvertedForDatabase = mapper.map(employeeToCreate, EmployeeDo.class);
            System.out.println("EMPLOYEE : "+employeeConvertedForDatabase.toString());
            Long createdEmployeeId = employeeDao.save(employeeConvertedForDatabase).getEmployeeId();
            employeeToCreate.setEmployeeId(createdEmployeeId);
			return employeeToCreate;
        }
        throw new NullBodyException(
                "One of the required fields is missing ! Please check all required fields are provided and retry.");
        }

	/**
	 * This method implements the getEmployeeById(Long employeeId) method from {@link group3.gestionpersonnel.business.services.interfaces.IEmployeeService IEmployeeService}
	 */
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

	/**
	 * This method implements the deleteEmployeeById(Long employeeId) method from {@link group3.gestionpersonnel.business.services.interfaces.IEmployeeService IEmployeeService}
	 */
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
