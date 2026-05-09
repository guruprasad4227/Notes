package com.cttc.FirstSpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cttc.FirstSpringBoot.model.UserDetailsDTO;
import com.cttc.FirstSpringBoot.service.RegisterService;

@RequestMapping("/register")
@Controller
public class RegisterController {

	private RegisterService registerService;

	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@GetMapping("/")
	String home() {
		return "register";
	}

	@PostMapping("/userregister")
	String userRegister(UserDetailsDTO userDetails, Model model) {
		System.out.println(userDetails);
		Integer userSave = registerService.userSave(userDetails.getUserName(), userDetails.getPassword(),
				userDetails.getAge());
		if (userSave > 0) {
			model.addAttribute("name", userDetails.getUserName());
		}
		return "redirect:test";
	}

	@GetMapping("/test")
	String test(Model model) {
		System.out.println("inside test");
		String show = registerService.show();
		model.addAttribute("name", show);
		return "login";
	}

	@GetMapping("/demo")
	String demo() {
		return "demo";
	}
}
