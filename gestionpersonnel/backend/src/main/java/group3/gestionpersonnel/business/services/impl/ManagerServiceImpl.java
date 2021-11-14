package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.business.services.interfaces.IManagerService;
import group3.gestionpersonnel.business.utils.NullChecker;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IManagerDao;
import group3.gestionpersonnel.persistence.entitties.*;
import group3.gestionpersonnel.presentation.model.*;

@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private IManagerDao managerDao;
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<ManagerDto> getAllManagers() {
		List<ManagerDo> listFromDatabase = managerDao.findAll();
        if (listFromDatabase != null) {
            List<ManagerDto> convertedList = new ArrayList<ManagerDto>();
            for (ManagerDo managerFromDatabase : listFromDatabase) {
                ManagerDto convertedManager = removeRecursivityFromChildren(managerFromDatabase);
                convertedList.add(convertedManager);
            }
            return convertedList;
        }
        throw new ResourceNotFoundException(
                "You requested a list of missions from a department, but that department does not exist. Please provide a valid department's id and retry.");
        }
	
	@Override
	public ManagerDto getManagerById(Long managerId) {
		Optional<ManagerDo> optManagerDo = managerDao.findById(managerId);
        if (optManagerDo.isPresent()) {
            ManagerDo managerDo = optManagerDo.get();
            ManagerDto convertedResult = removeRecursivityFromChildren(managerDo);
            return convertedResult;
        }
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
	}
	
	@Override
	public void saveManager(ManagerDo managerToCreate) {
		if (managerToCreate != null
				&& NullChecker.isNotNullAndNotEmpty(managerToCreate.getManagerFirstName())
				&& NullChecker.isNotNullAndNotEmpty(managerToCreate.getManagerLastName()))
		 {
            ManagerDo managerConvertedForDatabase = mapper.map(managerToCreate, ManagerDo.class);
            managerDao.save(managerConvertedForDatabase);
            return;
        }
        throw new NullBodyException(
                "One of the required fields is missing ! Please check all required fields are provided and retry.");
        }
	
	@Override
	public void deleteManagerById(Long managerId) {
		if (managerId != null && managerId != 0) {
            managerDao.deleteById(managerId);
            return;
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
		
	}

	
	private ManagerDto removeRecursivityFromChildren(ManagerDo managerFromDatabase) {

        List<EmployeeDto> employeePool = new ArrayList<EmployeeDto>();
        List<EmployeeDo> employeeDoPool = managerFromDatabase.getManagedEmployees();
        if (employeeDoPool != null) {
            for (EmployeeDo employeeDo : employeeDoPool) {
                EmployeeDto employeeDto = mapper.map(employeeDo, EmployeeDto.class);
                employeeDto.setEmployeeDepartment(null);
                employeePool.add(employeeDto);
            }
        }
        DepartmentDo department = managerFromDatabase.getManagerDepartment();
        if(department!=null){
        department.setDepartmentChief(null);
        }
        managerFromDatabase.setManagerDepartment(department);
        ManagerDto managerFromList = mapper.map(managerFromDatabase, ManagerDto.class);
        managerFromList.setManagedEmployees(employeePool);
        return managerFromList;
    }



}
