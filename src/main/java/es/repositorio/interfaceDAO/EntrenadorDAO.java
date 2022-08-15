package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Entrenador;
import es.dominio.Pokemon;

public interface EntrenadorDAO{

	//SELECT
	public Entrenador consultarEntrenador(String username, String pass) throws SQLException;
	//INSERT
	public Entrenador registrarEntrenador(Entrenador entrenador) throws SQLException;
	//UPDATE
	public boolean agregarPokemon(Pokemon pokemon, int idEntrenador) throws SQLException;
	public boolean eliminarPokemon(int idPokemon, int idEntrenador) throws SQLException;
	//DELETE
	public boolean eliminarEntrenador(int id) throws SQLException;
}
