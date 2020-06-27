package net.jjwallace.thymeleaf.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {
	
    @ExceptionHandler()
	public String handleException(Exception e, Model model){
		String[] message = e.getMessage().split("[\"]");		
		EmployeeErrorResponse error = new EmployeeErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Invlaid Customer ID: " + message[message.length - 1]);
		error.setTimeStamp(System.currentTimeMillis());
		model.addAttribute("error", error);
		return "error";
	}
}
