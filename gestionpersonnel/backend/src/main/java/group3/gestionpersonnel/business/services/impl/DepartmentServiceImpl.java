package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import group3.gestionpersonnel.business.services.interfaces.IDepartmentService;
import group3.gestionpersonnel.business.utils.NullChecker;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IDepartmentDao;
import group3.gestionpersonnel.persistence.entitties.DepartmentDo;
import group3.gestionpersonnel.presentation.model.DepartmentDto;

/**
 * This service manages business logic for CRUD operations concerning
 * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
 * Departments} Performs transactions between Persistence and Model layers.
 * 
 * @author Caroline(group3)
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentDao departmentDao;
    private ModelMapper mapper = new ModelMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(MissionServiceImpl.class);

    @Override
    public void saveDepartment(DepartmentDto departmentToCreate) {
        LOGGER.info("--- DEPARTMENT SERVICE SAVE METHOD ---");
        if (departmentToCreate != null && NullChecker.isNotNullAndNotEmpty(departmentToCreate.getDepartmentName())) {
            mapper.getConfiguration().setAmbiguityIgnored(true);
            DepartmentDo departmentConvertedForDatabase = mapper.map(departmentToCreate, DepartmentDo.class);
            departmentDao.save(departmentConvertedForDatabase);
            return;
        }
        throw new NullBodyException(
                "One of the required fields is missing ! Please check all required fields are provided and retry.");
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        LOGGER.info("--- DEPARTMENT SERVICE GETALLDEPARTMENT METHOD ---");
        List<DepartmentDo> listFromDatabase = departmentDao.findAll();
        if (listFromDatabase != null) {
            List<DepartmentDto> convertedList = new ArrayList<DepartmentDto>();
            for (DepartmentDo departmentFromDatabase : listFromDatabase) {
                DepartmentDto departmentFromList = mapper.map(departmentFromDatabase, DepartmentDto.class);
                convertedList.add(departmentFromList);
            }
            return convertedList;
        }
        throw new ResourceNotFoundException(
                "You requested a list of missions from a department, but that department does not exist. Please provide a valid department's id and retry.");

    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        LOGGER.info("--- DEPARTMENT SERVICE GETBYID METHOD ---");
        Optional<DepartmentDo> optDepartmentDo = departmentDao.findById(departmentId);
        if (optDepartmentDo.isPresent()) {
            LOGGER.info("Optional found");
            DepartmentDo departmentDo = optDepartmentDo.get();
            DepartmentDto convertedResult = mapper.map(departmentDo, DepartmentDto.class);
            return convertedResult;
        }
        LOGGER.error("NOT FOUND");
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        if (departmentId != null && departmentId != 0) {
            departmentDao.deleteById(departmentId);
            return;
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
    }

}
