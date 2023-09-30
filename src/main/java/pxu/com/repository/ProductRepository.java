package pxu.com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pxu.com.model.Product;

@Repository("productRepository")
public interface ProductRepository  extends JpaRepository<Product, Integer>{

}
