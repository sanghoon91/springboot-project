package com.green.nowon.domain.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	void save(MemberDTO dto);

	Optional<MemberDTO> findByMember(String member);

}
