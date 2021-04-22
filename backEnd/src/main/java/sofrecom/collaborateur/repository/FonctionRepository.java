package sofrecom.collaborateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sofrecom.collaborateur.model.Fonction;

@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long>{
	
	@Query("select f.libelle from Fonction f join f.users u where u.id =:userID")
	public String getUserFonction(@Param("userID") long userID);

}
