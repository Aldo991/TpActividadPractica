package es.repositorio.interfaceDAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.dominio.Club;
import es.dominio.MasterClub;
import es.dominio.SingleClub;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.ClubDAO;

public class ClubDAOImpl extends ConexionToBD implements ClubDAO {

	@Override
	public boolean nuevoClub(Club club) throws SQLException {
		conectarBD();
		
		desconectarBD();
		return false;
	}

	@Override
	public boolean elimnarClub(int id) throws SQLException {
		conectarBD();
		String deleteSQL = "DELETE FROM Clubs WHERE id = " + id;
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
	public Club consultarClub(int id) throws SQLException {
		conectarBD();
		Club club = new Club();
		String selectSQL = "SELECT * FROM Clubs WHERE id = " + id;
		PreparedStatement ps = conector.prepareStatement(selectSQL);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			if(rs.getInt("cantEntrenadores") > 0)
			{
				SingleClub singleClub = new SingleClub();
				singleClub.setId(rs.getInt("id"));
				singleClub.setNombre(rs.getString("nombre"));
				singleClub.setCiudad(rs.getString("ciudad"));
				singleClub.setCantEntrenadores(rs.getInt("cantEntrenadores"));
				return singleClub;
			}
			else if(rs.getInt("idMasterClub")>0)
			{
				MasterClub masterClub = new MasterClub();
				masterClub.setId(rs.getInt("id"));
				masterClub.setNombre(rs.getString("nombre"));
				masterClub.setCiudad(rs.getString("ciudad"));
				masterClub.setListaClubs(listaDeClubs(rs.getInt("idMasterClub")));
			}
			club.setNombre(rs.getString("nombre"));
			club.setCiudad(rs.getString("string"));
		}
		desconectarBD();
		return club;
	}
	private ArrayList<Club> listaDeClubs(int id) throws SQLException
	{
		ArrayList<Club> listaClubs = new ArrayList<Club>();
		conectarBD();
		String selectSQL = "SELECT * FROM Clubs WHERE id = " + id;
		PreparedStatement ps = conector.prepareStatement(selectSQL);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			Club club  = consultarClub(rs.getInt("id"));
			listaClubs.add(club);
		}
		desconectarBD();
		return listaClubs;
	}
}
