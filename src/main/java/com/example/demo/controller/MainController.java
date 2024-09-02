package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 홈페이지 구성, GET 방식 화면은 "index"만 출력 구성하시오
 * 실습 1분
 * @author KT
 *
 */
@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
//	@ResponseBody
	public String home() {
		return "index";
	}
}



