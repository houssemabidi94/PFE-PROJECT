package sofrecom.collaborateur.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sofrecom.collaborateur.model.DAOUser;


public interface IUserService {
	List<DAOUser> getAllUsers();
	public DAOUser getUserByUsername(String username);
	public DAOUser getUserByEmail(String email);
	Long getCurrentUserId(HttpServletRequest request);
}
