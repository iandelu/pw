package model.data;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;



public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private Email email;
	private String nickname;
	private String password;
	private String tipoUsuario;
	private Date registro;
	private Date sesion;
	
	public Usuario(String nombre, String apellidos, String email, String nickname, String password) throws Exception {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.setEmail(email);
		this.nickname = nickname;
		this.password = password;
		this.tipoUsuario = "ESPECTADOR";
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

	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Date getRegistro() {
		return registro;
	}


	public void setRegistro(Date registro) {
		this.registro = registro;
	}


	public Date getSesion() {
		return sesion;
	}


	public void setSesion(Date sesion) {
		this.sesion = sesion;
	}

	
		
}
