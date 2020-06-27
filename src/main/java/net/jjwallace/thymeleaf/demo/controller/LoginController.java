package net.jjwallace.thymeleaf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@GetMapping("/login")
	public String showMyLoginPage() {
		return "bootstrap-login";
	}
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "/access-denied";
	}
	
}
