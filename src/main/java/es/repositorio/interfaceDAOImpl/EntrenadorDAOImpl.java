package es.repositorio.interfaceDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.dominio.Entrenador;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.EntrenadorDAO;

public class EntrenadorDAOImpl extends ConexionToBD implements EntrenadorDAO{

	@Override
	public Entrenador consultarEntrenador(int id) throws SQLException {
		conectarBD();
		String consultaSQL = "SELECT * FROM Entrenadores WHERE id = " + id;
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
	public boolean registrarEntrenador(Entrenador entrenador) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarEntrenador(Entrenador entrenador) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarPokemon(int idPokemon, int idEntrenador) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarPokemon(int idPokemon, int idEntrenador) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEntrenador(int id) throws SQLException {
		// TODO Auto-generated method stub
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
