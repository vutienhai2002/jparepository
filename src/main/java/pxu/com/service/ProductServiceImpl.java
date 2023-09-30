package pxu.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.Product;
import pxu.com.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) throws ResourceNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(theId);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			throw new ResourceNotFoundException(theId);
		}
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(theId);
	}

	@Override
	@Transactional
	public void updateProduct(Product product) throws ResourceNotFoundException {
		Optional<Product> result = productRepository.findById(product.getId());
		if (!result.isPresent()) {
			throw new ResourceNotFoundException(product.getId());
		}
		productRepository.save(product);
	}

}
