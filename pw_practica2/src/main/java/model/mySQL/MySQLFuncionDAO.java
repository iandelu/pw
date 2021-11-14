package model.mySQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.daos.DAOException;
import model.daos.FuncionDAO;
import model.data.Funcion;

public class MySQLFuncionDAO implements FuncionDAO {

	@Override
	public void insertar(Funcion f) throws DAOException {
		
		PreparedStatement stat = null;
        
		final String INSERT = "INSERT INTO Valoracion( id, autor, nota, critica) VALUES (?,?,?,?)"; 
		final String UPDATE = "UPDATE Valoracion SET id = ? , autor = ?, nota = ?, critica = ? WHERE id = ?";
	    final String DELETE = "DELETE FROM Valoracion WHERE id = ?";
	    final String GETALL = "SELECT id, autor, nota, critica FROM Usuarios";
	    final String GETONE = "SELECT id, autor, nota, critica FROM Usuarios WHERE id = ?";
	    
	    private Connection conn;
	    
	    public MySQLFuncionDAO(Connection conn) {
	        
	        this.conn = conn;
	        
	    }
		
        try{
            stat = conn.prepareStatement(INSERT);   
            
            stat.setLong(1, f.getIdValoracion());
            stat.setString(2, f.getAutor());
            stat.setInt(3, f.getNota());
            stat.setLong(4, f.getCritica());
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            
        } catch(SQLException ex){
            throw new DAOException("Error en SQL", ex);
        } finally{
            if (stat !=  null){
                
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }if(stat != null){
               
               try{
                   stat.close();
               }catch(SQLException ex){
                   new DAOException("Error en SQL", ex);
               }
               
           }
        }
		
	}

	@Override
	public void modificar(Funcion j) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Funcion j) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Funcion> obtenerTodos() throws DAOException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Funcion obtener(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

}
