package com.cttc.FirstSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cttc.FirstSpringBoot.entity.UserEntity;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, Integer> {

// UserEntity findByUserNameAndPassword(String username, String password);

// @Query(value = "select * from user_details where user_name =:username and password =:password",nativeQuery = true)
// UserEntity userLogin(@Param("username") String username, @Param("password") String password);

	@Query("From UserEntity where userName =:username and password =:password")
	UserEntity userLogin(@Param("username") String username, @Param("password") String password);

}
