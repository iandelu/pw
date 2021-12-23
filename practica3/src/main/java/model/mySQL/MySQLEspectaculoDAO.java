package model.mySQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.EspectaculoFactory;
import model.daos.DAOException;
import model.daos.EspectaculoDAO;
import model.data.Espectaculo;
import model.data.Usuario;

public class MySQLEspectaculoDAO implements EspectaculoDAO{

	
	 /*
	    *   ------------------------------------
	    *   SENTENCIAS PARA LAS TABLAS DE JUGADOR
	    *   ------------------------------------_
	    */
	    
	    final String INSERT = "INSERT INTO Usuarios( nickname, nombre, email, apellidos, contraseña) VALUES (?,?,?,?,?)"; 
	    final String UPDATE = "UPDATE Usuarios SET usuario = ? , nombre = ?, email = ?, apellidos = ?, contraseña = ? WHERE email = ?";
	    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
	    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia FROM jugadores";
	    final String GETONE = "SELECT * FROM jugadores WHERE idJugador = ?";
	    final String BUSCARPOREMAIL = "SELECT * FROM jugadores WHERE email = ?";
	    
	    
	    private Connection conn;
	    
	    public MySQLEspectaculoDAO(Connection conn) {
	        
	        this.conn = conn;
	        
	    }
	
	
	@Override
	public void insertar(Espectaculo u) throws DAOException {
		PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);   
            stat.setLong(1, u.getIdEspectaculo());
            stat.setString(2, u.getTitulo());
            stat.setString(3, u.getDescripcion());
            stat.setString(4, u.getCategorias().get(1));
            stat.setInt(5, u.getLocalidadesDisponibles());
            stat.setString(6, u.getTipoEspectaculo());
            
            
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
	public void modificar(Espectaculo u) throws DAOException {
		PreparedStatement stat = null;
		
		try{
            stat = conn.prepareStatement(UPDATE);   
            
            stat.setLong(1, u.getIdEspectaculo());
            stat.setString(2, u.getTitulo());
            stat.setString(3, u.getDescripcion());
            stat.setString(4, u.getCategorias().get(1));
            stat.setInt(5, u.getLocalidadesDisponibles());
            stat.setString(6, u.getTipoEspectaculo());
            stat.setLong(7, u.getIdEspectaculo());
            
            
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
	public void eliminar(Espectaculo u) throws DAOException {
		
		PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, u.getIdEspectaculo());

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
	
private Espectaculo convertir(ResultSet rs) throws Exception{
        
        String tipoEspectaculo = rs.getString("tipo");
        Long idEspectaculo = rs.getLong("idEspectaculo");
        String titulo = rs.getString("titulo");
        String descripcion = rs.getString("descripcion");
        ArrayList<String> categorias = null;
        int localidadesDisponibles = rs.getInt("localidadesDisponibles");
        ArrayList<String> funciones = null;
        
        EspectaculoFactory factoria = new EspectaculoFactory();
        Espectaculo espectaculoAux = factoria.crearEspectaculo( tipoEspectaculo, idEspectaculo,  titulo,  descripcion,  categorias, localidadesDisponibles);
        espectaculoAux.setFunciones(funciones);
        return espectaculoAux;
}

	@Override
	public ArrayList<Espectaculo> obtenerTodos() {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    ArrayList<Espectaculo> espectaculos = new ArrayList<>();
	       
	       try {
			try{
			       stat = conn.prepareStatement(GETALL);
			       rs = stat.executeQuery();
			       while(rs.next()){
			    	   espectaculos.add(convertir(rs));
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
	       
	        return espectaculos;
	}

	@Override
	public Espectaculo obtener(Long id) {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    Espectaculo espectaculo = null;
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETONE);
			       stat.setLong(1, id);
			       rs = stat.executeQuery();
			       if(rs.next()){
			           
			    	   espectaculo = convertir(rs);
			           
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
	       
	        return espectaculo;
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
