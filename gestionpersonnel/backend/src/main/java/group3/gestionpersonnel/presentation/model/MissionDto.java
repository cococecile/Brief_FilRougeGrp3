/**
 * 
 */
package group3.gestionpersonnel.presentation.model;

import java.util.Date;

/**
 * This class represents a Mission Data Transfert object.
 * @See {@link MissionDo}
 * @author Caroline (Group3)
 */
public class MissionDto {
	
	private Long missionId;
	private String missionName;
	private Date missionStartDate;
	private Date missionEndDate;
	private String missionDescription;
	private String missionType;
	private EmployeeDto missionAssignedTo;
	
	/**
	 * Default constructor
	 */
	public MissionDto() {}
	
	/**
	 * Constructor with ID of the object included.
	 * Rather use this constructor than setter if ID provision is required.
	 * @param id the ID of the Mission object.
	 */
	public MissionDto(Long id) {
		this.missionId = id;
	}
	
	

}
