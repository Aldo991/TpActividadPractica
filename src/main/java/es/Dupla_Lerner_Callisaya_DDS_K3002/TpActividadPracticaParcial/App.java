package es.Dupla_Lerner_Callisaya_DDS_K3002.TpActividadPracticaParcial;

import java.sql.SQLException;

import es.dominio.Club;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.BolaDAO;
import es.repositorio.interfaceDAO.ClubDAO;
import es.repositorio.interfaceDAOImpl.ClubDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hola mundo" );
        ClubDAO clubDao = new ClubDAOImpl();
        Club club = new Club();
        club.setCiudad("Z");
        club.setNombre("Paleta");
        try {
        	//clubDao.nuevoClub(club, "masterClub");
        	club = clubDao.consultarClub(2);
        	System.out.println(club.getCiudad());
        	System.out.println(club.getNombre());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
