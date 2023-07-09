package com.green.nowon.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dao.QnaMapper;
import com.green.nowon.domain.dto.QnaSaveDTO;
import com.green.nowon.service.QnaService;
import com.green.nowon.utils.PageData;

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
	public ModelAndView qnaList(int page) {
		ModelAndView mv=new ModelAndView("qna/qnaBoard");
		int limit=3;
		RowBounds rowBounds=new RowBounds((page-1)*limit, limit);
		mv.addObject("list",mapper.findByWriter() ); 
		mv.addObject("pd", PageData.create(page, limit, mapper.countAll(), 5));
		return mv;
	}

	@Override
	public void detailProcess(long no) {
		ModelAndView mv=new ModelAndView("qna/board/detail");
		mv.addObject("detail",mapper.findByNo(no).orElseThrow());
		
	}

}
