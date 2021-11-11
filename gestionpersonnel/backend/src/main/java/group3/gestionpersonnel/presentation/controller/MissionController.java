package group3.gestionpersonnel.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import group3.gestionpersonnel.business.services.interfaces.IMissionService;
import group3.gestionpersonnel.presentation.model.MissionDto;

/**
 * This controller manages incoming API requests, passing them to corresponding
 * service and sending back accurate http responses.
 * 
 * It is the entry point for requests involving mission objects.
 * 
 * @author Caroline(group3)
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/mission")
public class MissionController {

    @Autowired
    private IMissionService service;

    /**
     * Entry point for create API Request. Calls the corresponding method in mission
     * service. If creation is successful, sends back a 201 HTTP code.
     * 
     * @param missionToCreate the
     *                        {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     *                        object we want to create.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMission(@RequestBody MissionDto missionToCreate) {

        service.saveMission(missionToCreate);

    }

    /**
     * Entry point for findall() API Request.
     * 
     * @return a list of all
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} with
     *         all dependencies
     *         ({@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto} and
     *         {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto})
     */
    @GetMapping
    public List<MissionDto> getAllMissions() {

        return service.getAllMissions();

    }

    /**
     * Entry point for getAllMissionsForDepartment API Request. Retrieves all the
     * {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} issued by a
     * {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto}.
     * 
     * @param departmentId the id of the
     *                     {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto}
     *                     of which we retrieve missions
     * @return a list of
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} that
     *         belong to the indicated department
     */
    @GetMapping("/fordepartment/{id}")
    public List<MissionDto> getAllMissionsForDepartment(@PathVariable(name = "id") Long departmentId) {

        return service.getAllMissionsForDepartment(departmentId);

    }

    /**
     * Entry point for getMissionById(id) API Request.
     * 
     * @param missionId the Id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo}
     *                  to retrieve
     * @return a {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     */
    @GetMapping("/{id}")
    public MissionDto getMissionById(@PathVariable(name = "id") Long missionId) {

        return service.getMissionById(missionId);
    }

    /**
     * Entry point for assignMissionToEmployee API Request
     * 
     * @param missionId  the ID of the
     *                   {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     *                   to assign to an
     *                   {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto}
     * @param employeeId the ID of the
     *                   {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto}
     *                   that we will assign
     *                   {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     *                   to.
     */
    @PatchMapping("/assign/{missionId}/to/{employeeId}")
    public void assignMissionToEmployee(@PathVariable(name = "missionId") Long missionId,
            @PathVariable(name = "employeeId") Long employeeId) {

        service.assignMissionToEmployee(missionId, employeeId);

    }

    /**
     * Entry point for deleteMissionById API Request.
     * 
     * @param missionId the id of the
     *                  {@link group3.gestionpersonnel.presentation.model.MissionDo MissionDo}
     *                  to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteMissionById(@PathVariable(name = "id") Long missionId) {
        service.deleteMissionById(missionId);
    }

}
