package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping(value ="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basic() {
		
		log.info("basic");
		
	
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) { // url로 받기 name과 age값을 받기 ?name=aaa&age=10
		
		log.info(""+dto); //@data어노테이션으로 인한 자동 getter메소드 불러옴 자동으로 필드값 반환해줌
		
		return "ex01";
		
		
	}
	
	@GetMapping("/ex02") //url에 값이 나오는 것 정보 노출 형태
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age ) {
		
		log.info("name :" + name);
		log.info("age :"+age);
		
		return "ex02";
		
	}

}
