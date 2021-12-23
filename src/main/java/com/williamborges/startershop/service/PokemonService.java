package com.williamborges.startershop.service;

import com.williamborges.startershop.model.Pokemon;

import java.util.Optional;

public interface PokemonService {

    public Iterable<Pokemon> getAllPokemon();

    public Optional<Pokemon> getPokemon(long id);

    public Pokemon savePokemon(Pokemon pokemon);
}
