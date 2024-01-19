package com.product.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.backend.apirest.models.dao.IProductDAO;
import com.product.backend.apirest.models.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return (List<Product>) productDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Product product) {
		productDAO.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		return productDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Product product) {
		productDAO.delete(product);

	}

}
