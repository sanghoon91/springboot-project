package com.green.nowon.domain.dao;

import org.apache.ibatis.annotations.Mapper;

import com.green.nowon.domain.dto.GoodsSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;

@Mapper
public interface GoodsMapper {

	void saveImage(S3UploadDTO gno);

	void save(GoodsSaveDTO dto);

}
