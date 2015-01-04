package br.com.devmedia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("bemVindo")
	public String bemvindo(){
		return "bemVindo";
	}
	@RequestMapping("tomaNoCuJava")
	public String tomaNoCuJava(){
		return "tomaNoCuJava";
	}
}
