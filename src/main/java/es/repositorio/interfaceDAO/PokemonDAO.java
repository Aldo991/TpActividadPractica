package es.repositorio.interfaceDAO;

import java.sql.SQLException;
import java.util.ArrayList;

import es.dominio.Pokemon;

public interface PokemonDAO {

	//INSERT
	public int guardarPokemon(Pokemon pokemon, int id_entrenador) throws SQLException;
	//SELECT
	public Pokemon consultarPokemon(int id_pokemon) throws SQLException;
	public ArrayList<Pokemon> listaDePokemons(int id_entrenador) throws SQLException;
	//UPDATE
	public boolean actualizarHP(int id_pokemon, int hp) throws SQLException;
	//DELETE
	public boolean eliminarPokemon(int id_pokemon) throws SQLException;
}
