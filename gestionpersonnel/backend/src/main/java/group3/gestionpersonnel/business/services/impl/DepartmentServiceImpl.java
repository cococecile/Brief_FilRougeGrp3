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
import group3.gestionpersonnel.persistence.entitties.EmployeeDo;
import group3.gestionpersonnel.persistence.entitties.ManagerDo;
import group3.gestionpersonnel.persistence.entitties.MissionDo;
import group3.gestionpersonnel.presentation.model.DepartmentDto;
import group3.gestionpersonnel.presentation.model.EmployeeDto;
import group3.gestionpersonnel.presentation.model.MissionDto;

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
            LOGGER.info("--- AVoiding infinite recursion : ---");
            List<DepartmentDto> convertedList = new ArrayList<DepartmentDto>();
            for (DepartmentDo departmentFromDatabase : listFromDatabase) {
                DepartmentDto convertedDepartment = removeRecursivityFromChildren(departmentFromDatabase);
                convertedList.add(convertedDepartment);
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
            DepartmentDo departmentDo = optDepartmentDo.get();
            DepartmentDto convertedResult = removeRecursivityFromChildren(departmentDo);
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

    private DepartmentDto removeRecursivityFromChildren(DepartmentDo departmentFromDatabase) {
        LOGGER.info("--- Converting department removing recursive children --- ");
        List<MissionDto> missionPool = new ArrayList<MissionDto>();
        List<MissionDo> missionDoPool = departmentFromDatabase.getDepartmentMissionPool();
        if (missionDoPool != null) {
            for (MissionDo missionDo : missionDoPool) {
                MissionDto missionDto = mapper.map(missionDo, MissionDto.class);
                missionDto.setMissionIssuedBy(null);
                missionPool.add(missionDto);
            }
        }
        LOGGER.info("---Employee list ---");
        List<EmployeeDto> employeePool = new ArrayList<EmployeeDto>();
        List<EmployeeDo> employeeDoPool = departmentFromDatabase.getDepartmentEmployees();
        if (employeeDoPool != null) {
            for (EmployeeDo employeeDo : employeeDoPool) {
                EmployeeDto employeeDto = mapper.map(employeeDo, EmployeeDto.class);
                employeeDto.setEmployeeDepartment(null);
                employeePool.add(employeeDto);
            }
        }
        ManagerDo manager = departmentFromDatabase.getDepartmentChief();
        if(manager!=null){
        manager.setManagerDepartment(null);
        }
        departmentFromDatabase.setDepartmentChief(manager);
        DepartmentDto departmentFromList = mapper.map(departmentFromDatabase, DepartmentDto.class);
        departmentFromList.setDepartmentMissions(missionPool);
        departmentFromList.setDepartmentEmployees(employeePool);
        return departmentFromList;
    }

}

