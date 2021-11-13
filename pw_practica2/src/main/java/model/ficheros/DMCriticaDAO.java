package model.ficheros;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.daos.CriticaDAO;
import model.data.Critica;



public class DMCriticaDAO implements CriticaDAO{

	ArrayList<Critica> criticas = new ArrayList<Critica>();

	public DMCriticaDAO() {
		
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
	public void insertar(Critica j) {
		criticas.add(j);
		
	}

	@Override
	public void modificar(Critica j) {
		
		for(int i = 0; i < criticas.size(); i++) {
			if(criticas.get(i).getIdCritica() == j.getIdCritica()) {
				criticas.remove(i);
				criticas.add(j);
			}
		}
		
	}

	@Override
	public void eliminar(Critica j) {
		
		for(int i = 0; i< criticas.size(); i++) {
			if(criticas.get(i) == j) {
				criticas.remove(i);
			}
		}
		
	}

	@Override
	public ArrayList<Critica> obtenerTodos() {
		// TODO Auto-generated method stub
		return criticas;
	}
	
	@Override
	public Critica obtener(String idCritica) {
		
		for(int i = 0; i <criticas.size(); i++) {
			if(criticas.get(i).getIdCritica() == idCritica) {
				return criticas.get(i);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream leerEntradas = new ObjectInputStream(new FileInputStream("src/Ficheros/Criticas.txt"));
		criticas = (ArrayList<Critica>)leerEntradas.readObject();
		leerEntradas.close();
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		
		ObjectOutputStream escribirEntradas = new ObjectOutputStream(new FileOutputStream("src/Ficheros/Criticas.txt"));
		escribirEntradas.writeObject(criticas);
		escribirEntradas.close();
		
	}



}
