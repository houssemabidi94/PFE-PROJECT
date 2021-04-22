package sofrecom.collaborateur.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IUserService;

@Component
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtTokenUtil jwt;


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


	@Override
	public Long getCurrentUserId(HttpServletRequest request) {
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String jwtToken = requestTokenHeader.substring(7);

		String email = jwt.getUsernameFromToken(jwtToken);

		long userID = userRepository.getUserId(email);
		
		return userID;

	}

	

}