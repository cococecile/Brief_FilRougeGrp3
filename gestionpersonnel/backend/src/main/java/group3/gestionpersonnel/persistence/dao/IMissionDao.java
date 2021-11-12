package group3.gestionpersonnel.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import group3.gestionpersonnel.persistence.entitties.MissionDo;

/**
 * This interface extends JpaRepository, replacing generic type with MissionDo
 * and Long objects. This is the interface that must be called by the
 * MissionService.
 * 
 * @author Caroline(group3)
 */
public interface IMissionDao extends JpaRepository<MissionDo, Long> {

}
