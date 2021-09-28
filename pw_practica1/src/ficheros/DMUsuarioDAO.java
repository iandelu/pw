package ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.UsuarioDAO;
import Data.Usuario;

public class DMUsuarioDAO implements UsuarioDAO {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	public DMUsuarioDAO() {
		
		try {
			this.cargarFichero();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void insertar(Usuario j) {
		// TODO Auto-generated method stub
		usuarios.add(j);
		
	}

	@Override
	public void modificar(Usuario j) {
		
		for(int i = 0; i< usuarios.size(); i++) {
			if(usuarios.get(i).getEmail() == j.getEmail()) {
				usuarios.remove(i);
				usuarios.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Usuario j) {

		usuarios.remove(j);
		
	}

	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	@Override
	public Usuario obtener(String nickname) {
		
		for(Usuario UsuarioAuxiliar : usuarios) {
			if(UsuarioAuxiliar.getNickname().equals(nickname)) {
				return UsuarioAuxiliar;
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerUsuarios = new ObjectInputStream(new FileInputStream("src/Ficheros/Usuarios.txt"));
		usuarios = (ArrayList<Usuario>)leerUsuarios.readObject();
		leerUsuarios.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirUsuarios = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Usuarios.txt"));
		escribirUsuarios.writeObject(usuarios);
		escribirUsuarios.close();
		
	}

}
