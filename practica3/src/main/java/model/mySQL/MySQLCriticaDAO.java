package model.mySQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.daos.CriticaDAO;
import model.daos.DAOException;
import model.data.Critica;
import model.data.Usuario;

public class MySQLCriticaDAO implements CriticaDAO{

	 /*
	    *   ------------------------------------
	    *   SENTENCIAS PARA LAS TABLAS DE JUGADOR
	    *   ------------------------------------_
	    */
	    
	    final String INSERT = "INSERT INTO Critica( id, autor, titulo, puntuacion, texto, espectáculo) VALUES (?,?,?,?,?,?)"; 
	    final String UPDATE = "UPDATE Critica SET id = ? , autor = ?, titulo = ?, puntuacion = ?, texto = ?, espectaculo = ? WHERE id = ?";
	    final String DELETE = "DELETE FROM Critica WHERE id = ?";
	    final String GETALL = "SELECT id, autor, titulo, puntuacion, texto, espectaculo FROM Critica";
	    final String GETONE = "SELECT id, autor, titulo, puntuacion, texto, espectaculo FROM Critica WHERE id = ?";
	    final String GETALLESPECTACULO = "SELECT id, autor, titulo, puntuacion, texto, espectaculo FROM Critica WHERE espectaculo = ?";
	        
	    
	    private Connection conn;
	    
	    public MySQLCriticaDAO(Connection conn) {
	        
	        this.conn = conn;
	        
	    }
	
	
	@Override
	public void insertar(Critica u) throws DAOException {
		
		PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);   
            
            stat.setLong(1, u.getIdCritica());
            stat.setString(2, u.getAutor());
            stat.setString(3, u.getTitulo());
            stat.setInt(4, u.getPuntuacion());
            stat.setString(5, u.getTexto());
            stat.setLong(6, u.getEspectaculo());
            
            
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
	public void modificar(Critica u) throws DAOException {
PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(UPDATE);   
            
            stat.setLong(1, u.getIdCritica());
            stat.setString(2, u.getAutor());
            stat.setInt(3, u.getPuntuacion());
            stat.setLong(4, u.getEspectaculo());
            stat.setString(5, u.getTexto());
            stat.setLong(6, u.getIdCritica());
            
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
	public void eliminar(Critica u) throws DAOException {

		PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE); 
            stat.setLong(1, u.getIdCritica());

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
	
	private Critica convertir(ResultSet rs) throws Exception{
        
        Long idCritica = rs.getLong("id");
        String autor = rs.getString("autor");
        int puntuacion = rs.getInt("puntuacion");
        String titulo = rs.getString("titulo");
        Long espectaculo = rs.getLong("espectaculo");
        String texto = rs.getString("texto");
        
        Critica c = new Critica(espectaculo, texto, texto, puntuacion, espectaculo, texto, null);
        c.setTitulo(titulo);
        
        return c;
        
    }

	@Override
	public List<Critica> obtenerTodos() {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Critica> criticas = new ArrayList<>();
	       
	       try {
			try{
			       stat = conn.prepareStatement(GETALL);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			    	   criticas.add(convertir(rs));
			           
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
	       
	        return criticas;
	}

	@Override
	public Critica obtener(Long id) {
		PreparedStatement stat = null;
	       ResultSet rs = null;
	       Critica u = null;
	       
	       try {
			try{
			       stat = conn.prepareStatement(GETONE);
			       stat.setLong(1, id);
			       rs = stat.executeQuery();
			       if(rs.next()){
			           
			           u = convertir(rs);
			           
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
	       
	        return u;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public List<Critica> obtenerDeEspectaculo(Long idEspectaculo) {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Critica> criticas = new ArrayList<>();
	       
	       try {
			try{
			       stat = conn.prepareStatement(GETALLESPECTACULO);
			       stat.setLong(1, idEspectaculo);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			    	   criticas.add(convertir(rs));
			           
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
	       
	        return criticas;
	}
}
