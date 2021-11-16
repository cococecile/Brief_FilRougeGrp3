package group3.gestionpersonnel.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import group3.gestionpersonnel.business.services.interfaces.IManagerService;
import group3.gestionpersonnel.presentation.model.ManagerDto;

/**
 * This controller manages incoming API requests, passing them to corresponding
 * service and sending back accurate http responses.
 * 
 * It is the entry point for requests involving Manager objects.
 * 
 * @author Alexandra HALL
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/managers")
public class ManagerController {
	
	@Autowired
	private IManagerService managerService;
	
	/**
     * Entry point for findall() API Request.
     * 
     * @return a list of all
     *         {@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto} with
     *         all dependencies
     *         ({@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto} (if any)
     *         and {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto})
     */
	@GetMapping
    public List<ManagerDto> getAllManagers() {
        return managerService.getAllManagers();
    }
	
	/**
     * Entry point for getManagerById(id) API Request.
     * 
     * @param missionId the Id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo}
     *                  to retrieve
     * @return a {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto}
     */
	@GetMapping("/{id}")
	public ManagerDto getManagerById(@PathVariable(name = "id") Long managerId) {
	    return managerService.getManagerById(managerId);
	}
	
	/**
     * Entry point for create API Request. Calls the corresponding method in ManagerServiceImpl. If creation is successful, sends back a 201 HTTP code.
     * 
     * @param managerToCreate the
     *                        {@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto}
     *                        to save in database.
     */
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ManagerDto saveManager(@RequestBody ManagerDto managerToCreate) {
       return managerService.saveManager(managerToCreate);
    }
	
	/**
     * Entry point for deleteManagerById API Request.
     * 
     * @param managerId the id of the
     *                  {@link group3.gestionpersonnel.presentation.model.ManagerDo ManagerDo}
     *                  to delete.
     */
	@DeleteMapping("/{id}")
    public void deleteManagerById(@PathVariable(name = "id") Long managerId) {
        managerService.deleteManagerById(managerId);
    }

}
