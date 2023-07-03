package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dao.CouponMapper;
import com.green.nowon.domain.dto.CouponDTO;
import com.green.nowon.service.CouponService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CouponServiceProcess implements CouponService{
	
	private final CouponMapper mapper;
	
	@Override
	public void findCoupon(CouponDTO dto) {
		mapper.findCoupon(dto);
		
	}

}
