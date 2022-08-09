package es.repositorio.interfaceDAOImpl;

import es.dominio.Entrenador;
import es.repositorio.ConexionToBD;
import es.repositorio.interfaceDAO.EntrenadorDAO;

public class EntrenadorDAOImpl extends ConexionToBD implements EntrenadorDAO{

	@Override
	public Entrenador consultarEntrenador(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entrenador consultarEntrenador(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registrarEntrenador(Entrenador entrenador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarEntrenador(Entrenador entrenador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean agregarPokemon(int idPokemon, int idEntrenador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarPokemon(int idPokemon, int idEntrenador) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEntrenador(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
