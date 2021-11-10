package group3.gestionpersonnel.presentation.model;


public class EmployeeDto {
	
	private Long employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeeMail;
	private String employeePosition;
	private ManagerDto employeeManagedBy;
	private MissionDto employeeMission;
	private EmployeeDto employeeDepartment;
	
	
	public EmployeeDto() {
		super();
	}
	
	public EmployeeDto(Long employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public EmployeeDto(Long employeeId, String employeeFirstName, String employeeLastName, String employeeMail,
			String employeePosition, ManagerDto employeeManagedBy, MissionDto employeeMission,
			EmployeeDto employeeDepartment) {
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeMail() {
		return employeeMail;
	}

	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
	}

	public String getEmployeePosition() {
		return employeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}

	public ManagerDto getEmployeeManagedBy() {
		return employeeManagedBy;
	}

	public void setEmployeeManagedBy(ManagerDto employeeManagedBy) {
		this.employeeManagedBy = employeeManagedBy;
	}

	public MissionDto getEmployeeMission() {
		return employeeMission;
	}

	public void setEmployeeMission(MissionDto employeeMission) {
		this.employeeMission = employeeMission;
	}

	public EmployeeDto getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(EmployeeDto employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

}
