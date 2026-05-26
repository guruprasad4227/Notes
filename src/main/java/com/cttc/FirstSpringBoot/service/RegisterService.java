package com.cttc.FirstSpringBoot.service;

import java.util.Random;

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

	@Autowired
	private EmailService emailService;

	public String show() {
		return "cttc";
	}

	// through spring jdbc
//	public Integer userSave(String name, String password, Integer age) {
//		return registerRepository.userRegister(name, password, age);
//
//	}

	// through spring JPA
	public UserEntity userSave(UserEntity userDetails) {
		Random r = new Random();
		int nextInt = r.nextInt(900000) + 100000;
		UserEntity save = userjpaRepository.save(userDetails);
		emailService.sendSuccessMessage(userDetails.getUserMail(), userDetails.getUserName(), nextInt);
		return save;
	}

}
