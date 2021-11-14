package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import group3.gestionpersonnel.business.services.interfaces.IEmployeeService;
import group3.gestionpersonnel.business.utils.NullChecker;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IEmployeeDao;
import group3.gestionpersonnel.persistence.entitties.*;
import group3.gestionpersonnel.presentation.model.*;

public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	IEmployeeDao employeeDao;
	private ModelMapper mapper = new ModelMapper();
	
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDo> listFromDatabase = employeeDao.findAll();
        if (listFromDatabase != null) {
            List<EmployeeDto> convertedList = new ArrayList<EmployeeDto>();
            for (EmployeeDo employeeFromDatabase : listFromDatabase) {
                EmployeeDto convertedEmployee = removeRecursivityFromChildren(employeeFromDatabase);
                convertedList.add(convertedEmployee);
            }
            return convertedList;
        }
        throw new ResourceNotFoundException(
                "You requested a list of missions from a department, but that department does not exist. Please provide a valid department's id and retry.");	}

	@Override
	public void saveEmployee(EmployeeDo employeeToCreate) {
		if (employeeToCreate != null
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeFirstName())
				&& NullChecker.isNotNullAndNotEmpty(employeeToCreate.getEmployeeLastName()))
		 {
            EmployeeDo employeeConvertedForDatabase = mapper.map(employeeToCreate, EmployeeDo.class);
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
            EmployeeDto convertedResult = removeRecursivityFromChildren(employeeDo);
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
	
    private EmployeeDto removeRecursivityFromChildren(EmployeeDo employeeFromDatabase) {
        MissionDo missionDo = employeeFromDatabase.getEmployeeMission();
        MissionDto missionDto = new MissionDto();
        if (missionDo != null) {
        	missionDto = mapper.map(missionDo, MissionDto.class);
            missionDto.setMissionIssuedBy(null);
        }
        DepartmentDto departmentDto = new DepartmentDto();
        DepartmentDo departmentDo = employeeFromDatabase.getEmployeeDepartment();
        if (departmentDo != null) {
        	departmentDto = mapper.map(departmentDo, DepartmentDto.class);
            departmentDto.setDepartmentEmployees(null);
            departmentDto.setDepartmentChief(null);
        }
        ManagerDo manager = employeeFromDatabase.getEmployeeManagedBy();
        if(manager!=null){
        manager.setManagerDepartment(null);
        }
        employeeFromDatabase.setEmployeeManagedBy(manager);
        EmployeeDto employeeFromList = mapper.map(employeeFromDatabase, EmployeeDto.class);
        employeeFromList.setEmployeeMission(missionDto);
        employeeFromList.setEmployeeDepartment(departmentDto);
        return employeeFromList;
    }

}
