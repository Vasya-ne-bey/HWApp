package org.skypro.skyshop.basket;


import org.skypro.skyshop.searchables.product.Product;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {

    private LinkedList <Product> products = new LinkedList<>();


    public List<Product> deleteProductByName(String name) {
        ArrayList<Product> deletedProducts = new ArrayList<>();

        if (products.isEmpty()) {
            return deletedProducts;
        }

        Iterator<Product> iterator = products.iterator();           //   список: [банан, яблоко, молоко, ...

        while (iterator.hasNext()) { // пока на ковеере что-то есть
            // если у продукта из списка то название, которое мы хотим удалить, то мы его удаляем (следующие 5 строк)
            Product productFromList = iterator.next();  // итератор (кассир) бберёт банан из ссписка, и помещает в переменную продукт
            if (productFromList.getName().equals(name)) {
                iterator.remove();
                deletedProducts.add(productFromList);
            }
        }

        return deletedProducts;
    }


    public boolean checkProduct(String wantedName) {

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) == null) {
                continue;
            }
            if (wantedName.equals(products.get(i).getName())) {
                return true;
            }
        }
        return false;
    }


    public void addProduct(Product newItem) {
        
        products.add(newItem);
    }

    public int countTotal() {

        int sum = 0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            if (product == null) {
                continue;
            }

            int price = product.getPrice();
            sum += price;   // sum = sum + price;
        }
        return sum;

    }

    public void printBasket() {

        int countSpecial = 0;

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);

            if (product == null) {
                continue;
            }

            System.out.println(product);
            if (product.isSpecial()) {
                countSpecial++;
            }
        }

        System.out.println("Итого: " + countTotal());
        System.out.println(" Специальных товаров: " + countSpecial);
    }

    public void cleanBasket() {

        products.clear();

        System.out.println(" Корзина очищена ");
    }

}


