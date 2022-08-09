package es.dominio;

import java.util.ArrayList;

public class PokemonEvolucionado extends Pokemon {

	private ArrayList<Pokemon> pokemonsEliminados;
	
	public ArrayList<Pokemon> getPokemonsEliminados() {
		return pokemonsEliminados;
	}
	public void setPokemonsEliminados(ArrayList<Pokemon> pokemonsEliminados) {
		this.pokemonsEliminados = pokemonsEliminados;
	}
}
