package com.cttc.FirstSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cttc.FirstSpringBoot.model.UserDetailsDTO;
import com.cttc.FirstSpringBoot.repository.UserDetailsRepository;

@Service
public class UserDetailsService {

	@Autowired
	private UserDetailsRepository detailsRepository;

	public List<UserDetailsDTO> userView() {

		return detailsRepository.userView();
	}
}
