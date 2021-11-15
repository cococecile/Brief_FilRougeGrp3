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
import group3.gestionpersonnel.business.utils.mappers.PreventRecursiveMapper;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IManagerDao;
import group3.gestionpersonnel.persistence.entitties.*;
import group3.gestionpersonnel.presentation.model.*;

/**
 * This service manages business logic for CRUD operations concerning
 * {@link group3.gestionpersonnel.persistence.entitties.ManagerDo
 * Managers} Performs transactions between Persistence and Model layers.
 * 
 * @author Alexandra HALL
 */
@Service
public class ManagerServiceImpl implements IManagerService {
	
	@Autowired
	private IManagerDao managerDao;
	private ModelMapper mapper = PreventRecursiveMapper.getManagerMapper();
	
	/**
	 * This method implements the getAllManagers() method from {@link group3.gestionpersonnel.business.services.interfaces.IManagerService IManagerService}
	 */
	@Override
	public List<ManagerDto> getAllManagers() {
		List<ManagerDo> listFromDatabase = managerDao.findAll();
		List<ManagerDto> convertedList = new ArrayList<ManagerDto>();
        if (listFromDatabase != null) {
            for (ManagerDo managerFromDatabase : listFromDatabase) {
                ManagerDto convertedManager = mapper.map(managerFromDatabase, ManagerDto.class);
                convertedList.add(convertedManager);
            }
        }
        return convertedList;
    }
	
	/**
	 * This method implements the getManagerById(Long managerId) method from {@link group3.gestionpersonnel.business.services.interfaces.IManagerService IManagerService}
	 */
	@Override
	public ManagerDto getManagerById(Long managerId) {
		Optional<ManagerDo> optManagerDo = managerDao.findById(managerId);
        if (optManagerDo.isPresent()) {
            ManagerDo managerDo = optManagerDo.get();
            ManagerDto convertedResult = mapper.map(managerDo, ManagerDto.class);
            return convertedResult;
        }
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
	}
	
	/**
	 * This method implements the saveManager(ManagerDto managerToCreate) method from {@link group3.gestionpersonnel.business.services.interfaces.IManagerService IManagerService}
	 */
	@Override
	public void saveManager(ManagerDto managerToCreate) {
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
	
	/**
	 * This method implements the deleteManagerById(Long managerId) method from {@link group3.gestionpersonnel.business.services.interfaces.IManagerService IManagerService}
	 */
	@Override
	public void deleteManagerById(Long managerId) {
		if (managerId != null && managerId != 0) {
            managerDao.deleteById(managerId);
            return;
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
		
	}

}
