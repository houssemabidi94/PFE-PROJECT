package sofrecom.collaborateur.model;

import java.text.SimpleDateFormat;

public class DTOUser {
	private String fullname;
	private String email;
	private String username;
	private String password;
	private String matricule;
	private SimpleDateFormat dateIntegration;
	
	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matirucule) {
		this.matricule = matirucule;
	}

	public SimpleDateFormat getDateIntegration() {
		return dateIntegration;
	}

	public void setDateIntegration(SimpleDateFormat dateIntegration) {
		this.dateIntegration = dateIntegration;
	}
	
	
}