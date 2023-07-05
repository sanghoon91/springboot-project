package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QnaController {
	
	@ResponseBody
	@GetMapping("/faq")
	public ModelAndView faq() {
		return new ModelAndView("/qna/faq");
	}
	
	@ResponseBody
	@GetMapping("/qna-board")
	public ModelAndView qnaBoard() {
		return new ModelAndView("/qna/qnaBoard");
	}
}
