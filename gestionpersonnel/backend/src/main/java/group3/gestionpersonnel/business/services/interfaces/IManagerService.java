package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.ManagerDto;

/**
 * This interface contains methods to be implemented by
 * {@link group3.gestionpersonnel.business.services.impl.ManagerServiceImpl
 * ManagerServiceImpl} Methods are CRUD operations.
 * 
 * @author Alexandra HALL
 */
public interface IManagerService {

	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IManagerDao ManagerDao}
     * to retrieve a {@link group3.gestionpersonnel.persistence.entitties.ManagerDo
     * ManagerDo} that has the given id, then maps it to its
     * {@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto}
     * counterpart that is then returned
     * 
     * @param managerId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.ManagerDo
     *                  ManagerDo} we want to retrieve
     * @return corresponding
     *         {@link group3.gestionpersonnel.presentation.model.ManagerDto
     *         ManagerDto}
     */
	ManagerDto getManagerById(Long managerId);

	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IManagerDao IManagerDao}
     * to retrieve the List of all
     * {@link group3.gestionpersonnel.persistence.entitties.ManagerDo ManagerDo}
     * then maps that List to a List of
     * {@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto} and
     * returns it
     * 
     * @return a List of
     *         {@link group3.gestionpersonnel.presentation.model.ManagerDto
     *         ManagerDto} retrieved from database
     */
	List<ManagerDto> getAllManagers();

	/**
     * Maps a {@link group3.gestionpersonnel.presentation.model.ManagerDto
     * ManagerDto} to a
     * {@link group3.gestionpersonnel.persistence.entitties.Manager ManagerDo} and
     * forwards it to {@link group3.gestionpersonnel.persistence.dao.IManagerDao
     * IManagerDao} for database insertion.
     * @param managerToCreate = a Manager object which contains the information about the manager we need to create or update
     */
	void saveManager(ManagerDto managerToCreate);

	/**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IManagerDao IManagerDao}
     * to delete a {@link group3.gestionpersonnel.persistence.entitties.ManagerDo
     * ManagerDo} thanks to its id.
     * 
     * @param managerId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.ManagerDo
     *                  ManagerDo} to delete.
     */
	void deleteManagerById(Long managerId);

}
