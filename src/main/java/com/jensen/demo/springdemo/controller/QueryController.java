package com.jensen.demo.springdemo.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jensen.demo.springdemo.annotation.Liuyali;
import com.jensen.demo.springdemo.vo.Info;

@Controller
@RequestMapping("/query")
public class QueryController {
	
	@GetMapping("/info")
	@Liuyali
	// 需要去掉@ResponseBody注解
	public Info getInfo() {
		Info info = new Info();
		info.setName("dzs");
		info.setAmount(new BigDecimal("5.20"));
		return info;
	}
}
