package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.ManagerDto;

public interface IManagerService {

	ManagerDto getManagerById(Long managerId);

	List<ManagerDto> getAllManagers();

	void saveManager(ManagerDto managerToCreate);

	void deleteManagerById(Long managerId);

}
