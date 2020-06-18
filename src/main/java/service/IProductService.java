package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void add(Product product);
    void delete(int id);
    Product findById(int id);
    void update(int id, Product product);
}
