package group3.gestionpersonnel.persistence.entitties;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This class is used to build an {@link EmployeeDo} entity, with annotations for Database
 * persistence / mapping.
 * 
 * @author Alexandra HALL
 *
 */
@Entity
@Table(name = "employee")
public class EmployeeDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "employee_firstname")
	private String employeeFirstName;

	@Column(name = "employee_lastname")
	private String employeeLastName;

	@Column(name = "employee_mail")
	private String employeeMail;

	@Column(name = "employee_position")
	private String employeePosition;
	
	/**
	 * One employee only has one manager but only one manager can run the department the employees work for
	 * Fetchtype set to lazy to avoid infinite loops
	 * An employee has to work for a manager
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "fk_employee_managed_by", nullable = false)
	@JsonBackReference
	private ManagerDo employeeManagedBy;

	/**
	 * One employee can only be assigned one mission at a time and one mission can only be assigned to one employee at a time
	 */
	@OneToOne
	@JoinColumn(name = "fk_mission_id")
	@JsonBackReference
	private MissionDo employeeMission;

	/**
	 * One employee can only work for one department at a time but a department can have many employees
	 * fetchtype set to lazy to avoid infinite loops
	 * An employee needs to be assigned to a department to work
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_employee_department", nullable = false)
	@JsonBackReference
	private DepartmentDo employeeDepartment;

	/**
	 * Empty constructor
	 */
	public EmployeeDo() {
	}

	/**
	 * Constructor with every parameter.
	 * @param employeeId = The Id of the employee in the database
	 * @param employeeFirstName = The employee's first name
	 * @param employeeLastName = The employee's last name
	 * @param employeeMail = The employee's email address
	 * @param employeePosition = The employee's position in the company
	 * @param employeeManagedBy = The employee's manager
	 * @param employeeMission = The employee's mission (might not have a mission yet)
	 * @param employeeDepartment = The employee's department
	 */
	public EmployeeDo(Long employeeId, String employeeFirstName, String employeeLastName, String employeeMail,
			String employeePosition, ManagerDo employeeManagedBy, MissionDo employeeMission,
			DepartmentDo employeeDepartment) {
		super();
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeeMail = employeeMail;
		this.employeePosition = employeePosition;
		this.employeeManagedBy = employeeManagedBy;
		this.employeeMission = employeeMission;
		this.employeeDepartment = employeeDepartment;
	}

	/**
	 * This method gets the employee's Id
	 * @return the employee's Id
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * This methods set a new value as the employeeId attribute
	 * @param employeeId = the new value
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * This method gets the employee's first name
	 * @return the employee's first name
	 */
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	/**
	 * This methods set a new value as the firstName attribute
	 * @param employeeFirstName = the new value
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	/**
	 * This method gets the employee's name
	 * @return the employee's last name
	 */
	public String getEmployeeLastName() {
		return employeeLastName;
	}

	/**
	 * This methods set a new value as the employeeLastName attribute
	 * @param employeeLastName = the new value
	 */
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	/**
	 * This method gets the employee's email address
	 * @return the employee's email address
	 */
	public String getEmployeeMail() {
		return employeeMail;
	}

	/**
	 * This methods set a new value as the employeeMail attribute
	 * @param employeeMail = the new value
	 */
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	/**
	 * This method gets the employee's position
	 * @return the employee's position
	 */
	public String getEmployeePosition() {
		return employeePosition;
	}

	/**
	 * This methods set a new value as the employeePosition attribute
	 * @param employeePosition = the new value
	 */
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	/**
	 * This method gets the employee's manager
	 * @return the employee's manager
	 */
	public ManagerDo getEmployeeManagedBy() {
		return employeeManagedBy;
	}

	/**
	 * This methods set a new value as the employeeManagedBy (manager) attribute
	 * @param employeeManagedBy = the new value
	 */
	public void setEmployeeManagedBy(ManagerDo employeeManagedBy) {
		this.employeeManagedBy = employeeManagedBy;
	}

	/**
	 * This method gets the mission assigned to the employee
	 * @return the employee's mission
	 */
	public MissionDo getEmployeeMission() {
		return employeeMission;
	}

	/**
	 * This methods set a new value as the employeeMission attribute
	 * @param employeeMission = the new value
	 */
	public void setEmployeeMission(MissionDo employeeMission) {
		this.employeeMission = employeeMission;
	}

	/**
	 * This method gets the employee's department
	 * @return the employee's department
	 */
	public DepartmentDo getEmployeeDepartment() {
		return employeeDepartment;
	}

	/**
	 * This methods set a new value as the employeeDepartment attribute
	 * @param employeeDepartment = the new value
	 */
	public void setEmployeeDepartment(DepartmentDo employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	/**
	 * This method writes a string with all the employee's attributes
	 * @return a string with every attribute
	 */
	@Override
	public String toString() {
		return "EmployeeDo [employeeDepartment=" + employeeDepartment + ", employeeFirstName=" + employeeFirstName
				+ ", employeeId=" + employeeId + ", employeeLastName=" + employeeLastName + ", employeeMail="
				+ employeeMail + ", employeeManagedBy=" + employeeManagedBy + ", employeeMission=" + employeeMission
				+ ", employeePosition=" + employeePosition + "]";
	}

}