package view;

import java.io.Serializable;


public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email = null;
	private String nombre = null;
	private String apellidos = null;
	
	private int loginAttempts = 0;


	public Long getID() {
		return id;
	}
	

	public void setID(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getFirstname() {
		return nombre;
	}

	public void setFirstname(String firstname) {
		this.nombre = firstname;
	}
	

	public String getLastname() {
		return apellidos;
	}

	public void setLastname(String lastname) {
		this.apellidos = lastname;
	}
	
	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}
		
}