package com.ashokit.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRestController {
	
	@GetMapping("/")
	public String load() {
		return "index";
	}
	
	@GetMapping("/msg")
	@ResponseBody
	public String getMsg(@RequestParam("name")String name) {
		System.out.println("UserRestController.getMsg()");
		String msg="Hello, "+name;
		return msg;
	}
	
	@GetMapping("/cmsg")
	@ResponseBody
	public String getDropdownMsg(@RequestParam("cname")String cname) {
		System.out.println("UserRestController.getDropdownMsg()");
		String msg="I am going to "+cname+" in next month";
		return msg;
	}
}
