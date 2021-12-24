package model.mySQL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.daos.DAOException;
import model.daos.ValoracionDAO;
import model.data.Usuario;
import model.data.Valoracion;

public class MySQLValoracionDAO implements ValoracionDAO{

	final String INSERT = "INSERT INTO Valoracion( id, autor, nota, critica) VALUES (?,?,?,?)"; 
	final String UPDATE = "UPDATE Valoracion SET id = ? , autor = ?, nota = ?, critica = ? WHERE id = ?";
    final String DELETE = "DELETE FROM Valoracion WHERE id = ?";
    final String GETALL = "SELECT id, autor, nota, critica FROM Usuarios";
    final String GETONE = "SELECT id, autor, nota, critica FROM Usuarios WHERE id = ?";
    
    private Connection conn;
    
    public MySQLValoracionDAO(Connection conn) {
        
        this.conn = conn;
        
    }
	
	@Override
	public void insertar(Valoracion v) throws DAOException {
		
		PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);   
            
            stat.setLong(1, v.getIdValoracion());
            stat.setString(2, v.getAutor());
            stat.setInt(3, v.getNota());
            stat.setLong(4, v.getCritica());
            
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
	public void modificar(Valoracion v) throws DAOException {

		PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(UPDATE);   
            
            stat.setLong(1, v.getIdValoracion());
            stat.setString(2, v.getAutor());
            stat.setInt(3, v.getNota());
            stat.setLong(4, v.getCritica());
            stat.setLong(5, v.getIdValoracion());
            
            
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
	public void eliminar(Valoracion v) throws DAOException {
		PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, v.getIdValoracion());

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
            }
        }
		
	}
	
	private Valoracion convertir(ResultSet rs) throws Exception{
	
        Long idValoracion = rs.getLong("id");
        String autor = rs.getString("autor");
        int nota = rs.getInt("nota");
        Long critica = rs.getLong("critica");
        
        Valoracion v = new Valoracion(autor,nota,critica);
        
        return v;
        
    }

	@Override
	public List<Valoracion> obtenerTodos() throws DAOException, Exception {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Valoracion> valoraciones = new ArrayList<>();
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETALL);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			    	   valoraciones.add(convertir(rs));
			           
			       }
			       
			   }catch(SQLException ex){
			        throw new DAOException("Error en SQL", ex);
			   }finally{
			       
			       if(rs != null){
			           
			           try{
			               rs.close();
			           }catch(SQLException ex){
			               new DAOException("Error en SQL", ex);
			           }
			           
			       }
			       if(stat != null){
			           
			           try{
			               stat.close();
			           }catch(SQLException ex){
			               new DAOException("Error en SQL", ex);
			           }
			           
			       }
			   }
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	        return valoraciones;
	}

	@Override
	public Valoracion obtener(Long id) throws Exception {
		PreparedStatement stat = null;
	       ResultSet rs = null;
	       Valoracion v = null;
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETONE);
			       stat.setLong(1, id);
			       rs = stat.executeQuery();
			       if(rs.next()){
			           
			           v = convertir(rs);
			           
			       }else{
			           throw new DAOException("No se ha encontrado ese registro.");
			       }
			       
			   }catch(SQLException ex){
			        throw new DAOException("Error en SQL", ex);
			   }finally{
			       
			       if(rs != null){
			           
			           try{
			               rs.close();
			           }catch(SQLException ex){
			               new DAOException("Error en SQL", ex);
			           }
			           
			       }
			       if(stat != null){
			           
			           try{
			               stat.close();
			           }catch(SQLException ex){
			               new DAOException("Error en SQL", ex);
			           }
			           
			       }
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	        return v;
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
