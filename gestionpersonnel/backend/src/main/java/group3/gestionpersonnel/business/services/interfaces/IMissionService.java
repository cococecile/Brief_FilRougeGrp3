package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.MissionDto;

/**
 * This interface contains methods to be implemented by
 * {@link group3.gestionpersonnel.business.services.impl.MissionServiceImpl
 * MissionServiceImpl} It consists of CRUD operations sent by
 * {@link group3.gestionpersonnel.presentation.controller.MissionController
 * MissionController}
 * 
 * @author Caroline(group3)
 */
public interface IMissionService {

    /**
     * Maps a {@link group3.gestionpersonnel.presentation.model.MissionDto
     * MissionDto} to a
     * {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo} and
     * forwards it to {@link group3.gestionpersonnel.persistence.dao.IMissionDao
     * IMissionDao} for database insertion.
     */
    void saveMission(MissionDto missionToCreate);

    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IMissionDao IMissionDao}
     * to retrieve the List of all
     * {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo}
     * then maps that List to a List of
     * {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} and
     * returns it
     * 
     * @return a List of
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto
     *         MissionDto} retrieved from database
     */
    List<MissionDto> getAllMissions();

    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IMissionDao IMissionDao}
     * to retrieve the list of all
     * {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo}
     * issued by a {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} then maps it to a list of
     * {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} and
     * returns it
     * 
     * @param departmentId the id of the
     *                     {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *                     DepartmentDo} we want to retrieve mission of
     * @return a list of
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto
     *         MissionDto} issued by given
     *         {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *         DepartmentDo}
     */
    List<MissionDto> getAllMissionsForDepartment(Long departmentId);

    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IMissionDao IMissionDao}
     * to retrieve a {@link group3.gestionpersonnel.persistence.entitties.MissionDo
     * MissionDo} that has the given id, then maps it to its
     * {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     * counterpart that is then returned
     * 
     * @param missionId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.MissionDo
     *                  MissionDo} we want to retrieve
     * @return corresponding
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto
     *         MissionDto}
     */
    MissionDto getMissionById(Long missionId);

    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IMissionDao IMissionDao}
     * to link together a
     * {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo} and
     * a {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo EmployeeDo}
     * thanks to each object's id.
     * 
     * @param missionId  the id of the
     *                   {@link group3.gestionpersonnel.persistence.entitties.MissionDo
     *                   MissionDo} to assign to an employee
     * @param employeeId the id of the
     *                   {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo
     *                   EmployeeDo} to be assigned a mission
     */
    void assignMissionToEmployee(Long missionId, Long employeeId);

    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IMissionDao IMissionDao}
     * to delete a {@link group3.gestionpersonnel.persistence.entitties.MissionDo
     * MissionDo} thanks to its id.
     * 
     * @param missionId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.MissionDo
     *                  MissionDo} to delete.
     */
    void deleteMissionById(Long missionId);

}
