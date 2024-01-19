package com.product.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.product.backend.apirest.models.entity.Product;

public interface IProductDAO extends CrudRepository<Product, Long>{

}
