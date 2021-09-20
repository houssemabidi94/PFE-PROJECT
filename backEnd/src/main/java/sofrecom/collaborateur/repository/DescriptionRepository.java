package sofrecom.collaborateur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sofrecom.collaborateur.model.Description;
import sofrecom.collaborateur.model.DescriptionPK;

public interface DescriptionRepository extends CrudRepository<Description, Long> {

	Description findByDescriptionPK(DescriptionPK descPK);
	
	@Query("select d from Description d where d.descriptionPK.idCompetence=:id")
	List<Description> findByCompetenceId(@Param("id")long id);

	
}
