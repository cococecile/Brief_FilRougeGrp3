package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.DepartmentDto;

public interface IDepartmentService {

    void saveDepartment(DepartmentDto departmentToCreate);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

}
