package com.cttc.FirstSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.repository.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	public String show() {
		return "cttc";
	}

	public Integer userSave(String name, String password, Integer age) {
		return registerRepository.userRegister(name, password, age);

	}

}
