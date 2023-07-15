package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class QnaBoardDTO {
	private long no;
	private String title;
	private String content;
	private LocalDateTime createdDate;
}
