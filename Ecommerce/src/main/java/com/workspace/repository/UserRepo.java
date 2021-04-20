package com.workspace.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.workspace.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

	
	
	
//	@Query(value = "SELECT * FROM user WHERE role='admin'", nativeQuery = true)
//	List<User> getSignedUser();
	
	List<User> findByRole(String role);
	
	User findByUsernameAndPasswordAndRole(String username,String password, String role);

	User findByUsernameAndPassword(String username, String password);
    
	@Modifying(clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query(value = "update user set password = ':password' WHERE username=':username'", nativeQuery = true)
	int updateUserPwd(@Param("username")String username, @Param("password") String password);
//	@Query()
//	void findByUsernameAndPasswordAndRole(String username, String pwd, String role);
}
