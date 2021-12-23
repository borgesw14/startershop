package com.williamborges.startershop.service;

import com.williamborges.startershop.model.CartItem;


public interface CartServices {
    public Iterable<CartItem> getAllCartItems();

    public CartItem addCartItem(CartItem cartItem);

    public void removeCartItem(CartItem cartItem);

    public CartItem updateQuantity(CartItem cartItem, int newQuantity);

}
