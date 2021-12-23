package com.williamborges.startershop.controller;

import com.sun.istack.NotNull;
import com.williamborges.startershop.model.CartItem;
import com.williamborges.startershop.model.Pokemon;
import com.williamborges.startershop.repository.CartItemRepository;
import com.williamborges.startershop.repository.PokemonRepository;
import com.williamborges.startershop.service.CartServices;
import com.williamborges.startershop.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    CartServices cartServices;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    //gets all pokemon from product page
    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable long id){
        Pokemon pokemon = pokemonRepository.findById(id).get();
        return pokemon;
    }

    //adds a pokemon to product page
    @PostMapping("/pokemon")
    public String add(@RequestBody Pokemon pokemon) {
        pokemonService.savePokemon(pokemon);
        return "New Pokemon was added.";
    }

    //gets the cart
    @GetMapping("/cart")
    public Iterable<CartItem> getAllCartItems() { return cartServices.getAllCartItems(); }

    //adds a pokemon to cart
    @PostMapping("/addtocart")
    public String addToCart(@RequestBody CartItem cartItem){
        cartServices.addCartItem(cartItem);
        return "Item was added to cart";
    }

    //deletes a pokemon order from the cart
    @DeleteMapping("/deleteItem")
    public  String deleteCartItem(@RequestBody CartItem cartItem){
        cartServices.removeCartItem(cartItem);
        return  "Item was deleted from cart";
    }

    //updates the quantity of pokemon in the cart
    @PatchMapping("/update/{id}/{quantity}")
    public String updateCartItemQuantity(@PathVariable long id, @PathVariable int quantity){
        CartItem cartItem = cartItemRepository.findById(id).get();
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
        return "Item was updated.";
    }

}
