package group3.gestionpersonnel.business.services.interfaces;

import java.util.List;

import group3.gestionpersonnel.presentation.model.DepartmentDto;

/**
 * This interface contains methods to be implemented by
 * {@link group3.gestionpersonnel.business.services.impl.DepartmentServiceImpl
 * DepartmentServiceImpl} Methods are CRUD operations.
 * 
 * @author Caroline(group3)
 */
public interface IDepartmentService {

    /**
     * Maps a {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     * DepartmentDto} to a
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo DepartmentDo} and
     * forwards it to {@link group3.gestionpersonnel.persistence.dao.IDepartmentDao
     * IDepartmentDao} for database insertion.
     * @return 
     */
    DepartmentDto saveDepartment(DepartmentDto departmentToCreate);


    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IDepartmentDao IDepartmentDao}
     * to retrieve the List of all
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo DepartmentDo}
     * then maps that List to a List of
     * {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto} and
     * returns it
     * 
     * @return a List of
     *         {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     *         DepartmentDto} retrieved from database
     */
    List<DepartmentDto> getAllDepartments();


    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IDepartmentDao IDepartmentDao}
     * to retrieve a {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} that has the given id, then maps it to its
     * {@link group3.gestionpersonnel.presentation.model.DepartmentDto DepartmentDto}
     * counterpart that is then returned
     * 
     * @param departmentId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *                  DepartmentDo} we want to retrieve
     * @return corresponding
     *         {@link group3.gestionpersonnel.presentation.model.DepartmentDto
     *         DepartmentDto}
     */
    DepartmentDto getDepartmentById(Long departmentId);


    /**
     * Calls {@link group3.gestionpersonnel.persistence.dao.IDepartmentDao IDepartmentDao}
     * to delete a {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     * DepartmentDo} thanks to its id.
     * 
     * @param departmentId the id of the
     *                  {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo
     *                  DepartmentDo} to delete.
     */
    void deleteDepartmentById(Long departmentId);

}
