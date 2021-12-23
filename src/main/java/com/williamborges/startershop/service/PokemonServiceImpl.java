package com.williamborges.startershop.service;

import com.williamborges.startershop.model.Pokemon;
import com.williamborges.startershop.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    PokemonRepository pokemonRepository;

    @Override
    public Iterable<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Optional<Pokemon> getPokemon(long id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
}
