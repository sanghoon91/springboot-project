package com.green.nowon.domain.dao;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodsListDTO;
import com.green.nowon.domain.dto.GoodsSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;

@Mapper
public interface GoodsMapper {

	void saveImage(S3UploadDTO gno);

	void save(GoodsSaveDTO dto);

	List<GoodsListDTO> findAll();

}
