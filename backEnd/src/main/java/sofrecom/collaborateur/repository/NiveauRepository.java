package sofrecom.collaborateur.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sofrecom.collaborateur.model.Competence;
import sofrecom.collaborateur.model.Niveau;

public interface NiveauRepository extends CrudRepository<Niveau, Long> {
	
	
    @Query("select n from Niveau n where n.id=:id")
    public Niveau findByIdNiv(@Param("id")long id);
}
