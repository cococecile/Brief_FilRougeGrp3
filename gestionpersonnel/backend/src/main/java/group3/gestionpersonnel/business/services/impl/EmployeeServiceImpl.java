package group3.gestionpersonnel.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import group3.gestionpersonnel.business.services.interfaces.EmployeeService;
import group3.gestionpersonnel.persistence.entitties.EmployeeDo;

public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeService employeeService;
	
	public List<EmployeeDo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeDo getById(Long id) {
		EmployeeDo employeeDo = employeeService.getById(id);
		return employeeDo;
	}

	public boolean save(EmployeeDo employeeDo) {
		// TODO Auto-generated method stub
		return false;
	}

	public Optional<EmployeeDo> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(EmployeeDo employeeDo) {
		return false;
	}

}
