package group3.gestionpersonnel.persistence.entitties;

public class EmployeeDo {
		
		private Long employeeId;
		private String employeeFirstName;
		private String employeeLastName;
		private String employeeMail;
		private String employeePosition;
		private ManagerDo employeeManagedBy;
		private Mission employeeMission;
		
		
		public EmployeeDo(Long employeeId, String employeeFirstName, String employeeLastName, String employeeMail,
				String employeePosition, ManagerDo employeeManagedBy, Mission employeeMission) {
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


		public Mission getEmployeeMission() {
			return employeeMission;
		}


		public void setEmployeeMission(Mission employeeMission) {
			this.employeeMission = employeeMission;
		}

}
