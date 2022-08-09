package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Entrenador;

public interface EntrenadorDAO{

	//SELECT
	public Entrenador consultarEntrenador(int id) throws SQLException;
	public Entrenador consultarEntrenador(String username, String pass) throws SQLException;
	//INSERT
	public boolean registrarEntrenador(Entrenador entrenador) throws SQLException;
	//UPDATE
	public boolean modificarEntrenador(Entrenador entrenador) throws SQLException;
	public boolean agregarPokemon(int idPokemon, int idEntrenador) throws SQLException;
	public boolean eliminarPokemon(int idPokemon, int idEntrenador) throws SQLException;
	//DELETE
	public boolean eliminarEntrenador(int id) throws SQLException;
}
