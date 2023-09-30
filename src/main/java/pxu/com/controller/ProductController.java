package pxu.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pxu.com.exception.ResourceNotFoundException;
import pxu.com.model.Product;
import pxu.com.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/listproduct")
	public String listCustomers(Model theModel) {
		List<Product> products = productService.getProducts();
		theModel.addAttribute("products", products);
		return "list-customers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Product product = new Product();
		theModel.addAttribute("product", product);
		return "customer-form";
	}

	@PostMapping("/saveProduct")
	public String saveCustomer(@ModelAttribute("product") Product theCustomer) {
		productService.saveProduct(theCustomer);
		return "redirect:/product/listproduct";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("productID") int theId, Model theModel)
			throws ResourceNotFoundException {
		Product product = productService.getProduct(theId);
		theModel.addAttribute("product", product);
		return "update";
	}
	@PostMapping("/edit")
	@Transactional
	public String updateProduct(@ModelAttribute("product") Product product) {
		try {
			productService.updateProduct(product);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/product/listproduct";
	}

	@GetMapping("/deleteproduct")
	public String deleteCustomer(@RequestParam("productID") int theId) throws ResourceNotFoundException {
		productService.deleteProduct(theId);
		return "redirect:/product/listproduct";
	}
}
