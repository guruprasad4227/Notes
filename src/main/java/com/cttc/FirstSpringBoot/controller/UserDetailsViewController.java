package com.cttc.FirstSpringBoot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/userview")
@Controller
@Slf4j
public class UserDetailsViewController {

	private UserDetailsService userDetailsService;

	public UserDetailsViewController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/viewdetails")
	String userView(Model model) {
		List<UserEntity> userView = userDetailsService.userView();
		log.info(" user: " + userView);
		model.addAttribute("userDetails", userView);
		return "userdetails";
	}

	@GetMapping("/delete/{userId}")
	String deleteUser(@PathVariable Integer userId) {
		System.out.println(userId);
		userDetailsService.delete(userId);

		return "redirect:viewdetails";
	}

	@GetMapping("/edit/{userId}")
	public String editUser(@PathVariable Integer userId, Model model) {
		UserEntity singleUser = userDetailsService.edit(userId);
		System.out.println(singleUser);
		model.addAttribute("user", singleUser);
		return "userdetails";
	}

}
