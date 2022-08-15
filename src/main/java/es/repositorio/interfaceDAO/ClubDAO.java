package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Club;
import es.dominio.MasterClub;
import es.dominio.SingleClub;

public interface ClubDAO {

	public boolean nuevoClub(Club club) throws SQLException;
	public boolean elimnarClub(int id) throws SQLException;
	public Club consultarClub(int id) throws SQLException;
}
