package com.gerenciadorapp.gerenciadorapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
}
