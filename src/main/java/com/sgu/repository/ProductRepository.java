package com.sgu.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgu.entity.Product;
import com.sgu.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
	Page<Product> findAllByCategory_id(int id, Pageable pageable);
	
	Product findById(String id);
	
	@Transactional
	void deleteById(String id);
}
