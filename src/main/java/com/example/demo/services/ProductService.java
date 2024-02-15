package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAll() {
		return repo.findAll();
	}
	
	public Product findById(UUID id) {
		Optional<Product> obj = repo.findById(id);
		// VOLTAR AQUI, ERRO
		return obj.orElseThrow();
	}
	
	public Product insert(Product obj) {
		return repo.save(obj);
	}
	
	public Product update(UUID id, Product obj) {
		try {
			
			Product entity = findById(id);
			updateData(entity, obj);
			return repo.save(entity);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void updateData(Product entity, Product obj) {
		entity.setTitle(obj.getTitle());
		entity.setPrice(obj.getPrice());
		entity.setQuant(obj.getQuant());
	}
	
	public void delete(UUID id) {
		try { 
			repo.deleteById(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
}











