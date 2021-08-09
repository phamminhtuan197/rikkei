package com.rikkei.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rikkei.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{
	
	@Query(value = "select * from orderdetails where order_id = ?", nativeQuery = true)
	List<OrderDetail> findByOrderId(int id);
	
	@Query(value = "select * from orderdetails where product_id = ?", nativeQuery = true)
	List<OrderDetail> findByProductId(Long id);
}
