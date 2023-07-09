package com.green.nowon.domain.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.QnaBoardDTO;
import com.green.nowon.domain.dto.QnaSaveDTO;

@Mapper
public interface QnaMapper {

	void save(QnaSaveDTO dto);

	List<QnaSaveDTO> findByWriter();

	Optional<QnaSaveDTO> findByNo(long no);

	int countAll();

}
