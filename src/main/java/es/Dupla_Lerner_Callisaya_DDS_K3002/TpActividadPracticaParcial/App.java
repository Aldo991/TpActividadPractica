package es.Dupla_Lerner_Callisaya_DDS_K3002.TpActividadPracticaParcial;

import java.io.IOException;
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
import es.services.pokeApi.ServicioPokeAPI;
import es.services.pokeApi.entidades.PokemonMolde;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ServicioPokeAPI servicioPokeAPI = ServicioPokeAPI.getInstancia();
        try {
			PokemonMolde pokemon = servicioPokeAPI.getPokemon("pikachu");
			System.out.println(pokemon.id + " | " + pokemon.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
