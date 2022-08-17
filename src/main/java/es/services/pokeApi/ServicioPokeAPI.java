package es.services.pokeApi;

import java.io.IOException;

import es.services.pokeApi.entidades.PokemonMolde;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicioPokeAPI {

	private static ServicioPokeAPI instancia = null;
	private static final String url = "https://pokeapi.co/api/v2/";
	private Retrofit retrofit;
	
	private ServicioPokeAPI()
	{
		this.retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}
	public static ServicioPokeAPI getInstancia()
	{
		if(instancia == null)
		{
			instancia = new ServicioPokeAPI();
		}
		return instancia;
	}
	
	public PokemonMolde getPokemon(String nombre) throws IOException
	{
		PokeService pokeService = this.retrofit.create(PokeService.class);
		Call<PokemonMolde> requestPokemon = pokeService.getPokemon(nombre);
		Response<PokemonMolde> responsePokemon = requestPokemon.execute();
		return responsePokemon.body();
	}
}
