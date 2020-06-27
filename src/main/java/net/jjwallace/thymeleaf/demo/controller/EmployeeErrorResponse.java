package net.jjwallace.thymeleaf.demo.controller;

import lombok.Data;

@Data
public class EmployeeErrorResponse {
	
	private int status;
	private String message;
	private long timeStamp;

}
