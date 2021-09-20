package sofrecom.collaborateur.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sofrecom.collaborateur.config.JwtTokenUtil;
import sofrecom.collaborateur.model.DAOUser;
import sofrecom.collaborateur.repository.UserRepository;
import sofrecom.collaborateur.service.IUserService;
import sofrecom.collaborateur.serviceImpl.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	JwtTokenUtil jwt;
	
	@Autowired
	UserRepository userRepo;
	

	@GetMapping("profile")
	public DAOUser getUserByUserID(HttpServletRequest request) {
		
		long userId = userService.getCurrentUserId(request);
		DAOUser user = userRepo.findById(userId).get();
		return user;
	}
	@GetMapping("profile/{id}")
	public DAOUser getUser(HttpServletRequest request,@PathVariable long id) {
		
		DAOUser user = userRepo.findById(id).get();
		return user;
	}
	
	@GetMapping("/getmanager")
	public DAOUser getManagerID(HttpServletRequest request) {
		
		long userId = userService.getCurrentUserId(request);

		DAOUser man = userRepo.getManagerByUserId(userId);
				return man;
	}
	}
