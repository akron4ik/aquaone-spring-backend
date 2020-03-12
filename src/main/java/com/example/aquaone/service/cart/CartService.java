package com.example.aquaone.service.cart;

import com.example.aquaone.model.Cart;
import com.example.aquaone.repository.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.aquaone.util.ValidationUtil.checkNotFoundWithId;


@Service
public class CartService {

    private final CartRepository repository;

    @Autowired
    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public Cart get(int id){
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    @Transactional
    public Cart create(Cart cart){
        Assert.notNull(cart, "cart must be not null");
        return repository.save(cart);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public List<Cart> getAll(){
        return repository.getAll();
    }
}
