package es.services.pokeApi;

import es.services.pokeApi.entidades.PokemonMolde;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeService {

	@GET("pokemon/{id}")
	Call<PokemonMolde> getPokemon(@Path("id") String nombre);
}
