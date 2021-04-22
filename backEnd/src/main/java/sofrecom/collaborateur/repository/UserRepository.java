package sofrecom.collaborateur.repository;




import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sofrecom.collaborateur.model.DAOUser;



@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
	public DAOUser findByUsername(String username);
	public DAOUser findByEmail(String email);

	
	@Query("select u.id from DAOUser u where u.email =:email")
	public long getUserId(@Param("email") String email);
	
	@Query("select u.id from DAOUser u where u.manager_id =:managerID")
	public List<Long> getUsersIdByManagerId(@Param("managerID") long managerID);
}