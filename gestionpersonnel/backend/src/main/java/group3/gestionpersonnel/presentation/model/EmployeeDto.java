package group3.gestionpersonnel.presentation.model;

/**
 * This class represents an Employee Data Transfer Object
 * @see group3.gestionpersonnel.entitties.EmployeeDo
 * @author Alexandra HALL
 *
 */
public class EmployeeDto {
	
	private Long employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeMail;
	private String employeePosition;
	private ManagerDto employeeManagedBy;
	private MissionDto employeeMission;
	private DepartmentDto employeeDepartment;
	
	/**
	 * Empty constructor
	 */
	public EmployeeDto() {
		super();
	}
	/**
	 * Empty constructor with an Id parameter (should not be needed)
	 * @param employeeId = the id of an employee with no information (yet)
	 */
	public EmployeeDto(Long employeeId) {
		super();
		this.employeeId = employeeId;
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
	public EmployeeDto(Long employeeId, String employeeFirstName, String employeeLastName, String employeeMail,
			String employeePosition, ManagerDto employeeManagedBy, MissionDto employeeMission,
			DepartmentDto employeeDepartment) {
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
	public ManagerDto getEmployeeManagedBy() {
		return employeeManagedBy;
	}

	/**
	 * This methods set a new value as the employeeManagedBy (manager) attribute
	 * @param employeeManagedBy = the new value
	 */
	public void setEmployeeManagedBy(ManagerDto employeeManagedBy) {
		this.employeeManagedBy = employeeManagedBy;
	}

	/**
	 * This method gets the mission assigned to the employee
	 * @return the employee's mission
	 */
	public MissionDto getEmployeeMission() {
		return employeeMission;
	}

	/**
	 * This methods set a new value as the employeeMission attribute
	 * @param employeeMission = the new value
	 */
	public void setEmployeeMission(MissionDto employeeMission) {
		this.employeeMission = employeeMission;
	}

	/**
	 * This method gets the employee's department
	 * @return the employee's department
	 */
	public DepartmentDto getEmployeeDepartment() {
		return employeeDepartment;
	}

	/**
	 * This methods set a new value as the employeeDepartment attribute
	 * @param employeeDepartment = the new value
	 */
	public void setEmployeeDepartment(DepartmentDto employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

}
