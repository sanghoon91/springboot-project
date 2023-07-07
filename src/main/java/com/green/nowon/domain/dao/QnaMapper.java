package com.green.nowon.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.QnaBoardDTO;
import com.green.nowon.domain.dto.QnaSaveDTO;

@Mapper
public interface QnaMapper {

	void save(QnaSaveDTO dto);

	List<QnaBoardDTO> findByWriter();

}
