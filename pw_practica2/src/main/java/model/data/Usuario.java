package model.data;

import java.io.Serializable;



public class Usuario implements Serializable{

	private String nombre;
	private String apellidos;
	private Email email;
	private String nickname;
	private String password;
	
	public Usuario(String nombre, String apellidos, String email, String nickname, String password) throws Exception {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.setEmail(email);
		this.nickname = nickname;
		this.password = password;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email.getEmail();
	}
	public void setEmail(String email) throws Exception {
		Email nuevoEmail = new Email(email);
		this.email = nuevoEmail;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", nickname=" + nickname
				+ ", password=" + password + "]";
	}

	
	
	
		
}
