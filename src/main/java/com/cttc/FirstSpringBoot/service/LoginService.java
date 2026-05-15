package com.cttc.FirstSpringBoot.service;

import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.repository.LoginRepository;
import com.cttc.FirstSpringBoot.repository.UserJPARepository;

@Service
public class LoginService {

	private LoginRepository loginRepo;

	private UserJPARepository jpaRepository;

	public LoginService(LoginRepository loginRepo, UserJPARepository jpaRepository) {

		this.loginRepo = loginRepo;
		this.jpaRepository = jpaRepository;
	}

	public UserEntity userLogin(String username, String password) {

//		return jpaRepository.findByUserNameAndPassword(username, password);

		return jpaRepository.userLogin(username, password);

//		return loginRepo.userLogin(username, password);
	}
}
