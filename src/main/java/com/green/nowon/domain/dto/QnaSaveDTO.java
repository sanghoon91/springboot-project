package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class QnaSaveDTO {
	Long no;
	String title;
	String content;
	String writer;
	String email;
	long mart_no;
	LocalDateTime createdDate;
	
	
}
