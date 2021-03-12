package sofrecom.collaborateur.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IUserService;

@Component
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public DAOUser getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public DAOUser getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<DAOUser> getAllUsers() {
		return (List<DAOUser>) userRepository.findAll();
	}


	public static Long getCurrentUserId() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		String id = null;
		if (authentication != null)
			if (authentication.getPrincipal() instanceof UserDetails)
				id = ((UserDetails) authentication.getPrincipal()).getUsername();
			else if (authentication.getPrincipal() instanceof String)
				id = (String) authentication.getPrincipal();
		try {
			return Long.valueOf(id != null ? id : "1"); // anonymoususer
		} catch (NumberFormatException e) {
			return 1L;
		}
	}

}