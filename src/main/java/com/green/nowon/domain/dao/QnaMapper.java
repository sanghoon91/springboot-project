package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.QnaSaveDTO;

@Mapper
public interface QnaMapper {

	void save(QnaSaveDTO dto);

}
