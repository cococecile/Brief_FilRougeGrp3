/**
 * 
 */
package group3.gestionpersonnel.persistence.entitties;

import java.util.Date;

import javax.persistence.*;

import group3.gestionpersonnel.presentation.model.EmployeeDto;

/**
 * This class represents a Mission entity, with annotations for Database
 * persistence / mapping.
 * A mission can be assigned to one employee only, or unassigned.
 * A mission is always related to one department.
 * 
 * @author Caroline(Group3)
 *
 */
@Entity
@Table(name="mission")
public class MissionDo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long missionId;
	
	@Column(name="mission_name")
	private String missionName;
	
	@Column(name="mission_start_date")
	private Date missionStartDate;
	
	@Column(name="mission_end_date")
	private Date missionEndDate;
	
	@Column(name="mission_description")
	private String missionDescription;
	
	@Column(name="mission_type")
	private String missionType;
	
	@OneToOne(mappedBy="employeeMission")
	private EmployeeDo missionAssignedTo;
	
	@ManyToOne
	@Column(name="fk_mission_issued_by")
	@JoinColumn(name="department_id")
	
	private DepartmentDo missionIssuedBy;
	
	
	
	
	
	

}
