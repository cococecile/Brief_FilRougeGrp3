package group3.gestionpersonnel.presentation.model;

import java.util.List;


public class ManagerDto {

	private Long managerId;
	private String managerFirstName;
	private String managerLastName;
	private String managerEmail;
	private DepartmentDto managerDepartment;
	private List<EmployeeDto> managedEmployees;
	
	
	public ManagerDto() {
		super();
	}
	
	public ManagerDto(Long managerId) {
		super();
		this.managerId = managerId;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerFirstName() {
		return managerFirstName;
	}

	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	public String getManagerLastName() {
		return managerLastName;
	}

	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public DepartmentDto getManagerDepartment() {
		return managerDepartment;
	}

	public void setManagerDepartment(DepartmentDto managerDepartment) {
		this.managerDepartment = managerDepartment;
	}

	public List<EmployeeDto> getManagedEmployees() {
		return managedEmployees;
	}

	public void setManagedEmployees(List<EmployeeDto> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
}
