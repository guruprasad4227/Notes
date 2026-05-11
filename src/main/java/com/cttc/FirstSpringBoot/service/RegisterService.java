package com.cttc.FirstSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.repository.RegisterRepository;
import com.cttc.FirstSpringBoot.repository.UserJPARepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private UserJPARepository userjpaRepository;

	public String show() {
		return "cttc";
	}

	// through spring jdbc
//	public Integer userSave(String name, String password, Integer age) {
//		return registerRepository.userRegister(name, password, age);
//
//	}

	// through spring JPAuserjpaRepository
	public UserEntity userSave(UserEntity userDetails) {
		return userjpaRepository.save(userDetails);
	}

}
