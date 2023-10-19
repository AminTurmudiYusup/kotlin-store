package entity;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        Product product = new Product("1", "Bag", 13);
        list.add(product);
        for (Product product1 : list) {
            if (product1.getId().equals("1")) {
                product1.setProductStock(12);
                list.add(product1);
            }

        }
    }
}
