package com.product.backend.apirest.models.services;

import java.util.List;

import com.product.backend.apirest.models.entity.Product;

public interface IProductService {

	public List<Product> findAll();

	public void save(Product product);

	public Product findById(Long id);

	public void delete(Product product);
}
