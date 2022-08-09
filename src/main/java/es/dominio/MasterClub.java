package es.dominio;

import java.util.ArrayList;

public class MasterClub extends Club{
	private ArrayList<Club> listaClubs;

	public ArrayList<Club> getListaClubs() {
		return listaClubs;
	}
	public void setListaClubs(ArrayList<Club> listaClubs) {
		this.listaClubs = listaClubs;
	}
}
