package group3.gestionpersonnel.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import group3.gestionpersonnel.persistence.entitties.MissionDo;

/**
 * This interface extends JpaRepository, replacing generic type with MissionDo
 * and Long objects. This is the interface that must be called by the
 * MissionService.
 * 
 * @author Caroline(group3)
 */
@Repository
@Transactional
public interface IMissionDao extends JpaRepository<MissionDo, Long> {

}
