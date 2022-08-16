package es.repositorio.interfaceDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.dominio.Bola;
import es.dominio.Pokemon;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.BolaDAO;

public class BolaDAOImpl extends ConexionToBD implements BolaDAO {

	@Override
	public int nuevaBola(Bola bola, int id_entrenador) throws SQLException {
		conectarBD();
		int id = 0;
		String insertSQL = "INSERT INTO Bolas VALUE ("+id_entrenador+","+bola.getTipoDeBola() +")";
		PreparedStatement ps = conector.prepareStatement(insertSQL);
		ps.executeUpdate();
		ResultSet rs = conector.prepareStatement("SELECT MAX(id) FROM Bolas").executeQuery();
		if(rs.next())
		{
			id = rs.getInt(1);
		}
		desconectarBD();
		return id;
	}

	@Override
	public boolean eliminarBola(int id) throws SQLException {
		conectarBD();
		String deleteSQL = "DELETE FROM Bolas WHERE id = " + id;
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
	public Bola consultarBola(int id) throws SQLException {
		Bola retornar = null;
		String selectSQL = "SELECT * FROM Bolas WHERE id = " + id;
		PreparedStatement ps = conector.prepareStatement(selectSQL);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			retornar.setId(rs.getInt(1));
			retornar.setTipoDeBola(rs.getString(3));
		}
		return retornar;
	}

}
