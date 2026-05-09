package com.cttc.FirstSpringBoot.repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cttc.FirstSpringBoot.model.UserDetailsDTO;

@Repository
public class LoginRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDetailsDTO userLogin(String username, String password) {
		String query = "select * from user_details where user_name = ? and password = ?";
		List<UserDetailsDTO> users = jdbcTemplate.query(query, (rs, rowNum) -> {
			UserDetailsDTO userDto = new UserDetailsDTO();

			userDto.setUserName(rs.getString("user_name"));
			userDto.setAge(Integer.parseInt(rs.getString("age")));
			return userDto;
		}, username, password);

		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
}
