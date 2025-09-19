package org.skypro.skyshop.basket;


import org.skypro.skyshop.searchables.product.Product;

import java.util.*;

public class ProductBasket {

    private Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product newProduct) {

        String productName = newProduct.getName();     // ключ

        if (!productsMap.containsKey(productName)) {
            ArrayList<Product> productsWithThisName = new ArrayList<>();  // значение
            productsWithThisName.add(newProduct);
            productsMap.put(productName, productsWithThisName);
        } else {
            List<Product> products = productsMap.get(productName);
            products.add(newProduct);
        }

    }

    public List<Product> deleteProductByName(String name) {

        List<Product> deletedProducts = productsMap.remove(name);
        return deletedProducts;

    }

    public boolean checkProduct(String wantedName) {

        boolean answer = productsMap.containsKey(wantedName);
        return answer;

    }

    public int countTotalSum() {

        Collection<List<Product>> products = productsMap.values();

        int pricesSum = products.stream()
                .flatMap(list -> list.stream())
                .mapToInt(apple -> apple.getPrice())
                .sum();

        return pricesSum;

    }

    public void printBasket() {
        Collection<List<Product>> products = productsMap.values();

        int countSpecial = products.stream()
                .flatMap(list -> list.stream())
                .map(apple -> {
                    System.out.println(apple);
                    return apple;
                })
                .filter(apple -> apple.isSpecial())
                .toList()
                .size();

        System.out.println("Итого: " + countTotalSum());
        System.out.println("Специальных товаров: " + countSpecial);

    }

    public void cleanBasket() {

        productsMap.clear();

        System.out.println(" Корзина очищена ");
    }

}


