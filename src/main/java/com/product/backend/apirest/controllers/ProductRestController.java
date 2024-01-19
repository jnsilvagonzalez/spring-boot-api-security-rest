package com.product.backend.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.backend.apirest.models.entity.Product;
import com.product.backend.apirest.models.services.IProductService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public List<Product> index() {
		return productService.findAll();
	}

	@GetMapping("/products/{id}")
	public Product show(@PathVariable Long id) {
		return this.productService.findById(id);
	}

	@PostMapping("/products")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		product.setCreateAt(new Date());
		this.productService.save(product);
		return product;
	}

	@PutMapping("/products/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product, @PathVariable Long id) {
		Product currentProduct = this.productService.findById(id);
		currentProduct.setName(product.getName());
		currentProduct.setDescription(product.getDescription());
		currentProduct.setQuantity(product.getQuantity());
		this.productService.save(currentProduct);
		return currentProduct;
	}

	@DeleteMapping("/products/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Product currentProduct = this.productService.findById(id);
		this.productService.delete(currentProduct);
	}
}
