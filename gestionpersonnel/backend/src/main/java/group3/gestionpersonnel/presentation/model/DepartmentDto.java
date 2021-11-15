package group3.gestionpersonnel.presentation.model;

import java.util.List;

/**
 * This class represents a Department Data Transfer Object
 * @see group3.gestionpersonnel.entitties.DepartmentDo
 * @author Caroline / Group3
 *
 */
public class DepartmentDto {
	
	private Long departmentId;
	private String departmentName;
	private List<EmployeeDto> departmentEmployees;
	private List<MissionDto> departmentMissions;
	private ManagerDto departmentChief;
	
	/**
	 * Default constructor
	 */
	public DepartmentDto() {}
	
	/**
	 * Constructor with ID of the object included.
	 * Rather use this constructor than setter if ID provision is required.
	 * @param departmentId the ID of the Department object.
	 */
	public DepartmentDto(final Long departmentId) {
		this.setDepartmentId(departmentId);
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @return the departmentEmployees
	 */
	public List<EmployeeDto> getDepartmentEmployees() {
		return departmentEmployees;
	}

	/**
	 * @return the departmentMissions
	 */
	public List<MissionDto> getDepartmentMissions() {
		return departmentMissions;
	}

	/**
	 * @return the departmentChief
	 */
	public ManagerDto getDepartmentChief() {
		return departmentChief;
	}

	/**
	 * @param departmentId the departmentId to set
	 * Rather use the constructor with ID param, if possible.
	 */
	public void setDepartmentId(final Long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(final String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @param departmentEmployees the departmentEmployees to set
	 */
	public void setDepartmentEmployees(final List<EmployeeDto> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}

	/**
	 * @param departmentMissions the departmentMissions to set
	 */
	public void setDepartmentMissions(final List<MissionDto> departmentMissions) {
		this.departmentMissions = departmentMissions;
	}

	/**
	 * @param departmentChief the departmentChief to set
	 */
	public void setDepartmentChief(final ManagerDto departmentChief) {
		this.departmentChief = departmentChief;
	} 
	
	
	
	

}
