package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group3.gestionpersonnel.business.services.interfaces.IMissionService;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.IDepartmentDao;
import group3.gestionpersonnel.persistence.dao.IEmployeeDao;
import group3.gestionpersonnel.persistence.dao.IMissionDao;
import group3.gestionpersonnel.persistence.entitties.DepartmentDo;
import group3.gestionpersonnel.persistence.entitties.EmployeeDo;
import group3.gestionpersonnel.persistence.entitties.MissionDo;
import group3.gestionpersonnel.presentation.model.MissionDto;

/**
 * This service manages business logic for crud operations concerning
 * {@link group3.gestionpersonnel.persistence.entitties.MissionDo Missions}
 * Performs transactions between Persistence and Model layers.
 * 
 * @author Caroline(group3)
 */
@Service
@Transactional
public class MissionServiceImpl implements IMissionService {

    @Autowired
    private IMissionDao missionDao;
    @Autowired
    private IDepartmentDao departmentDao;
    @Autowired
    private IEmployeeDao employeeDao;
    private ModelMapper mapper;

    @Override
    public void saveMission(MissionDto missionToCreate) {
        if (!isNotNullAndNotEmpty(missionToCreate)) {
            throw new NullBodyException(
                    "No Mission object had been found in your request's body. Please provide required body and retry.");
        }
        if (isNotNullAndNotEmpty(missionToCreate.getMissionName())
                && isNotNullAndNotEmpty(missionToCreate.getMissionDescription())
                && isNotNullAndNotEmpty(missionToCreate.getMissionType())
                && isNotNullAndNotEmpty(missionToCreate.getMissionStartDate())
                && isNotNullAndNotEmpty(missionToCreate.getMissionEndDate())) {

            MissionDo missionConvertedForDatabase = mapper.map(missionToCreate, MissionDo.class);
            missionDao.save(missionConvertedForDatabase);
            return;
        }
        throw new NullBodyException(
                "One of the required fields is missing ! Please check all required fields are provided and retry.");
    }

    @Override
    public List<MissionDto> getAllMissions() {
        List<MissionDo> listFromDatabase = missionDao.findAll();
        List<MissionDto> convertedList = convertList(listFromDatabase);
        return convertedList;
    }

    @Override
    public List<MissionDto> getAllMissionsForDepartment(Long departmentId) {
        DepartmentDo department = departmentDao.getById(departmentId);
        if (department == null) {
            throw new ResourceNotFoundException(
                    "You requested a list of missions from a department, but that department does not exist. Please provide a valid department's id and retry.");
        }

        List<MissionDo> listFromDatabase = new ArrayList<MissionDo>();
        List<MissionDto> convertedList = new ArrayList<MissionDto>();
        listFromDatabase = department.getDepartmentMissionPool();
        convertedList = convertList(listFromDatabase);

        return convertedList;
    }

    @Override
    public MissionDto getMissionById(Long missionId) {
        MissionDo missionDo = missionDao.getById(missionId);
        if (missionDo == null) {
            throw new ResourceNotFoundException(
                    "No resource matching provided id has been found. Please provide valid id and retry");
        }
        MissionDto convertedResult = mapper.map(missionDo, MissionDto.class);
        return convertedResult;
    }

    @Override
    public void assignMissionToEmployee(Long missionId, Long employeeId) {
        Optional<EmployeeDo> optEmployee = employeeDao.findById(employeeId);
        if (optEmployee.isPresent()) {
            Optional<MissionDo> optMission = missionDao.findById(missionId);
            if (optMission.isPresent()) {
                EmployeeDo employee = optEmployee.get();
                MissionDo mission = optMission.get();
                employee.setEmployeeMission(mission);
                employeeDao.save(employee);
                return;
            }

        }

    }

    @Override
    public void deleteMissionById(Long missionId) {
        if (isNotNullAndNotEmpty(missionId)) {
            missionDao.deleteById(missionId);
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
    }

    private <T> boolean isNotNullAndNotEmpty(T testObject) {
        Boolean result = false;
        if (testObject != null) {
            result = true;
        }
        if (testObject.getClass().equals(String.class) && ((String) testObject).trim().isEmpty()) {
            result = false;
        }
        return result;
    }

    private List<MissionDto> convertList(List<MissionDo> listFromDatabase) {
        List<MissionDto> convertedList = new ArrayList<MissionDto>();
        if (listFromDatabase != null) {
            for (MissionDo missionFromDatabase : listFromDatabase) {
                MissionDto missionToReturn = mapper.map(missionFromDatabase, MissionDto.class);
                convertedList.add(missionToReturn);
            }
        }

        return convertedList;
    }

}
