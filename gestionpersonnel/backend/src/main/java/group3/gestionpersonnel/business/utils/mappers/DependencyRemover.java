package group3.gestionpersonnel.business.utils.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import group3.gestionpersonnel.persistence.entitties.*;
import group3.gestionpersonnel.presentation.model.*;

/**
 * This class contains methods to indicate a mapper to skip some nested fields.
 * The purpose of this class is to configure the ModelMapper to map Do from
 * Database with Dto without nested circular dependencies.
 * 
 * Those configurations are used in the {@link PreventRecursiveMapper} class.
 * 
 * This class acts as a workaround to solve a circular dependencies mapping
 * issue.
 * 
 * @author Caroline(group3)
 */
public class DependencyRemover {

    /**
     * Default constructor
     */
    public DependencyRemover() {
    }

    /**
     * During the mapping of a
     * {@link group3.gestionpersonnel.persistence.entitties.MissionDo MissionDo} to
     * a {@link group3.gestionpersonnel.presentation.model.MissionDto MissionDto},
     * skip all nested objects. This method must be used in every mapper but Mission
     * mappers.
     * 
     * @param mapper the mapper to which this configuration will be added.
     */
    public void skipMissionNestedFields(ModelMapper mapper) {
        mapper.addMappings(new PropertyMap<MissionDo, MissionDto>() {
            @Override
            protected void configure() {
                skip(destination.getMissionIssuedBy());
                skip(destination.getMissionAssignedTo());
            }
        });
    }

    /**
     * During the mapping of a
     * {@link group3.gestionpersonnel.persistence.entitties.EmployeeDo EmployeeDo}
     * to a {@link group3.gestionpersonnel.presentation.model.EmployeeDto
     * EmployeeDto}, skip all nested objects of those Employee objects. This method must be used
     * in every mapper but Employee mappers.
     * 
     * @param mapper the mapper to which this configuration will be added.
     */
    public void skipEmployeeNestedFields(ModelMapper mapper) {
        mapper.addMappings(new PropertyMap<EmployeeDo, EmployeeDto>() {

            @Override
            protected void configure() {
                skip(destination.getEmployeeDepartment());
                skip(destination.getEmployeeManagedBy());
                skip(destination.getEmployeeMission());
            }
        });
    }

    /**
     * During the mapping of a 
     * {@link group3.gestionpersonnel.persistence.entitties.ManagerDo ManagerDo}
     * to a {@link group3.gestionpersonnel.presentation.model.ManagerDto ManagerDto}
     * skip all nested objects of those Manager objects. This method must be used in every mapper but 
     * Manager mappers.
     * 
     * @param mapper the mapper to which this configuration will be added.
     */
    public void skipManagerNestedFields(ModelMapper mapper) {
        mapper.addMappings(new PropertyMap<ManagerDo, ManagerDto>() {
            @Override
            protected void configure() {
                skip(destination.getManagedEmployees());
                skip(destination.getManagerDepartment());
            }
        });

    }

    /**
      * During the mapping of a 
     * {@link group3.gestionpersonnel.persistence.entitties.DepartmentDo Department Do}
     * to a {@link group3.gestionpersonnel.presentation.model.DepartmentDto Department Dto}
     * skip all nested objects of those Department objects. This method must be used in every mapper but 
     * Department mappers.
     * 
     * @param mapper the mapper to which this configuration will be added.
     */
    public void skipDepartmentNestedFields(ModelMapper mapper) {
        mapper.addMappings(new PropertyMap<DepartmentDo, DepartmentDto>() {

            @Override
            protected void configure() {
                skip(destination.getDepartmentChief());
                skip(destination.getDepartmentEmployees());
                skip(destination.getDepartmentMissions());
            }

        });

    }
}
