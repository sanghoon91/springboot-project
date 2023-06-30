package com.green.nowon.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceProcess implements MemberService{
	
	
	private final MemberMapper mapper;
	
	private final PasswordEncoder encode=new BCryptPasswordEncoder();
	
	@Override
	public void saveMember(MemberDTO dto) {
		dto.setPassword(encode.encode(dto.getPassword()));
		mapper.save(dto);
		
	}
	
	

}
