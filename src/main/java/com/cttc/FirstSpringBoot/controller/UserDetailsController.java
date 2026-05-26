package com.cttc.FirstSpringBoot.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/userview")
@RestController
@Slf4j
@CrossOrigin("*")
public class UserDetailsController {

	private UserDetailsService userDetailsService;

	public UserDetailsController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

//	@GetMapping("/viewdetails")
//	String userView(Model model) {
//		List<UserEntity> userView = userDetailsService.userView();
//		log.info(" user: " + userView);
//		model.addAttribute("userDetails", userView);
//		return "userdetails";
//	}
	
	@GetMapping("/viewdetails")
	List<UserEntity> userView() {
		List<UserEntity> userView = userDetailsService.userView();
		log.info(" user: " + userView);
		return userView;
	}

	@GetMapping("/delete/{userId}")
	String deleteUser(@PathVariable Integer userId) {
		System.out.println(userId);
		userDetailsService.delete(userId);

		return "redirect:viewdetails";
	}

	@GetMapping("/edit/{userId}")
	public String editUser(@PathVariable Integer userId, Model model) {
		System.out.println(userId);
		UserEntity singleUser = userDetailsService.edit(userId);
		System.out.println(singleUser);
		model.addAttribute("user", singleUser);
		return "editdetails";
	}

	@PostMapping("/update")
	String userRegister(UserEntity userDetails, Model model) {
		log.info("userdetails in update : " + userDetails);
		UserEntity userSave = userDetailsService.userUpdate(userDetails);

		return "redirect:viewdetails";
	}

}
