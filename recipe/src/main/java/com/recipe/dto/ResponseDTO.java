package com.recipe.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ResponseDTO<T> {
	
	private String status;
	private String message;
	private T data;
	private LocalDateTime timestamp;

	public ResponseDTO() {
	}

	public ResponseDTO(String status, String message, T data) {
		this.status = status;
		this.message = message;
		this.data = data;
		this.timestamp = java.time.LocalDateTime.now();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	
	
	

}
