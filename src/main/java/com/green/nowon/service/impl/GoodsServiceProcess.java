package com.green.nowon.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dao.GoodsMapper;
import com.green.nowon.domain.dto.GoodsDetailDTO;
import com.green.nowon.domain.dto.GoodsImgListDTO;
import com.green.nowon.domain.dto.GoodsListDTO;
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
	
	@Value("${cloud.aws.s3.domain}")
	private String domain;
	
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

	@Override
	public void listProcess(Model model) {
		List<GoodsListDTO> result=goodsMapper.findAll().stream()
							.map(dto->dto.defImg(domain))
							.collect(Collectors.toList());
		model.addAttribute("list", result);			
		
	}

	@Override
	public void detailProcess(long goodsNo, Model model) {
		GoodsDetailDTO detail= goodsMapper.detail(goodsNo).orElseThrow();
		model.addAttribute("detail", detail);
		
		List<GoodsImgListDTO> imgs=goodsMapper.imageByDetailNo(goodsNo).stream()
				.map(dto->dto.url(domain))//url 완성 domain+bucketKey
				.collect(Collectors.toList());
		model.addAttribute("imgs",imgs);
	}

}
