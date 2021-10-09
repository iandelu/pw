package ficheros;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DAOS.EspectaculoDAO;
import Data.Espectaculo;
import Data.Usuario;

public class DMEspectaculoDAO implements EspectaculoDAO{

ArrayList<Espectaculo> espectaculos = new ArrayList<Espectaculo>();
	
	
	public DMEspectaculoDAO() {
		
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
	public void insertar(Espectaculo j) {
		// TODO Auto-generated method stub
		espectaculos.add(j);
		
	}

	@Override
	public void modificar(Espectaculo j) {
		
		for(int i = 0; i< espectaculos.size(); i++) {
			if(espectaculos.get(i).getIdEspectaculo() == j.getIdEspectaculo()) {
				espectaculos.remove(i);
				espectaculos.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Espectaculo j) {

		espectaculos.remove(j);
		
	}

	@Override
	public List<Espectaculo> obtenerTodos() {
		// TODO Auto-generated method stub
		return espectaculos;
	}

	@Override
	public Espectaculo obtener(String id) {
		
		for(Espectaculo UsuarioAuxiliar : espectaculos) {
			if(UsuarioAuxiliar.getIdEspectaculo().equals(id)) {
				return UsuarioAuxiliar;
			}
		}
		
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerEspectaculos = new ObjectInputStream(new FileInputStream("src/Ficheros/Espectaculos.txt"));
		espectaculos = (ArrayList<Espectaculo>)leerEspectaculos.readObject();
		leerEspectaculos.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirEspectaculos = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Especatulos.txt"));
		escribirEspectaculos.writeObject(espectaculos);
		escribirEspectaculos.close();
		
	}

	
}
