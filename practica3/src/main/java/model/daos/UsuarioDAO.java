package model.daos;

import model.data.Usuario;

public interface UsuarioDAO extends DAO<Usuario, String>{

	void eliminar(String email) throws DAOException;

}