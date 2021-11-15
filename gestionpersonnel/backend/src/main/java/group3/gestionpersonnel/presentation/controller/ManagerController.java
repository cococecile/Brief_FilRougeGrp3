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

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/managers")
public class ManagerController {
	
	@Autowired
	private IManagerService managerService;
	
	@GetMapping
    public List<ManagerDto> getAllManagers() {
        return managerService.getAllManagers();
    }
	
	@GetMapping("/{id}")
	public ManagerDto getManagerById(@PathVariable(name = "id") Long managerId) {
	    return managerService.getManagerById(managerId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveManager(@RequestBody ManagerDto managerToCreate) {
        managerService.saveManager(managerToCreate);
    }
	
	@DeleteMapping("/{id}")
    public void deleteManagerById(@PathVariable(name = "id") Long managerId) {
        managerService.deleteManagerById(managerId);
    }

}
