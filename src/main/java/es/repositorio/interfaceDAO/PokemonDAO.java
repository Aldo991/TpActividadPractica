package es.repositorio.interfaceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import es.dominio.Pokemon;

public interface PokemonDAO {

	//INSERT
	public boolean guardarPokemon(Pokemon pokemon) throws SQLException;
	//SELECT
	public Pokemon consultarPokemon(int id_pokemon) throws SQLException;
	public Pokemon consultarPokemon(int id_PokeAPI, int id_Entrenador) throws SQLException;
	public ArrayList<Pokemon> listaDePokemons(int id_entrenador) throws SQLException;
	//UPDATE
	public boolean actualizarPokemon(int id_pokemon) throws SQLException;
	//DELETE
	public boolean eliminarPokemon(int id_pokemon) throws SQLException;
}
