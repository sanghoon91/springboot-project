package com.green.nowon.domain.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.nowon.domain.dto.MemberDTO;
import com.green.nowon.security.MyRole;

@Mapper
public interface MemberMapper {

	void save(MemberDTO dto);

	Optional<MemberDTO> findByMember(String member);

	void saveRole(@Param("memberNo") long no,@Param("role") MyRole Role);

}
