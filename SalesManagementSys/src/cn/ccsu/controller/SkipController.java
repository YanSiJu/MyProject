package cn.ccsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/skip")
public class SkipController {

	public SkipController() {
		
	}
	
	
	@RequestMapping("/jump")
	public String jump() {
		return "functionOptions";
		
	}

}
