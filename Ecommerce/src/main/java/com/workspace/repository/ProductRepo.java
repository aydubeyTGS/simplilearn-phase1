package com.workspace.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.workspace.model.Product;
import com.workspace.model.User;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

List<Product> findByDate(Date date);
	
//	@Query(value="select * from product group by category having = :date", nativeQuery = true)
	@Query(value="select * from product where date = STR_TO_DATE('2021-08-25','%Y-%m-%d') group by category", nativeQuery = true)
	List<Product> findByDateGroupBy(@Param("date") String  date);
}
