package cn.ccsu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import cn.ccsu.service.IAdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public AdminController() {

	}

	@Autowired
	private IAdminService service;

	// @RequestMapping("/skip")
	// public String skip() {
	// return "functionOptions";
	// }

	@RequestMapping("/login")
	public String login(@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password) {

		if (account.length() == 0) {
			account = null;
		}
		if (password.length() == 0) {
			password = null;
		}
		if (service.validateIdentify(account, password)) {
			return "functionOptions";
		}
		return "loginError"; // 登录失败界面

	}
}
