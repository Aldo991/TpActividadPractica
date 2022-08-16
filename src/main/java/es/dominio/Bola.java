package es.dominio;

public abstract class Bola {

	private int id;
	private String tipoDeBola;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoDeBola() {
		return tipoDeBola;
	}
	public void setTipoDeBola(String tipoDeBola) {
		this.tipoDeBola = tipoDeBola;
	}
	
	public abstract void capturarPokemon(Pokemon pokemon); 
	public abstract Bola clonar();
}
