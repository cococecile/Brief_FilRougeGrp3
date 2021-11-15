package group3.gestionpersonnel.persistence.entitties;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class is used to build a {@link ManagerDo} entity, with annotations for Database
 * persistence / mapping.
 * 
 * @author Alexandra HALL
 *
 */
@Entity
@Table(name="manager")
public class ManagerDo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="manager_id")
	private Long managerId;
	
	@Column(name="manager_firstname")
	private String managerFirstName;
	
	@Column(name="manager_lastname")
	private String managerLastName;
	
	@Column(name="manager_email")
	private String managerEmail;
	
	/**
	 * One manager runs only one department and one department only has one manager
	 */
	@OneToOne
	@JoinColumn(name="fk_manager_department")
	@JsonBackReference
	private DepartmentDo managerDepartment;
	
	
	/**
	 * One manager can have many employees working in their department but employees can only work in one department at a time
	 * fetchtype set to lazy to avoid infinite loops
	 */
	@OneToMany( targetEntity=EmployeeDo.class, mappedBy="employeeManagedBy", fetch = FetchType.LAZY )
	@JsonManagedReference
	private List<EmployeeDo> managedEmployees;
	
	/**
	 * empty constructor
	 */
	public ManagerDo(){}
	
	/**
	 * a constructor with all the manager's attributes
	 * @param managerId = the manager's id in the database
	 * @param managerFirstName = the manager's first name
	 * @param managerLastName = the manager's last name
	 * @param managerEmail = the manager's email address
	 * @param managerDepartment = the department run by the manager
	 * @param managedEmployees = the employees working for the manager's department
	 */
	public ManagerDo(Long managerId, String managerFirstName, String managerLastName, String managerEmail,
			DepartmentDo managerDepartment, List<EmployeeDo> managedEmployees) {
		super();
		this.managerId = managerId;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.managerEmail = managerEmail;
		this.managerDepartment = managerDepartment;
		this.managedEmployees = managedEmployees;
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
	public DepartmentDo getManagerDepartment() {
		return managerDepartment;
	}


	/**
	 * This method is used to set a new value to the attribute managerDepartment
	 * @param managerDepartment = the new value
	 */
	public void setManagerDepartment(DepartmentDo managerDepartment) {
		this.managerDepartment = managerDepartment;
	}


	/**
	 * This method is used to get the attribute managedEmployees
	 * @return the list of the employees who work for the manager's department
	 */
	public List<EmployeeDo> getManagedEmployees() {
		return managedEmployees;
	}


	/**
	 * This method is used to set a new value to the attribute managedEmployees
	 * @param managerId = the new value (an updated list)
	 */
	public void setManagedEmployees(List<EmployeeDo> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}

	/**
	 * This method writes a manager object as a String
	 * @return a String with all the manager's attributes
	 */
	@Override
	public String toString() {
		return "ManagerDo [managedEmployees=" + managedEmployees + ", managerDepartment=" + managerDepartment
				+ ", managerEmail=" + managerEmail + ", managerFirstName=" + managerFirstName + ", managerId="
				+ managerId + ", managerLastName=" + managerLastName + "]";
	}
	
	
	

}