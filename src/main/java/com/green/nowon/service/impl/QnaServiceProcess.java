package com.green.nowon.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dao.QnaMapper;
import com.green.nowon.domain.dto.QnaSaveDTO;
import com.green.nowon.service.QnaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QnaServiceProcess implements QnaService{
	
	private final QnaMapper mapper;
	
	@Override
	public void saveProcess(QnaSaveDTO dto) {
		mapper.save(dto);
	}

	@Override
	public ModelAndView qnaList() {
		ModelAndView mv=new ModelAndView("qna/qnaBoard");
		mv.addObject("list",mapper.findByWriter() ); 
		return mv;
	}

}
