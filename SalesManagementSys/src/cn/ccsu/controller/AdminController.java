package cn.ccsu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public AdminController() {

	}

	@RequestMapping("/login")
	public String login() {

		return "functionOptions";
	}
}
