package com.sgu.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgu.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	List<Order> findAllByUser_id(String user_id);

	Order findById(int id);
	
	Page<Order> findAll(Pageable pageable);

	void deleteById(int id);
	
}
