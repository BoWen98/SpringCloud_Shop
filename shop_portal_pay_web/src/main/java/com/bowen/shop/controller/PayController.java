package com.bowen.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
