package com.green.nowon.utils;

import lombok.Getter;

@Getter
public class PageData {
	private int tot;//페이지총개수
	private int from;//출력되는 페이지 시작번호
	private int to; //출력되는 페이지 마지막번호
	
	private boolean hasNext;
	private int page;
	
	
	public static PageData create(int page, int limit, int rowCount) {
		return new PageData(page, limit, rowCount);
	}
	public static PageData create(int page,  int limit, int rowCount, int RANGE) {
		return new PageData(page, limit, rowCount, RANGE);
	}
	
	private PageData(int page, int limit, int rowCount, int RANGE){
		//int LIMIT=limit;  //한페이지에 표현되는 게시글 개수
		//int RANGE=range; //한페이지에 표현되는 페이지번호 개수
		this.hasNext=rowCount > limit*page?true:false;
		this.page=page;
		
		this.tot=rowCount/limit;
		if(rowCount%limit >0) this.tot++; //나머지가 존재하면 1증가
		
		int rangeNo=page/RANGE; //1~9:0 10:1
		if(page%RANGE>0)rangeNo++; ///1~10:1
		
		this.to=RANGE*rangeNo; //페이지 마지막번호
		this.from=to-RANGE+1; //페이지 시작번호
		
		if(this.to > this.tot)this.to=this.tot;
		
	}
	
	
	private PageData(int page, int limit, int rowCount){
		this(page,limit,rowCount,10);		
		
	}
}
