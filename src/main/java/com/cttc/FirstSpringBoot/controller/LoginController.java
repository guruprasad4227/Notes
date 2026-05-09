package com.cttc.FirstSpringBoot.controller;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cttc.FirstSpringBoot.model.UserDetailsDTO;
import com.cttc.FirstSpringBoot.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/login")
@Controller
@Slf4j
public class LoginController {
	
	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/")
	String goToLogin() {
		return "login";
	}

	@PostMapping("/userlogin")
	String userLogin(@RequestParam String username, @RequestParam String password, HttpSession httpSession,
			Model model) {

		UserDetailsDTO userLogin = loginService.userLogin(username, password);
		if (userLogin != null) {
			log.info("inside login...");
			httpSession.setAttribute("user", userLogin);
			return "redirect:home";
		} else {
			return "login";
		}
	}
	@GetMapping("/home")
	String goToHome() {
		return "home";
	}
}
