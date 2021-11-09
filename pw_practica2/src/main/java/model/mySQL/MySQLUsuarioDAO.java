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

import model.Data.Usuario;
import model.DAOS.UsuarioDAO;

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
    
    final String INSERT = "INSERT INTO jugadores( usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia) VALUES (?,?,?,?,?,?,?,?)"; 
    final String UPDATE = "UPDATE jugadores SET usuario = ? , nombre = ?, email = ?, apellidos = ?, fechaNacimiento = ?, contraseña = ?,telefono = ? WHERE email = ?";
    final String DELETE = "DELETE FROM jugadores WHERE idJugador = ?";
    final String GETALL = "SELECT idJugador, usuario, nombre, email, apellidos, fechaNacimiento, contraseña,telefono, valoracionMedia FROM jugadores";
    final String GETONE = "SELECT * FROM jugadores WHERE idJugador = ?";
    final String BUSCARPOREMAIL = "SELECT * FROM jugadores WHERE email = ?";
    
    
    private Connection conn;
    
    public MySQLUsuarioDAO(Connection conn) {
        
        this.conn = conn;
        
    }

	@Override
	public void insertar(Usuario j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario obtener(String id) {
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
    

    /*
    *   ----------------------------------------------------------------
    *   FUNCIONES BASICAS DE DAO JUGADOR INSERTAR, BORRAR, OBTENER, ETC
    *   ----------------------------------------------------------------
    */
    
    



}