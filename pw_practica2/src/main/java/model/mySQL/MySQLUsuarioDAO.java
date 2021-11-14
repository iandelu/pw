/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.mySQL;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.daos.DAOException;
import model.daos.UsuarioDAO;
import model.data.Usuario;

/**
 *
 * @author LuisAneri
 */

public class MySQLUsuarioDAO implements UsuarioDAO{
    
    
    /*
    *   ------------------------------------
    *   SENTENCIAS PARA LAS TABLAS DE JUGADOR
    *   ------------------------------------_
    */
    
	final String INSERT = "INSERT INTO Usuarios( nickname, nombre, email, apellidos, contraseña) VALUES (?,?,?,?,?)"; 
	final String UPDATE = "UPDATE Usuarios SET usuario = ? , nombre = ?, email = ?, apellidos = ?, contraseña = ? WHERE email = ?";
    final String DELETE = "DELETE FROM Usuarios WHERE email = ?";
    final String GETALL = "SELECT usuario, nombre, email, apellidos,contraseña FROM Usuarios";
    final String GETONE = "SELECT * FROM Usuarios WHERE email = ?";
    
    
    private Connection conn;
    
    public MySQLUsuarioDAO(Connection conn) {
        
        this.conn = conn;
        
    }

	@Override
	public void insertar(Usuario u) throws DAOException {
		
		PreparedStatement stat = null;
        
        try{
            stat = conn.prepareStatement(INSERT);   
            
            stat.setString(1, u.getNickname());
            stat.setString(2, u.getNombre());
            stat.setString(3, u.getEmail());
            stat.setString(4, u.getApellidos());
            stat.setString(5, u.getPassword());
            
            
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
	public void modificar(Usuario u) throws DAOException {
		
		PreparedStatement stat = null;
		
		try{
            stat = conn.prepareStatement(UPDATE);   
            
            stat.setString(1, u.getNickname());
            stat.setString(2, u.getNombre());
            stat.setString(3, u.getEmail());
            stat.setString(4, u.getApellidos());
            stat.setString(6, u.getPassword());
            
            
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
	public void eliminar(Usuario u) throws DAOException {
		
		PreparedStatement stat = null;
        
        try{
            
            stat = conn.prepareStatement(DELETE);
            stat.setString(1, u.getEmail());

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
		
	private Usuario convertir(ResultSet rs) throws Exception{
        
        String usuario = rs.getString("usuario");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String nickname = rs.getString("nickname");
        String contraseña = rs.getString("contraseña");
        String email = rs.getString("email");
        
        Usuario j = new Usuario(nombre,apellidos,email,nickname,contraseña);
        
        return j;
        
    }

	@Override
	public List<Usuario> obtenerTodos() throws Exception {
		PreparedStatement stat = null;
	    ResultSet rs = null;
	    List<Usuario> usuarios = new ArrayList<>();
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETALL);
			       rs = stat.executeQuery();
			       while(rs.next()){
			           
			           usuarios.add(convertir(rs));
			           
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
	       
	        return usuarios;
	}

	@Override
	public Usuario obtener(String email) throws Exception {
		PreparedStatement stat = null;
	       ResultSet rs = null;
	       Usuario u = null;
	       
	       try {
			try{
			       
			       stat = conn.prepareStatement(GETONE);
			       stat.setString(1, email);
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
  
    
    



}