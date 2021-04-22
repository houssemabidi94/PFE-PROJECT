package sofrecom.collaborateur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sofrecom.collaborateur.model.Objectif;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {

	@Query("select o from Objectif o join o.campagne c join o.user u where c.idCampagne =:idCampagne and u.id =:idUser")
	public List<Objectif> findObjectif(@Param("idCampagne") String campagneID,@Param("idUser") long userID);

	@Query("select o from Objectif o join o.campagne c join o.user u where c.idCampagne =:idCampagne and u.id =:idUser")
	public List<Objectif> findObjectifsList(@Param("idCampagne") String campagneID,@Param("idUser") List<Long> userID);
		
    @Query("select o from Objectif o where o.id=:id")
    public Objectif findByIdObjectif(@Param("id")long id);
}
