/**
<<<<<<< HEAD
 * Package Persistence/Entities.
 */
package group3.gestionpersonnel.persistence.entitties;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private EmployeeDo missionAssignedTo;
	
	@ManyToOne
	@Column(name="fk_mission_issued_by")
	@JoinColumn(name="department_id")
	@JsonBackReference
	private DepartmentDo missionIssuedBy;
	
	/**
	 * Default constructor
	 */
	public MissionDo() {}
	
	/**
	 * Constructor with Id param.Rather use this than id setter.
	 * @param missionId the id to be passed as missionId.
	 */
	public MissionDo(final Long missionId) {
		this.missionId = missionId;
	}
	

	/**
	 * @return the missionId
	 */
	public final Long getMissionId() {
		return missionId;
	}

	/**
	 * @return the missionName
	 */
	public final String getMissionName() {
		return missionName;
	}

	/**
	 * @return the missionStartDate
	 */
	public final Date getMissionStartDate() {
		return missionStartDate;
	}

	/**
	 * @return the missionEndDate
	 */
	public final Date getMissionEndDate() {
		return missionEndDate;
	}

	/**
	 * @return the missionDescription
	 */
	public final String getMissionDescription() {
		return missionDescription;
	}

	/**
	 * @return the missionType
	 */
	public final String getMissionType() {
		return missionType;
	}

	/**
	 * @return the missionAssignedTo
	 */
	public final EmployeeDo getMissionAssignedTo() {
		return missionAssignedTo;
	}

	/**
	 * @return the missionIssuedBy
	 */
	public final DepartmentDo getMissionIssuedBy() {
		return missionIssuedBy;
	}

	/**
	 * @param missionId the missionId to set
	 * Rather use constructor with Id param than this setter whenever it is 
	 * possible.
	 */
	public final void setMissionId(final Long missionId) {
		this.missionId = missionId;
	}

	/**
	 * @param missionName the missionName to set
	 */
	public final void setMissionName(final String missionName) {
		this.missionName = missionName;
	}

	/**
	 * @param missionStartDate the missionStartDate to set
	 */
	public final void setMissionStartDate(final Date missionStartDate) {
		this.missionStartDate = missionStartDate;
	}

	/**
	 * @param missionEndDate the missionEndDate to set
	 */
	public final void setMissionEndDate(final Date missionEndDate) {
		this.missionEndDate = missionEndDate;
	}

	/**
	 * @param missionDescription the missionDescription to set
	 */
	public final void setMissionDescription(final String missionDescription) {
		this.missionDescription = missionDescription;
	}

	/**
	 * @param missionType the missionType to set
	 */
	public final void setMissionType(final String missionType) {
		this.missionType = missionType;
	}

	/**
	 * @param missionAssignedTo the missionAssignedTo to set
	 */
	public final void setMissionAssignedTo(final EmployeeDo missionAssignedTo) {
		this.missionAssignedTo = missionAssignedTo;
	}

	/**
	 * @param missionIssuedBy the missionIssuedBy to set
	 */
	public final void setMissionIssuedBy(final DepartmentDo missionIssuedBy) {
		this.missionIssuedBy = missionIssuedBy;
	}
	
	
	
	
	
=======
 * 
 */
package group3.gestionpersonnel.persistence.entitties;

/**
 * @author Apprenant
 *
 */
public class MissionDo {
>>>>>>> parent of c43f06a... Merge pull request #7 from cococecile/revert-5-feat-Justine

}
