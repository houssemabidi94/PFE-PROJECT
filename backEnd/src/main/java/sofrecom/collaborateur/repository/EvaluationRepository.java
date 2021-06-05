package sofrecom.collaborateur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sofrecom.collaborateur.model.Evaluation;


public interface EvaluationRepository extends CrudRepository<Evaluation, Long> {
	
    @Query("select e from Evaluation e join e.user u where u.id=:userId and e.evaluationPK.idCompetence=:compId")
    public List<Evaluation> getEvalByUserId(@Param("userId")long id,@Param("compId")long compId);
}
