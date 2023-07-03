package com.green.nowon.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.CouponDTO;
import com.green.nowon.service.CouponService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CouponController {
	
	private final CouponService service;
	
	@PatchMapping("/coupon/search")
	public void couponSearch(CouponDTO dto) {
		service.findCoupon(dto);
	}
}
