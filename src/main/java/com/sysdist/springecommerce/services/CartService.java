package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Cart;
import com.sysdist.springecommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<Cart> cartList = new ArrayList<>();
    private  int itemCount;

    public CartService() {
//        cartList = new ArrayList<>();
    }

    public void AddItemToCart(Product product) {
        int i = 0;
        for (; i < cartList.size(); i++)
            if (cartList.get(i).getProduct().equals(product)) {
                cartList.get(i).incCount();
                itemCount++;
                break;
            }

        if (i == cartList.size()) {
            cartList.add(new Cart(product, 1));
            itemCount++;
        }

    }

    public void DeleteItemFromCart(Product product) {
        for (int i = 0; i < cartList.size(); i++)
            if (cartList.get(i).getProduct().equals(product)) {
                product.addQuantity(cartList.get(i).getCount());
                cartList.remove(i);
                itemCount--;
                break;
            }
    }

    public List<Cart> GetCartList() {
        return cartList;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
