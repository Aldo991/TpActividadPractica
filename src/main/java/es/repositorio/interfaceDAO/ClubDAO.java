package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Club;

public interface ClubDAO {

	public boolean nuevoClub(Club club) throws SQLException;
	public boolean elimnarClub(int id) throws SQLException;
	public Club consultarClub(int id) throws SQLException;
	public boolean modificarClub(int id) throws SQLException;
}
