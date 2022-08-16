package es.repositorio.interfaceDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.dominio.Agua;
import es.dominio.Fuego;
import es.dominio.Pokemon;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.PokemonDAO;

public class PokemonDAOImpl extends ConexionToBD implements PokemonDAO {

	@Override
	public int guardarPokemon(Pokemon pokemon, int id_entrenador) throws SQLException {
		conectarBD();
		int id = -1;
		String insertSQL = "INSERT INTO Pokemons VALUE (?,?,?,?,?)";
		PreparedStatement ps = conector.prepareStatement(insertSQL);
		ps.setInt(1, 100);
		ps.setInt(2, id_entrenador);
		ps.setString(3, pokemon.getElemento().getTipoDeElemento());
		ps.setString(4, pokemon.getNombre());
		ps.setInt(5, pokemon.getIdPokeAPI());
		ps.executeUpdate();
		ResultSet rs = conector.prepareStatement("select max(id) from pokemons").executeQuery();
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		desconectarBD();
		return id;
	}

	@Override
	public Pokemon consultarPokemon(int id_pokemon) throws SQLException {
		conectarBD();
		Pokemon retornar = new Pokemon();
		String selectSQL = "SELECT * FROM Pokemons WHERE id = " + id_pokemon;
		PreparedStatement ps = conector.prepareStatement(selectSQL);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			retornar.setId(rs.getInt("id"));
			retornar.setHP(rs.getInt("hp"));
			retornar.setIdPokeAPI(rs.getInt("id_PokeAPI"));
			retornar.setNombre(rs.getString("nombre"));
			if(rs.getString("tipoElemento").equals("fuego"))
			{
				Fuego fuego = new Fuego();
				fuego.setTipoDeElemento("fuego");
				retornar.setElemento(fuego);
			}
			else if(rs.getString("tipoElemento").equals("agua"))
			{
				Agua agua = new Agua();
				agua.setTipoDeElemento("agua");
				retornar.setElemento(agua);
			}
		}
		desconectarBD();
		return retornar;
	}

	@Override
	public ArrayList<Pokemon> listaDePokemons(int id_entrenador) throws SQLException {
		conectarBD();
		ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();
		String selectSQL = "SELECT * FROM Pokemons WHERE id_entrenador = " + id_entrenador;
		PreparedStatement ps = conector.prepareStatement(selectSQL);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Pokemon pokemon = new Pokemon();
			pokemon.setHP(rs.getInt("hp"));
			pokemon.setId(rs.getInt("id"));
			pokemon.setIdPokeAPI(rs.getInt("id_PokeAPI"));
			pokemon.setNombre(rs.getString("nombre"));
			if(rs.getString("tipoElemento").equals("fuego"))
			{
				Fuego fuego = new Fuego();
				fuego.setTipoDeElemento("fuego");
				pokemon.setElemento(fuego);
			}
			else if(rs.getString("tipoElemento").equals("agua"))
			{
				Agua agua = new Agua();
				agua.setTipoDeElemento("agua");
				pokemon.setElemento(agua);
			}
			listaPokemon.add(pokemon);
		}
		desconectarBD();
		return null;
	}

	@Override
	public boolean actualizarHP(int id_pokemon, int hp) throws SQLException {
		conectarBD();
		String updateSQL = "UPDATE Pokemons SET hp = "+ hp +" WHERE id = " + id_pokemon;
		PreparedStatement ps = conector.prepareStatement(updateSQL);
		if(ps.execute())
		{
			desconectarBD();
			return true;
		}
		desconectarBD();
		return false;
	}

	@Override
	public boolean eliminarPokemon(int id_pokemon) throws SQLException {
		conectarBD();
		String deleteSQL = "DELETE FROM Pokemons WHERE id = " + id_pokemon;
		PreparedStatement ps = conector.prepareStatement(deleteSQL);
		if(ps.execute())
		{
			desconectarBD();
			return true;
		}
		desconectarBD();
		return false;
	}
}
