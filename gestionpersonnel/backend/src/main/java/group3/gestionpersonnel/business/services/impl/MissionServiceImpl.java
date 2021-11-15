package group3.gestionpersonnel.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group3.gestionpersonnel.business.services.interfaces.IMissionService;
import group3.gestionpersonnel.business.utils.NullChecker;
import group3.gestionpersonnel.business.utils.mappers.PreventRecursiveMapper;
import group3.gestionpersonnel.exceptions.NullBodyException;
import group3.gestionpersonnel.persistence.dao.*;
import group3.gestionpersonnel.persistence.entitties.*;
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
    private ModelMapper mapper = PreventRecursiveMapper.getMissionMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(MissionServiceImpl.class);

    @Override
    public void saveMission(MissionDto missionToCreate) {
        LOGGER.info("--- MISION SERVICE SAVE METHOD ---");
        if (missionToCreate != null && NullChecker.isNotNullAndNotEmpty(missionToCreate.getMissionName())
                && NullChecker.isNotNullAndNotEmpty(missionToCreate.getMissionDescription())
                && NullChecker.isNotNullAndNotEmpty(missionToCreate.getMissionType())
                && NullChecker.isNotNullAndNotEmpty(missionToCreate.getMissionStartDate())
                && NullChecker.isNotNullAndNotEmpty(missionToCreate.getMissionEndDate())) {
            mapper.getConfiguration().setAmbiguityIgnored(true);
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
        Optional<MissionDo> optMissionDo = missionDao.findById(missionId);
        LOGGER.info("MISSION DO GOTTEN");
        if (optMissionDo.isPresent()) {
            LOGGER.info("Optional found");
            MissionDo missionDo = optMissionDo.get();
            if(missionDo.getMissionAssignedTo()!=null){
            missionDo.getMissionAssignedTo().setEmployeeMission(null);
            }        
            MissionDto convertedResult = mapper.map(missionDo, MissionDto.class);
            return convertedResult;
        }
        LOGGER.error("NOT FOUND");
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
    }

    @Override
    public void assignMissionToEmployee(Long missionId, Long employeeId) {
        Optional<EmployeeDo> optEmployee = employeeDao.findById(employeeId);
        if (optEmployee.isPresent()) {
            Optional<MissionDo> optMission = missionDao.findById(missionId);
            if (optMission.isPresent()) {
                EmployeeDo employee = optEmployee.get();
                MissionDo mission = optMission.get();
                mission.setMissionAssignedTo(null);
                employee.setEmployeeMission(mission);
                employeeDao.save(employee);
                return;
            }

        }
        throw new ResourceNotFoundException(
                "No resource matching provided id has been found. Please provide valid id and retry");
    }

    @Override
    public void deleteMissionById(Long missionId) {
        if (missionId != null && missionId != 0) {
            missionDao.deleteById(missionId);
            return;
        }
        throw new NullBodyException(
                "The required parameter 'id' has not been provided. Please provide valid id and retry");
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