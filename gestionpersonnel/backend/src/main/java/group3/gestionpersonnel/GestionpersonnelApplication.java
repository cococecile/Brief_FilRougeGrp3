package group3.gestionpersonnel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionpersonnelApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionpersonnelApplication.class, args);

		/* TODO : test and remove
		ModelMapper modelMapper = new ModelMapper();
		MissionDo missionDo = new MissionDo((long) 3);
		missionDo.setMissionName("MissionDO");
		MissionDto missionDto = modelMapper.map(missionDo, MissionDto.class);
		System.out.println(missionDto.toString());	*/
		


	}

}
