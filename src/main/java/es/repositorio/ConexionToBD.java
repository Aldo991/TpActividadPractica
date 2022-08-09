package es.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionToBD {

	private String URL="jdbc:mysql://localhost/nombre"; //nombre = nombre de la base de datos
	private String pass="admin";
	private String user="root";
	private String jdbc="com.mysql.jdbc.Driver";
	
	protected Connection conector;
	
	public void conectarBD()
	{
		try
		{
			Class.forName(jdbc);
			conector = DriverManager.getConnection(URL, user,pass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void desconectarBD() throws SQLException
	{
		if (conector!=null)
		{
			if(!conector.isClosed())
			{
				conector.close();
			}
		}
	}
}
