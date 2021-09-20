package sofrecom.collaborateur.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sofrecom.collaborateur.model.Competence;

public interface CompetenceRepository extends CrudRepository<Competence, Long> {
	
	
    @Query("select c from Competence c where c.id=:id")
    public Competence findByIdCompetence(@Param("id")long id);
}
