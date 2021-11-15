package group3.gestionpersonnel.presentation.model;

import java.util.List;

/**
 * This class represents a Manager Data Transfer Object
 * @see group3.gestionpersonnel.entitties.ManagerDo
 * @author Alexandra HALL
 *
 */
public class ManagerDto {

	private Long managerId;
	private String managerFirstName;
	private String managerLastName;
	private String managerEmail;
	private DepartmentDto managerDepartment;
	private List<EmployeeDto> managedEmployees;
	
	/**
	 * Empty constructor
	 */
	public ManagerDto() {
		super();
	}
	
	public ManagerDto(Long managerId) {
		super();
		this.managerId = managerId;
	}

	/**
	 * This method is used to get the attribute managerId
	 * @return the manager's id
	 */
	public Long getManagerId() {
		return managerId;
	}

	/**
	 * This method is used to set a new value to the attribute managerId
	 * @param managerId = the new value
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	/**
	 * This method is used to get the attribute managerFirstName
	 * @return the manager's first name
	 */
	public String getManagerFirstName() {
		return managerFirstName;
	}

	/**
	 * This method is used to set a new value to the attribute managerFirstName
	 * @param managerFirstName = the new value
	 */
	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}

	/**
	 * This method is used to get the attribute managerLastName
	 * @return the manager's last name
	 */
	public String getManagerLastName() {
		return managerLastName;
	}
	
	/**
	 * This method is used to set a new value to the attribute managerLastName
	 * @param managerLastName = the new value
	 */
	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}

	/**
	 * This method is used to get the attribute managerEmail
	 * @return the manager's email address
	 */
	public String getManagerEmail() {
		return managerEmail;
	}

	/**
	 * This method is used to set a new value to the attribute managerEmail
	 * @param managerEmail = the new value
	 */
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	/**
	 * This method is used to get the attribute managerDepartment
	 * @return the manager's department
	 */
	public DepartmentDto getManagerDepartment() {
		return managerDepartment;
	}

	/**
	 * This method is used to set a new value to the attribute managerDepartment
	 * @param managerDepartment = the new value
	 */
	public void setManagerDepartment(DepartmentDto managerDepartment) {
		this.managerDepartment = managerDepartment;
	}

	/**
	 * This method is used to get the attribute managedEmployees
	 * @return the list of the employees who work for the manager's department
	 */
	public List<EmployeeDto> getManagedEmployees() {
		return managedEmployees;
	}

	/**
	 * This method is used to set a new value to the attribute managedEmployees
	 * @param managerId = the new value (an updated list)
	 */
	public void setManagedEmployees(List<EmployeeDto> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}
	
}
