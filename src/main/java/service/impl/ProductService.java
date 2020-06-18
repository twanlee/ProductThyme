package service.impl;

import model.Product;
import service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Note 10",20000,3));
        products.put(2,new Product(2,"Ultra S10",20000,3));
        products.put(3,new Product(3,"IPhone 11",20000,3));
        products.put(4,new Product(4,"IPhone 11 Pro Max",20000,3));
        products.put(5,new Product(5,"Samsung S20",20000,3));
    }
    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }
}
