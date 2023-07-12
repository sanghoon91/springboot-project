package com.green.nowon.domain.dto;

import lombok.Data;

@Data
public class GoodsListDTO {
	
	private String bucketKey;
	
	private String defImg;
	
	public GoodsListDTO defImg(String domain) {
		defImg = domain + bucketKey;
		return this;		
	}
	
	private long no;
	private String name;
	private int price;
	private String content;
	
}
