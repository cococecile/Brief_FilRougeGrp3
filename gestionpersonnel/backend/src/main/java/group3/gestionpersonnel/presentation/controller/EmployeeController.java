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

import group3.gestionpersonnel.business.services.interfaces.IEmployeeService;
import group3.gestionpersonnel.presentation.model.EmployeeDto;

/**
 * This controller manages incoming API requests, passing them to corresponding
 * service and sending back accurate http responses.
 * 
 * It is the entry point for requests involving Employee objects.
 * 
 * @author Alexandra HALL
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	/**
     * Entry point for findall() API Request.
     * 
     * @return a list of all
     *         {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto} with
     *         all dependencies
     *         ({@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto},
     *         {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto} (if any)
     *         and {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto})
     */
	@GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	/**
     * Entry point for getEmployeeById(id) API Request.
     * 
     * @param employeeId the Id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo EmployeeDo}
     *                  to retrieve
     * @return a {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto}
     */
	@GetMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable(name = "id") Long employeeId) {
	    return employeeService.getEmployeeById(employeeId);
	}
	
	/**
     * Entry point for create API Request. Calls the corresponding method in mission
     * service. If creation is successful, sends back a 201 HTTP code.
     * 
     * @param employeeToCreate the
     *                        {@link group3.gestionpersonnel.presentation.model.EmployeeDto EmployeeDto}
     *                        to save in database.
     */
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeToCreate) {
       return employeeService.saveEmployee(employeeToCreate);
    }
	
	/**
     * Entry point for deleteEmployeeById API Request.
     * 
     * @param employeeId the id of the
     *                  {@link group3.gestionpersonnel.presentation.model.EmployeeDo EmployeeDo}
     *                  to delete.
     */
	@DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable(name = "id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

}
