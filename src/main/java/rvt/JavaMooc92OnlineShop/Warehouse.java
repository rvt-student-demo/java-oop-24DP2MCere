package rvt.JavaMooc92OnlineShop;

import java.io.File;
import java.util.*;

public class Warehouse {
    private HashMap<String, Integer> productPrice;
    private HashMap<String, Integer> productStock;

    public Warehouse() {
        productPrice = new HashMap<>();
        productStock = new HashMap<>();

    }

    public void addProduct(String product, int price, int stock) { // which adds a product to the warehouse with the
                                                                   // price and stock balance given as parameters.
        productPrice.put(product, price);
        productStock.put(product, stock);

    }

    public int price(String product) { // which returns the price of the product it received as a parameter. If the
                                       // product hasn't been added to the warehouse, the method must return -99.
        return productPrice.getOrDefault(product, -99);
    }

    public int stock(String product) {

        return productStock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (productStock.containsKey(product)) {
            if (productStock.get(product) - 1 < 0) {
                return false;
            } else {
                productStock.put(product, productStock.get(product) - 1);
                return true;
            }
        } else {
            return false;
        }
    }

    public Set<String> products(){ // .keySet() metode atgrž HashMap masivu ar keys, piem., ["abols", "mandarins", "..."] . Set<String> vienkarši glaba info tikai par mainigo Set<String> name = new HashSet<>().
    return productPrice.keySet();

    
    }
}
