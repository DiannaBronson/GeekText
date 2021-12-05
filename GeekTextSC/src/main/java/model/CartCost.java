package model;

import dto.CartDto;
import java.util.List;

public class CartCost {
    private List<CartDto> cartItems;
    private double totalCost;

    public CartCost(List<CartDto> cartDtoList, double totalCost) {
        this.cartItems = cartDtoList;
        this.totalCost = totalCost;
    }

    public List<CartDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartDto> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
