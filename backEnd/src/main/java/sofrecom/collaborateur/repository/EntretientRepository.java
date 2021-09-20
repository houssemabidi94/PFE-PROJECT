package sofrecom.collaborateur.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.model.Entretien;

@Repository
public interface EntretientRepository extends JpaRepository<Entretien, Long>{

    @Query("select e from Entretien e join e.user u where u.id=:id")
	public Entretien findEntretienByUserId(@Param("id")long id);
    
    @Query("select e from Entretien e join e.user u join e.campagne c where u.id=:id and e.campagne.idCampagne=:campagneID")
 	public Entretien findEntretienByUserIdAndCompagne(@Param("id")long id,@Param("campagneID") String campagneID);
    
    @Query("select e from Entretien e join e.user u join e.campagne c where u.id=:id and c.idCampagne =:idCampagne")
	public List<Entretien> findCollabsEntretien(@Param("id")long id , @Param("idCampagne") String campagneID);
    
    
    @Query("select e from Entretien e where e.id=:id")
    public Entretien findEntretien(@Param("id")long id);
    
    @Query("select e.user from Entretien e where e.id=:id")
    public DAOUser findCollaborateurByEntretien(@Param("id")long id);
}
