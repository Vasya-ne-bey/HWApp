package org.skypro.skyshop.basket;


import org.skypro.skyshop.searchables.product.Product;

import java.util.*;

public class ProductBasket {


    private Map<String, List<Product>> productsMap = new HashMap<>();


    public void addProduct(Product newProduct) {

        String productName = newProduct.getName();     // ключ

        if (! productsMap.containsKey(productName)) {
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



        System.out.println("COUNT TOTAL SUM START");

        int sum = 0;

        Set<String> keys = productsMap.keySet();

        for (String productName : keys) {     // для каждой строки в списке keys
            List<Product> productList = productsMap.get(productName);       // это не get на productName, это get на List

            for (int i = 0; i < productList.size(); i++) {

                Product product = productList.get(i);

                int price = product.getPrice();
                sum += price;   // sum = sum + price;
            }
        }


        return sum;

    }

    public void printBasket() {

        System.out.println("PRINT BASKET START");
        System.out.println(productsMap);

        int countSpecial = 0;


        Set<String> keys = productsMap.keySet();

        for (String productName : keys) {     // для каждой строки в списке keys
            List<Product> productList = productsMap.get(productName);       // это не get на productName, это get на List

            for (int i = 0; i < productList.size(); i++) {
                Product product = productList.get(i);
                System.out.println(product);

                if (product.isSpecial()) {
                    countSpecial++;
                }
            }

            System.out.println("Итого: " + countTotalSum());
            System.out.println("Специальных товаров: " + countSpecial);
        }
    }



    public void cleanBasket() {

        productsMap.clear();

        System.out.println(" Корзина очищена ");
    }

}


