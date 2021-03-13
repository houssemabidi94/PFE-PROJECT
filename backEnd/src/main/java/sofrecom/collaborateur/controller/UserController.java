package sofrecom.collaborateur.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userService;
	
	@Autowired
	JwtTokenUtil jwt;
	
	@Autowired
	UserRepository userRepo;


	@GetMapping("profile")
	public List<DAOUser> getUserByUserID(HttpServletRequest request) {
		final String requestTokenHeader = request.getHeader("Authorization");
		String jwtToken = requestTokenHeader.substring(7);

		String email = jwt.getUsernameFromToken(jwtToken);

		long userID = userRepo.getUserId(email);

		List<DAOUser> user = userRepo.findById(userID);
		return user;
	}
	}
