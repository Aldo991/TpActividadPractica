package es.Dupla_Lerner_Callisaya_DDS_K3002.TpActividadPracticaParcial;

import java.sql.SQLException;

import es.dominio.Bola;
import es.dominio.Club;
import es.dominio.Entrenador;
import es.dominio.PokeBola;
import es.dominio.Pokemon;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.BolaDAO;
import es.repositorio.interfaceDAO.ClubDAO;
import es.repositorio.interfaceDAO.EntrenadorDAO;
import es.repositorio.interfaceDAOImpl.BolaDAOImpl;
import es.repositorio.interfaceDAOImpl.ClubDAOImpl;
import es.repositorio.interfaceDAOImpl.EntrenadorDAOImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hola mundo" );
        EntrenadorDAO entrenadorDao = new EntrenadorDAOImpl();
        Entrenador entrenador = new Entrenador();
        entrenador.setEdad(20);
        entrenador.setNombre("Pedro");
        entrenador.setPassword("789");
        entrenador.setUserName("PedritoNOSE");
        try {
        	int id = entrenadorDao.registrarEntrenador(entrenador);
        	System.out.println("id: " + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
