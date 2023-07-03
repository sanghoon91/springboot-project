package com.green.nowon.service;

import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.CouponDTO;

public interface CouponService {

	void findCoupon(CouponDTO dto);

}
