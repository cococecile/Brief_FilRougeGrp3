package group3.gestionpersonnel.persistence.entitties;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name= "employee")
public class EmployeeDo {
		
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="employee_firstname")
	private String employeeFirstName;
	
	@Column(name="employee_lastname")
	private String employeeLastName;
	
	@Column(name="employee_mail")
	private String employeeMail;
	
	@Column(name="employee_position")
	private String employeePosition;

		@ManyToOne(fetch = FetchType.LAZY, optional = false)
		@Column(name="fk_employee_managed_by")
	    @JoinColumn(name = "manager_id", nullable = false)
		@JsonIgnore
		private ManagerDo employeeManagedBy;
		
		@OneToOne( cascade = CascadeType.PERSIST )
		@Column(name="fk_mission_id")
	    @JoinColumn( name="mission_id" )
		private MissionDo employeeMission;
		
		
		public EmployeeDo(Long employeeId, String employeeFirstName, String employeeLastName, String employeeMail,
				String employeePosition, ManagerDo employeeManagedBy, MissionDo employeeMission) {
			super();
			this.employeeId = employeeId;
			this.employeeFirstName = employeeFirstName;
			this.employeeLastName = employeeLastName;
			this.employeeMail = employeeMail;
			this.employeePosition = employeePosition;
			this.employeeManagedBy = employeeManagedBy;
			this.employeeMission = employeeMission;
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


		public ManagerDo getEmployeeManagedBy() {
			return employeeManagedBy;
		}


		public void setEmployeeManagedBy(ManagerDo employeeManagedBy) {
			this.employeeManagedBy = employeeManagedBy;
		}


		public MissionDo getEmployeeMission() {
			return employeeMission;
		}


		public void setEmployeeMission(MissionDo employeeMission) {
			this.employeeMission = employeeMission;
		}

}
