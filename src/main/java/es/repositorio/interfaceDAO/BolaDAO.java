package es.repositorio.interfaceDAO;

import java.sql.SQLException;

import es.dominio.Bola;

public interface BolaDAO {

	public int nuevaBola(Bola bola, int id_entrenador) throws SQLException;
	public boolean eliminarBola(int id) throws SQLException;
	public Bola consultarBola(int id) throws SQLException;
}
