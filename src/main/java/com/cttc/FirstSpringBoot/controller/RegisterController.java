package com.cttc.FirstSpringBoot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cttc.FirstSpringBoot.entity.UserEntity;
import com.cttc.FirstSpringBoot.service.RegisterService;

@RequestMapping("/register")
@RestController
@CrossOrigin("*")
public class RegisterController {

	private RegisterService registerService;

	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
	}

	@GetMapping("/register")
	String home() {
		return "register";
	}
//
//	@PostMapping("/userregister")
//	String userRegister(UserEntity userDetails, Model model) {
//		System.out.println(userDetails);
//		UserEntity userSave = registerService.userSave(userDetails);
//		if (userSave != null) {
//			model.addAttribute("success", "Registration success");
//		} else {
//			model.addAttribute("error", "Registration failed");
//		}
//		return "redirect:test";
//	}

//	@PostMapping("/userregister")
//	UserEntity userRegister(@RequestBody UserEntity user) {
//		UserEntity userSave = registerService.userSave(user);
//		return userSave;
//	}
//	

	@PostMapping("/userregister")
	UserEntity userRegister(@RequestParam String userName, @RequestParam String password, @RequestParam String age,
			@RequestParam String salary, @RequestParam String email, @RequestParam MultipartFile image) {
		UserEntity user = new UserEntity();
		user.setUserName(userName);
		user.setPassword(password);
		user.setSalary(Double.parseDouble(salary));
		user.setAge(Integer.parseInt(age));
		user.setUserMail(email);
		UserEntity userSave = registerService.userSave(user, image);
		return userSave;
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
