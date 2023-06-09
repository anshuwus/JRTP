package com.ashokit.request;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SearchRequest{
	private String planName;
	private String planStatus;
	private String gender;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate startDate;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private LocalDate endDate;
}
