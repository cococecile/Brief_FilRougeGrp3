package group3.gestionpersonnel.business.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import group3.gestionpersonnel.business.services.interfaces.IDepartmentService;
import group3.gestionpersonnel.presentation.model.DepartmentDto;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Override
    public void saveDepartment(DepartmentDto departmentToCreate) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        // TODO Auto-generated method stub
        
    }
    
}
