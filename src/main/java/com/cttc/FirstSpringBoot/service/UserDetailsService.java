package com.cttc.FirstSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.repository.UserJPARepository;

@Service
public class UserDetailsService {

	@Autowired
	private UserJPARepository detailsRepository;

	public List<UserEntity> userView() {

		return detailsRepository.findAll();
	}
}
