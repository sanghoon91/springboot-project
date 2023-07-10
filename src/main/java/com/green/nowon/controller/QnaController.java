package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.QnaSaveDTO;
import com.green.nowon.service.QnaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QnaController {
	
	private final QnaService service;
	
	@ResponseBody
	@GetMapping("/faq")
	public ModelAndView faq() {
		return new ModelAndView("qna/faq");
	}
	/*
	@ResponseBody
	@GetMapping("/qna-board")
	public ModelAndView qnaBoard() {
		
		return service.qnaList();
		//return new ModelAndView("qna/qnaBoard");
	}
	*/
	@ResponseBody
	@GetMapping("/qna-board")
	public ModelAndView qnaBoard() {
		
		return new ModelAndView("qna/board/page");
		//return new ModelAndView("qna/qnaBoard");
	}
	
	@ResponseBody
	@PatchMapping("/qna-board")
	public ModelAndView qnaList(@RequestParam(defaultValue = "1") int page) {
		
		return service.qnaList(page);
		//return new ModelAndView("qna/qnaBoard");
	}
	
	@ResponseBody
	@GetMapping("/qna-board/write")
	public ModelAndView write() {
		return new ModelAndView("qna/board/write");
	}
	
	@ResponseBody
	@PostMapping("/qna-board/write")
	public void save(QnaSaveDTO dto) {
		service.saveProcess(dto);
		
	}
	
	@GetMapping("/qna-board/{no}")
	public String qnaBoard(@PathVariable long no,Model model) {
		service.detailProcess(no, model);
		return "qna/board/detail";
		//return new ModelAndView("qna/qnaBoard");
	}
	
	
	
}
