package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.CouponDTO;

@Mapper
public interface CouponMapper {

	CouponDTO findCoupon(CouponDTO dto);

}
