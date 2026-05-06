package rvt.JavaMooc92OnlineShop;

import java.util.HashMap;

public class ShoppingCart {
     HashMap<String, Item> productCart;

    public ShoppingCart() {
        productCart = new HashMap<>();

    }

    public void add(String product, int price) {
        if (productCart.containsKey(product)){
            productCart.get(product).increaseQuantity();
        } else {
        productCart.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        int totalPrice = 0;

        for (Item items : productCart.values()) {
            totalPrice += items.price();
        }

        return totalPrice;
    }

    public void print() {
        for (Item item : productCart.values()) { // Izņemam no hashmapa visus new Item lai sašķelt tos
            System.out.println(item); // ņem metode String toString() no Item.java
        }
    }
}
