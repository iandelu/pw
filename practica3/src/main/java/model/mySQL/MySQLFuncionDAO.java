package model.mySQL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import model.daos.DAOException;
import model.daos.FuncionDAO;
import model.data.Funcion;
import model.data.Valoracion;

public class MySQLFuncionDAO implements FuncionDAO {
		
		PreparedStatement stat = null;
        
		final String INSERT = "INSERT INTO Funcion( id, fecha, hora, espectaculo) VALUES (?,?,?,?)"; 
		final String UPDATE = "UPDATE Funcion SET id = ? , fecha = ?, hora = ?, espectaculo = ? WHERE id = ?";
	    final String DELETE = "DELETE FROM Funcion WHERE id = ?";
	    final String GETALL = "SELECT id, fecha, hora, espectaculo FROM Funcion";
	    final String GETONE = "SELECT id, fecha, hora, espectaculo FROM Funcion WHERE id = ?";
	    final String GETALLESPECTACULO = "SELECT id, fecha, hora, espectaculo FROM Funcion WHERE espectaculo = ?";
	    
	    private Connection conn;
	    
	    public MySQLFuncionDAO(Connection conn) {
	        
	        this.conn = conn;
	        
	    }
		
	    @Override
		public void insertar(Funcion f) throws DAOException {
	    	
	    	PreparedStatement stat = null;
	    	
	    	try{
	            stat = conn.prepareStatement(INSERT);   
	            
	            stat.setLong(1, f.getIdFuncion());
	            stat.setDate(2, Date.valueOf(f.getFecha()));
	            stat.setTime(3, Time.valueOf(f.getHora()));
	            stat.setInt(4, f.getLocalidadesRestantes());
	            stat.setLong(5, f.getEspectaculo());
	            
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
	public void modificar(Funcion f) throws DAOException {
		PreparedStatement stat = null;
    	
    	try{
            stat = conn.prepareStatement(INSERT);   
            
            stat.setLong(1, f.getIdFuncion());
            stat.setDate(2, Date.valueOf(f.getFecha()));
            stat.setTime(3, Time.valueOf(f.getHora()));
            stat.setInt(4, f.getLocalidadesRestantes());
            stat.setLong(5, f.getEspectaculo());
            stat.setLong(6, f.getIdFuncion());
            
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
	public void eliminar(Funcion f) throws DAOException {
		PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, f.getIdFuncion());

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

	
	private Funcion convertir(ResultSet rs) throws Exception{
		
        Long idValoracion = rs.getLong("id");
        Date fecha = rs.getDate("fecha");
        Time hora = rs.getTime("hora");
        int  localidadesRestantes = rs.getInt("localidadesRestantes");
        Long espectaculo = rs.getLong("espectaculo");

        
        Funcion f = new Funcion(idValoracion,fecha.toLocalDate(),hora.toLocalTime(),localidadesRestantes,espectaculo);
        
        return f;
        
    }
	
	@Override
	public List<Funcion> obtenerTodos() throws DAOException, Exception {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Funcion> funciones = new ArrayList<>();
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETALL);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			    	   funciones.add(convertir(rs));
			           
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
	       
	        return funciones;
	}

	@Override
	public Funcion obtener(Long id) throws Exception {
		   PreparedStatement stat = null;
	       ResultSet rs = null;
	       Funcion f = null;
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETONE);
			       stat.setLong(1, id);
			       rs = stat.executeQuery();
			       if(rs.next()){
			           
			           f = convertir(rs);
			           
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
	       
	        return f;
	}

	@Override
	public void cargarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardarFichero() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	public List<Funcion> obtenerTodosEspectaculo(Long idEspectaculo) throws DAOException, Exception {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Funcion> funciones = new ArrayList<>();
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETALLESPECTACULO);
			       stat.setLong(1,idEspectaculo);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			    	   funciones.add(convertir(rs));
			           
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
	       
	        return funciones;
	}
}
