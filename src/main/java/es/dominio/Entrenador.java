package es.dominio;

import java.util.ArrayList;

public class Entrenador {

	private String nombre;
	private int edad;
	private ArrayList<Pokemon> pokemons;
	private Club grupo;
	
	public ArrayList<Pokemon> getPokemons() {
		return pokemons;
	}
	public void setPokemons(ArrayList<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}
	public Club getGrupo() {
		return grupo;
	}
	public void setGrupo(Club grupo) {
		this.grupo = grupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
