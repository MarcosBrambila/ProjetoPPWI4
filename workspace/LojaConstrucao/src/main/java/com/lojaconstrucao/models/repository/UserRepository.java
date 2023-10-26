package com.lojaconstrucao.models.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lojaconstrucao.models.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userName =:key")
	public List<User> findByUserName(@Param("key") String key);

	@Query("SELECT u FROM User u WHERE u.email =:email")
	public Optional<User> findByEmail(@Param("email") String email);

	@Query(value = "SELECT u FROM User u", countQuery = "SELECT COUNT(u) FROM User u")
	public Page<User> findAllPagination(Pageable page);
	
	@Query(value = "SELECT u FROM User u WHERE u.id LIKE(CONCAT('%',:key,'%')) OR u.userName LIKE(CONCAT('%',:key,'%')) OR u.email LIKE(CONCAT('%',:key,'%')) ", countQuery = "SELECT COUNT(u) FROM User u")
	public Page<User> findAllPaginationWithKey(@Param("key") String key, Pageable page);
	
}
