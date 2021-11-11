package group3.gestionpersonnel.persistence.entitties;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents a Department entity.
 * A Department is managed by one manager, can have one or serveral employees
 * and a bunch of Missions attached to it.
 * @author Caroline(Group3)
 *
 */
@Entity
@Table(name="department")
public class DepartmentDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@OneToMany(mappedBy="employeeDepartment")
	private List<EmployeeDo> departmentEmployees;
	
	@OneToMany(mappedBy="missionIssuedBy")
	@JsonManagedReference
	private List<MissionDo>departmentMissionPool;
	
	@OneToOne (mappedBy="managerDepartment")
	private ManagerDo departmentChief;
	
	/**
	 * Default constructor
	 */
	public DepartmentDo() {}
	
	/**
	 * Constructor with id param.
	 * Rather use this constructor than setter
	 * @param departmentId the Id to assign as departmentId.
	 */
	public DepartmentDo(Long departmentId) {
		
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
	public List<EmployeeDo> getDepartmentEmployees() {
		return departmentEmployees;
	}

	/**
	 * @return the departmentMissionPool
	 */
	public List<MissionDo> getDepartmentMissionPool() {
		return departmentMissionPool;
	}

	/**
	 * @return the departmentChief
	 */
	public ManagerDo getDepartmentChief() {
		return departmentChief;
	}

	/**
	 * @param departmentId the departmentId to set
	 * Rather use constructor with id param than this setter. 
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
	public void setDepartmentEmployees(final List<EmployeeDo> departmentEmployees) {
		this.departmentEmployees = departmentEmployees;
	}

	/**
	 * @param departmentMissionPool the departmentMissionPool to set
	 */
	public void setDepartmentMissionPool(final List<MissionDo> departmentMissionPool) {
		this.departmentMissionPool = departmentMissionPool;
	}

	/**
	 * @param departmentChief the departmentChief to set
	 */
	public void setDepartmentChief(final ManagerDo departmentChief) {
		this.departmentChief = departmentChief;
	}

	
	@Override
	public String toString() {
		return "DepartmentDo [" + (departmentId != null ? "departmentId=" + departmentId + ", " : "")
				+ (departmentName != null ? "departmentName=" + departmentName + ", " : "")
				+ (departmentEmployees != null ? "departmentEmployees=" + departmentEmployees + ", " : "")
				+ (departmentMissionPool != null ? "departmentMissionPool=" + departmentMissionPool + ", " : "")
				+ (departmentChief != null ? "departmentChief=" + departmentChief : "") + "]";
	}
	
	
	

}
