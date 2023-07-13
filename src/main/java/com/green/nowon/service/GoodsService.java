package com.green.nowon.service;

import org.springframework.ui.Model;

import com.green.nowon.domain.dto.GoodsSaveDTO;

public interface GoodsService {

	void save(GoodsSaveDTO dto);

	void listProcess(Model model);

	void detailProcess(long goodsNo, Model model);

}
