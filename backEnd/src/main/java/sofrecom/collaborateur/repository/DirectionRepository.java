package sofrecom.collaborateur.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sofrecom.collaborateur.model.Direction;

@Repository
public interface DirectionRepository extends CrudRepository<Direction, Long> {
	


}
