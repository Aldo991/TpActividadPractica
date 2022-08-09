package es.repositorio.interfaceDAO;

import es.dominio.Entrenador;

public interface EntrenadorDAO{

	public Entrenador consultarEntrenador(int id);
	public Entrenador consultarEntrenador(String username, String pass);
	
	public boolean registrarEntrenador(Entrenador entrenador);
	
	public boolean modificarEntrenador(Entrenador entrenador);
	public boolean agregarPokemon(int idPokemon, int idEntrenador);
	public boolean eliminarPokemon(int idPokemon, int idEntrenador);
	
	public boolean eliminarEntrenador(int id);
}
