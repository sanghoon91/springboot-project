package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final MemberService service;
	
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "login/signup";
	}
	
	@PostMapping("/signup")
	public String signup(MemberDTO dto) {
		service.saveMember(dto);
		return "login/login";
	}
	@GetMapping("/coupon")
	public String coupon() {
		return "menu/coupon";
	}
	
	
}
