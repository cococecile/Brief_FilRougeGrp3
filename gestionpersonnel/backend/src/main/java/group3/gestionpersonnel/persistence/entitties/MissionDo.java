/**
 * Package Persistence/Entities.
 */
package group3.gestionpersonnel.persistence.entitties;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents a {@link MissionDo} entity, with annotations for Database
 * persistence / mapping. A mission can be assigned to one employee only, or
 * unassigned. A mission is always related to one department.
 * 
 * @author Caroline(Group3)
 *
 */
@Entity
@Table(name = "mission")
public class MissionDo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mission_id")
	private Long missionId;

	@Column(name = "mission_name")
	private String missionName;

	@Column(name = "mission_start_date")
	private String missionStartDate;

	@Column(name = "mission_end_date")
	private String missionEndDate;

	@Column(name = "mission_description")
	private String missionDescription;

	@Column(name = "mission_type")
	private String missionType;

	@OneToOne(mappedBy = "employeeMission")	
	@JsonManagedReference
	private EmployeeDo missionAssignedTo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_mission_issued_by", nullable = false)
	@JsonBackReference
	private DepartmentDo missionIssuedBy;

	/**
	 * Default constructor
	 */
	public MissionDo() {
	}

	/**
	 * Constructor with Id param.Rather use this than id setter.
	 * 
	 * @param missionId the id to be passed as missionId.
	 */
	public MissionDo(Long missionId) {
		this.missionId = missionId;
	}

	/**
	 * @return the missionId
	 */
	public Long getMissionId() {
		return missionId;
	}

	/**
	 * @return the missionName
	 */
	public String getMissionName() {
		return missionName;
	}

	/**
	 * @return the missionStartDate
	 */
	public String getMissionStartDate() {
		return missionStartDate;
	}

	/**
	 * @return the missionEndDate
	 */
	public String getMissionEndDate() {
		return missionEndDate;
	}

	/**
	 * @return the missionDescription
	 */
	public String getMissionDescription() {
		return missionDescription;
	}

	/**
	 * @return the missionType
	 */
	public String getMissionType() {
		return missionType;
	}

	/**
	 * @return the missionAssignedTo
	 */
	public EmployeeDo getMissionAssignedTo() {
		return missionAssignedTo;
	}

	/**
	 * @return the missionIssuedBy
	 */
	public DepartmentDo getMissionIssuedBy() {
		return missionIssuedBy;
	}

	/**
	 * @param missionId the missionId to set Rather use constructor with Id param
	 *                  than this setter whenever it is possible.
	 */
	public void setMissionId(Long missionId) {
		this.missionId = missionId;
	}

	/**
	 * @param missionName the missionName to set
	 */
	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	/**
	 * @param missionStartDate the missionStartDate to set
	 */
	public void setMissionStartDate(String missionStartDate) {
		this.missionStartDate = missionStartDate;
	}

	/**
	 * @param missionEndDate the missionEndDate to set
	 */
	public void setMissionEndDate(String missionEndDate) {
		this.missionEndDate = missionEndDate;
	}

	/**
	 * @param missionDescription the missionDescription to set
	 */
	public void setMissionDescription(String missionDescription) {
		this.missionDescription = missionDescription;
	}

	/**
	 * @param missionType the missionType to set
	 */
	public void setMissionType(String missionType) {
		this.missionType = missionType;
	}

	/**
	 * @param missionAssignedTo the missionAssignedTo to set
	 */
	public void setMissionAssignedTo(EmployeeDo missionAssignedTo) {
		this.missionAssignedTo = missionAssignedTo;
	}

	/**
	 * @param missionIssuedBy the missionIssuedBy to set
	 */
	public void setMissionIssuedBy(DepartmentDo missionIssuedBy) {
		this.missionIssuedBy = missionIssuedBy;
	}

	@Override
	public String toString() {
		return "MissionDo [" + (missionId != null ? "missionId=" + missionId + ", " : "")
				+ (missionName != null ? "missionName=" + missionName + ", " : "")
				+ (missionStartDate != null ? "missionStartDate=" + missionStartDate + ", " : "")
				+ (missionEndDate != null ? "missionEndDate=" + missionEndDate + ", " : "")
				+ (missionDescription != null ? "missionDescription=" + missionDescription + ", " : "")
				+ (missionType != null ? "missionType=" + missionType + ", " : "")
				+ (missionAssignedTo != null ? "missionAssignedTo=" + missionAssignedTo + ", " : "")
				+ (missionIssuedBy != null ? "missionIssuedBy=" + missionIssuedBy : "") + "]";
	}

}

