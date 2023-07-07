package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class QnaBoardDTO {
	long no;
	String title;
	LocalDateTime createdDate;
}
