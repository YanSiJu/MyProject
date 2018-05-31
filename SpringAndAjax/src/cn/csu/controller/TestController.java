package cn.csu.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import cn.csu.entity.User;

@Controller
public class TestController {

	/**
	 * 转到页面
	 */
	@RequestMapping(value = "/hello")
	public ModelAndView list() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	/**
	 * 转到login页面
	 */
	@RequestMapping(value = "/loginDispatcher")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("login");
		System.out.println("-----------------loginDispatcher-----------------");
		return view;
	}

	/**
	 * 转到页面
	 */
	
	
	@ResponseBody
	@RequestMapping(value = "/login")
	public Map<String, String> login(@RequestBody User user) {
		System.out.println("-----------------login begin-----------------");
		System.out.println(user);
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", "loginSuccess!!!");
		System.out.println("-----------------login end-----------------");
		return result;
	}

	/**
	 * 转到页面
	 */
	@RequestMapping(value = "/dispatcher")
	public ModelAndView view() {
		ModelAndView view = new ModelAndView("Ajax");
		return view;
	}

	/**
	 * ajax异步请求， 请求格式是json
	 */
	@RequestMapping(value = "/hello.json")
	@ResponseBody
	public Map<String, String> hello(@RequestBody User user) {
		System.out.println(user);
		// 返回数据的Map集合
		Map<String, String> result = new HashMap<String, String>();

		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 返回请求的username
		result.put("username", user.getUsername());
		// 返回年龄
		result.put("age", String.valueOf(user.getAge()));
		// 返回当前时间
		result.put("time", format.format(new Date()));
		System.out.println("-----------------Hello-----------------");
		return result;
	}


	@ResponseBody
	@RequestMapping(value = "/Ajax")
	public Map<String, String> ajax(@RequestBody String data) {
		System.out.println("-----------------ajax begin-----------------");
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(data);
			System.out.println(jsonObject + "------>" + jsonObject.get("data").toString().trim());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// 返回数据的Map集合
		Map<String, String> result = new HashMap<String, String>();
		result.put("data", "AJAX is not a programming language.\r\n");
		result.put("time", LocalDateTime.now().toString());
		System.out.println("-----------------ajax end-----------------");
		return result;
	}
}