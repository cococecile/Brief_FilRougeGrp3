package group3.gestionpersonnel.business.utils.mappers;

import org.modelmapper.ModelMapper;

/**
 * The purpose of this class is to customise ModelMapper with some propertyMaps,
 * in order to prevent circular mapping to occur while mapping do classes to
 * their dto counterparts.
 * 
 * Every method (and, hence, returned mapper) is static to avoid stackoverflow
 * errors because a PropertyMap can only be set once to a mapper.
 * 
 * @author Caroline(group3)
 */
public class PreventRecursiveMapper {

    private static DependencyRemover remover = new DependencyRemover();

    /**
     * Instantiates a new ModelMapper object and customizes it for the mapping of an
     * Employee object.
     * 
     * @return a mapper customized for Employee objects (by removing dependencies of
     *         dependencies)
     */
    public static ModelMapper getEmployeeMapper() {
        ModelMapper mapper = new ModelMapper();
        remover.skipMissionNestedFields(mapper);
        remover.skipManagerNestedFields(mapper);
        remover.skipDepartmentNestedFields(mapper);
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }

    /**
     * Instantiates a new ModelMapper object and customizes it for the mapping of a
     * Department object.
     * 
     * @return a mapper customized for Department objects (by removing dependencies of
     *         dependencies)
     */
    public static ModelMapper getDepartmentMapper() {
        ModelMapper mapper = new ModelMapper();
        remover.skipMissionNestedFields(mapper);
        remover.skipEmployeeNestedFields(mapper);
        remover.skipManagerNestedFields(mapper);
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }

     /**
     * Instantiates a new ModelMapper object and customizes it for the mapping of a
     * Manager object.
     * 
     * @return a mapper customized for Manager objects (by removing dependencies of
     *         dependencies)
     */
    public static ModelMapper getManagerMapper() {
        ModelMapper mapper = new ModelMapper();
        remover.skipDepartmentNestedFields(mapper);
        remover.skipEmployeeNestedFields(mapper);
        remover.skipMissionNestedFields(mapper);
        return mapper;
    }

     /**
     * Instantiates a new ModelMapper object and customizes it for the mapping of a
     * Mission object.
     * 
     * @return a mapper customized for Mission objects (by removing dependencies of
     *         dependencies)
     */
    public static ModelMapper getMissionMapper() {
        ModelMapper mapper = new ModelMapper();
        remover.skipDepartmentNestedFields(mapper);
        remover.skipEmployeeNestedFields(mapper);
        remover.skipManagerNestedFields(mapper);
        return mapper;
    }

}
