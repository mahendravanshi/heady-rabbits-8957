package com.masaischool.exceptions;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetail {

	private String message;
	
	private LocalDateTime localDateTime = LocalDateTime.now();
	
	private String uri;
}
