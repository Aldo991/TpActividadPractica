package es.repositorio.interfaceDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import es.dominio.Pokemon;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.PokemonDAO;

public class PokemonDAOImpl extends ConexionToBD implements PokemonDAO {

	@Override
	public boolean guardarPokemon(Pokemon pokemon) throws SQLException {
		conectarBD();
		
		desconectarBD();
		return false;
	}

	@Override
	public Pokemon consultarPokemon(int id_pokemon) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pokemon consultarPokemon(int id_PokeAPI, int id_Entrenador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pokemon> listaDePokemons(int id_entrenador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarPokemon(int id_pokemon) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarPokemon(int id_pokemon) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
