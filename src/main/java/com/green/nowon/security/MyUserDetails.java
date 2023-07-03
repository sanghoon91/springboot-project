package com.green.nowon.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.green.nowon.domain.dao.MemberMapper;
import com.green.nowon.domain.dto.MemberDTO;

import lombok.Getter;

@Component
public class MyUserDetails implements UserDetailsService{
	
	
	@Autowired
	private MemberMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String member) throws UsernameNotFoundException {
		
		MemberDTO result = mapper.findByMember(member).orElseThrow(()-> new UsernameNotFoundException("존재하지않아요"));
		System.out.println(">>"+result);
		Set<SimpleGrantedAuthority> grantedAuthority=result.getRoles().stream()
				.map(role->new SimpleGrantedAuthority(role.roleName())) 
				.collect(Collectors.toSet());
		
		return new User(result.getMember(), result.getPassword(), grantedAuthority);
	}

	

	
}