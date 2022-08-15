package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Bola;

public interface BolaDAO {

	public boolean nuevaBola(int id) throws SQLException;
	public boolean eliminarBola(int id) throws SQLException;
	public boolean modificarBola(Bola bola) throws SQLException;
	public Bola consultarBola(int id) throws SQLException;
}
