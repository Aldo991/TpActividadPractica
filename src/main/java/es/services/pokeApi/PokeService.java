package es.services.pokeApi;

import es.services.pokeApi.entidades.PokemonMolde;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeService {

	@GET("pokemon")
	Call<PokemonMolde> getPokemon(@Query("nombre") String nombre);
}
