package es.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionToBD {

	private String URL="jdbc:mysql://localhost/nombre"; //nombre = nombre de la base de datos
	private String pass="admin";
	private String user="root";
	private String jdbc="com.mysql.jdbc.Driver";
	
	protected Connection con;
	
	public void conectar()
	{
		try
		{
			Class.forName(jdbc);
			con = DriverManager.getConnection(URL, user,pass);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void desconectar() throws SQLException
	{
		if (con!=null)
		{
			if(!con.isClosed())
			{
				con.close();
			}
		}
	}
}