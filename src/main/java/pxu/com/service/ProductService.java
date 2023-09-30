package pxu.com.service;

import java.util.List;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.Product;

public interface ProductService {
	public List<Product> getProducts();

	public void saveProduct(Product product);

	public Product getProduct(int theId) throws ResourceNotFoundException;

	public void deleteProduct(int theId) throws ResourceNotFoundException;

	public void updateProduct(Product product) throws ResourceNotFoundException;

}
