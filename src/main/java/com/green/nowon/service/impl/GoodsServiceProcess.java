package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;

import com.green.nowon.domain.dao.GoodsMapper;
import com.green.nowon.domain.dto.GoodsSaveDTO;
import com.green.nowon.domain.dto.S3UploadDTO;
import com.green.nowon.service.FileUploadService;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GoodsServiceProcess implements GoodsService{
	
	private final GoodsMapper goodsMapper;
	private final FileUploadService fileService;
	
	@Override
	public void save(GoodsSaveDTO dto) {
		//1.상품정보 저장
		goodsMapper.save(dto);
		dto.files().forEach(img->{
			//temp->src			
			S3UploadDTO uploadResult=fileService.tempToUpload(img);		
			goodsMapper.saveImage(uploadResult.gno(dto.getNo()));
		});
		
		
	}

}
