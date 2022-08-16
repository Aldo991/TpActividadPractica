package es.repositorio.interfaceDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.dominio.Entrenador;
import es.dominio.Pokemon;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.EntrenadorDAO;

public class EntrenadorDAOImpl extends ConexionToBD implements EntrenadorDAO{

	@Override
	public Entrenador consultarEntrenador(String username, String pass) throws SQLException {
		conectarBD();
		String consultaSQL = "SELECT * "
							+"FROM Entrenadores "
							+"WHERE userName = " + username +" AND password = " + pass;
		PreparedStatement consultar = conector.prepareStatement(consultaSQL);
		ResultSet resultado = consultar.executeQuery();
		if(resultado.next())
		{
			desconectarBD();
			return convertResultSetToEntrenador(resultado);
		}
		desconectarBD();
		return null;
	}

	@Override
	public int registrarEntrenador(Entrenador entrenador) throws SQLException {
		conectarBD();
		int id = -1;
		String insertarSQL = "Insert into Entrenadores (nombre, userName, password, edad) value (?,?,?,?)";
		PreparedStatement ps = conector.prepareStatement(insertarSQL);
		ps.setString(1, entrenador.getNombre());
		ps.setString(2, entrenador.getUserName());
		ps.setString(3, entrenador.getPassword());
		ps.setInt(4, entrenador.getEdad());
		id = ps.executeUpdate();
		ResultSet rs = conector.prepareStatement("select max(id) from entrenadores").executeQuery();
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		desconectarBD();
		return id;
	}

	@Override
	public boolean agregarPokemon(Pokemon pokemon, int idEntrenador) throws SQLException {
		conectarBD();
		String insertSQL = "INSERT INTO Pokemons VALUES "
				+ "(100,"+idEntrenador+","+pokemon.getElemento().getTipoDeElemento()+","+pokemon.getNombre()+","+pokemon.getIdPokeAPI()+",NULL)";
		PreparedStatement ps = conector.prepareStatement(insertSQL);
		if(ps.execute())
		{
			desconectarBD();
			return true;
		}
		desconectarBD();
		return false;
	}

	@Override
	public boolean eliminarPokemon(int idPokemon, int idEntrenador) throws SQLException {
		conectarBD();
		String deleteSQL = "DELETE FROM Entrenadores WHERE id = "+ idPokemon + " AND id_Entrenador = " + idEntrenador;
		PreparedStatement ps = conector.prepareStatement(deleteSQL);
		if(ps.execute())
		{
			desconectarBD();
			return true;
		}
		desconectarBD();
		return false;
	}

	@Override
	public boolean eliminarEntrenador(int id) throws SQLException {
		conectarBD();
		String deleteSQL = "DELETE FROM Entrenadores WHERE id = " + id;
		PreparedStatement ps = conector.prepareStatement(deleteSQL);
		if(ps.execute())
		{
			desconectarBD();
			return false;
		}
		desconectarBD();
		return false;
	}
	private Entrenador convertResultSetToEntrenador(ResultSet resultado) throws SQLException
	{
		Entrenador retornar = new Entrenador();
		retornar.setId(resultado.getInt("id"));
		retornar.setEdad(resultado.getInt("edad"));
		retornar.setNombre(resultado.getString("nombre"));
		return retornar;
	}
}
