package group3.gestionpersonnel.persistence.entitties;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@OneToOne
	@JoinColumn(name="fk_manager_department", nullable=false)
	@JsonBackReference
	private DepartmentDo managerDepartment;
	
	
	@OneToMany( targetEntity=EmployeeDo.class, mappedBy="employeeManagedBy", fetch = FetchType.LAZY )
	@JsonManagedReference
	private List<EmployeeDo> managedEmployees;
	
	public ManagerDo(){}
	
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


	public Long getManagerId() {
		return managerId;
	}


	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}


	public String getManagerFirstName() {
		return managerFirstName;
	}


	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}


	public String getManagerLastName() {
		return managerLastName;
	}


	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}


	public String getManagerEmail() {
		return managerEmail;
	}


	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}


	public DepartmentDo getManagerDepartment() {
		return managerDepartment;
	}


	public void setManagerDepartment(DepartmentDo managerDepartment) {
		this.managerDepartment = managerDepartment;
	}


	public List<EmployeeDo> getManagedEmployees() {
		return managedEmployees;
	}


	public void setManagedEmployees(List<EmployeeDo> managedEmployees) {
		this.managedEmployees = managedEmployees;
	}

	@Override
	public String toString() {
		return "ManagerDo [managedEmployees=" + managedEmployees + ", managerDepartment=" + managerDepartment
				+ ", managerEmail=" + managerEmail + ", managerFirstName=" + managerFirstName + ", managerId="
				+ managerId + ", managerLastName=" + managerLastName + "]";
	}
	
	
	

}