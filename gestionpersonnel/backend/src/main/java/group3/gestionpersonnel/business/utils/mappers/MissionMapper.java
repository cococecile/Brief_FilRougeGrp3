package group3.gestionpersonnel.business.utils.mappers;

import org.modelmapper.ModelMapper;

import group3.gestionpersonnel.persistence.entitties.MissionDo;
import group3.gestionpersonnel.presentation.model.MissionDto;

public class MissionMapper {

    private ModelMapper mapper;
    private Object missionDo; 
    MissionDto mission = mapper.map(missionDo, MissionDto.class);

    public MissionDto convertToDto(MissionDo missionToConvert){

        return null;
    }


    
}
