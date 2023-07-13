package com.green.nowon.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.GoodsSaveDTO;
import com.green.nowon.service.FileUploadService;
import com.green.nowon.service.GoodsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class GoodsController {
	
	private final GoodsService service;
	private final FileUploadService fileService;
	
	@GetMapping("/goods")
	public String goods() {
		return "write";
	}
	
	@ResponseBody
	@PostMapping("/admin/goods")
	public boolean save(GoodsSaveDTO dto) {
		service.save(dto);
		//System.out.println(dto);
		return true;
	}
	@GetMapping("/goods/{goodsNo}")
	public String detail(@PathVariable long goodsNo, Model model) {
		service.detailProcess(goodsNo, model);
		return "menu/detail";
	}
	
	@ResponseBody
	@GetMapping("/admin/goods/new")
	public ModelAndView write() {
		return new ModelAndView("admin/admin");
	}
	
	@ResponseBody
	@PostMapping("/admin/goods/temp-img")
	public Map<String,String> tempUpload(MultipartFile temp){
		return fileService.tempUploadProcess(temp);
	}
}
