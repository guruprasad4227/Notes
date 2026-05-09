package com.cttc.FirstSpringBoot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.model.UserDetailsDTO;
import com.cttc.FirstSpringBoot.repository.LoginRepository;

@Service
public class LoginService {

	private LoginRepository loginRepo;

	public LoginService(LoginRepository loginRepo) {

		this.loginRepo = loginRepo;
	}

	public UserDetailsDTO userLogin(String username, String password) {

		return loginRepo.userLogin(username, password);
	}
}
