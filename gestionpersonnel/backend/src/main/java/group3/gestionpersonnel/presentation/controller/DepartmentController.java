package group3.gestionpersonnel.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import group3.gestionpersonnel.business.services.interfaces.IDepartmentService;
import group3.gestionpersonnel.presentation.model.DepartmentDto;

/**
 * This controller manages incoming API requests, passing them to corresponding
 * service and sending back accurate http responses.
 * 
 * It is the entry point for requests involving
 * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo Department}
 * objects.
 * 
 * @author Caroline(group3)
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    /**
     * Entry point for create or delete API request Returns a 201 HTTP code if
     * request is successful.
     * 
     * @param departmentToCreate a
     *                           {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     *                           DepartmentDto} object to save in database
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentToCreate) {
        return service.saveDepartment(departmentToCreate);
    }

    /**
     * Entry point for getAllDepartments API Request. Retrieves all the
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} from database and returns it as a list of
     * {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     * DepartmentDto}
     * 
     * @return a list of
     *         {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     *         DepartmentDto}
     */
    @GetMapping
    public List<DepartmentDto> getAllDepartments() {
        return service.getAllDepartments();
    }

    /**
     * Entrypoint for GetDepartmentById API Request. Retrieves a
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} from database
     * 
     * @param departmentId the id of the
     *                     {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *                     DepartmentDo} to retrieve
     * @return a {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     *         DepartmentDto} containing retrieved data
     */
    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable(name = "id") Long departmentId) {
        return service.getDepartmentById(departmentId);
    }

    /**
     * Entrypoint for the deleteDepartmentById API Request. Deletes a
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} from database
     * 
     * CAUTION : deleting a
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} will also delete all employees, managers and missions pointing
     * to it!
     * 
     * @param departmentId the id of the
     *                     {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *                     DepartmentDo} to delete
     */
    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable(name = "id") Long departmentId) {
        service.deleteDepartmentById(departmentId);
    }

}
