package com.green.nowon.domain.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.security.MyRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class MemberDTO {
	
	private Long no;
	private String member;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String birth;
	
	private Set<MyRole> roles=new HashSet<>();
	
	
	public MemberDTO addRole(MyRole myRole) {
		roles.add(myRole.USER);
		return this;
	}

	
	public MemberDTO toEncoder(PasswordEncoder encoder) {
	  password=encoder.encode(password); return this; 
	  }
	 
	
}
