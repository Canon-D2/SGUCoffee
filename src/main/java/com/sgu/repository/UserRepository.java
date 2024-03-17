package com.sgu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgu.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Transactional
	User findById(String id);
	
	@Transactional
	User findByIdAndRole(String id, String role);
	
	@Transactional
	void deleteById(String id);
}
