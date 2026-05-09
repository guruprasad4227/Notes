package com.cttc.FirstSpringBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/logout")
public class LogoutController {

	@GetMapping("/logoutSession")
	String logout(HttpSession httpSession) {
		if(httpSession != null) {
			httpSession.invalidate();
		}
		return "login";
	}

}
