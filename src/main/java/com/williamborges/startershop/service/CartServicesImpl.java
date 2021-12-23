package com.williamborges.startershop.service;

import com.williamborges.startershop.model.CartItem;
import com.williamborges.startershop.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartServicesImpl implements CartServices{

    @Autowired
    CartItemRepository cartItemRepository;

    @Override
    public Iterable<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem updateQuantity(CartItem cartItem, int newQuantity) {
        cartItemRepository.delete(cartItem);
        cartItem.setQuantity(newQuantity);
        return cartItemRepository.save(cartItem);
    }
}
