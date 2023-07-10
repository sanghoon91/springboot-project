package com.green.nowon.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.domain.dto.QnaSaveDTO;

public interface QnaService {

	void saveProcess(QnaSaveDTO dto);

	ModelAndView qnaList(int page);

	void detailProcess(long no, Model model);

}
