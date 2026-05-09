package com.cttc.FirstSpringBoot.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterRepository {

	private final JdbcTemplate jdbcTemplate;

	public RegisterRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Integer userRegister(String name, String password, Integer age) {
		String query = "insert into user_details(user_name, password, age) values(?, ?, ?)";
		return jdbcTemplate.update(query, name, password, age);

	}
}
