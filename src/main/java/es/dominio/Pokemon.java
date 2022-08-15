package es.dominio;

public class Pokemon {

	private int id;
	private String nombre;
	private int HP;
	private Elemento elemento;
	private int idPokeAPI;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPokeAPI() {
		return idPokeAPI;
	}
	public void setIdPokeAPI(int idPokeAPI) {
		this.idPokeAPI = idPokeAPI;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
}
