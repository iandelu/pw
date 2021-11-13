package Data;

import java.io.Serializable;

public class Usuario implements Serializable{

	private String nombre;
	private String apellidos;
	private Email email;
	private String nickname;
	private String tipoUsuario;
	
	public Usuario(String nombre, String apellidos, Email email, String nickname) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nickname = nickname;
		this.tipoUsuario  = "Espectador";
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
	public void setEmail(Email email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", nickname=" + nickname
				+ "]";
	}
	
	
	
		
}
