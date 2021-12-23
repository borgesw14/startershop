package com.williamborges.startershop.service;

import com.williamborges.startershop.model.CartItem;
import com.williamborges.startershop.model.Pokemon;


public interface CartServices {
    public Iterable<CartItem> getAllCartItems();

    public CartItem addCartItem(Pokemon pokemon, int quantity);

    public void removeCartItem(long id);

    public CartItem updateQuantity(CartItem cartItem, int newQuantity);

}
