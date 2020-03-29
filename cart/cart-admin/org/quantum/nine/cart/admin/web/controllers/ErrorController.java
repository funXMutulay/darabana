package org.quantum.nine.jcart.admin.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	
	@RequestMapping("/403")
	public String accessDenied() {
		return "accessDenied/error" ;
	}

}
