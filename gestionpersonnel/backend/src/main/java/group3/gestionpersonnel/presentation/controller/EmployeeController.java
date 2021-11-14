package group3.gestionpersonnel.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import group3.gestionpersonnel.business.services.interfaces.IEmployeeService;
import group3.gestionpersonnel.presentation.model.EmployeeDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@GetMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable(name = "id") Long employeeId) {
	    return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(EmployeeDto employeeToCreate) {
        employeeService.saveEmployee(employeeToCreate);
    }
	
	@DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable(name = "id") Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

}
