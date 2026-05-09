package com.cttc.FirstSpringBoot.repository;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cttc.FirstSpringBoot.model.UserDetailsDTO;

@Repository
public class UserDetailsRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<UserDetailsDTO> userView() {
		String query = "select * from user_details";
		List<UserDetailsDTO> users = jdbcTemplate.query(query, (rs, rowNum) -> {
			UserDetailsDTO userDto = new UserDetailsDTO();
			userDto.setUserName(rs.getString("user_name"));
			userDto.setAge(Integer.parseInt(rs.getString("age")));
			return userDto;
		});
		if (users.isEmpty()) {
			return Collections.emptyList();
		} else {
			return users;
		}
	}
}
