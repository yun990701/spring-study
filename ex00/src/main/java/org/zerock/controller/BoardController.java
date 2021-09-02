package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	
	@GetMapping("/list")
	public void list( Model model ) {
		
		log.info("getList........");
		model.addAttribute("list", service.getList());
		
		
	}
	
	//register
	
	
	@GetMapping("/register")
	public void register() {
		
		
		
	}
	
	@PostMapping("/register") //RedirectAttributes 를 사용해서 Moder과 같이 파라미터로 선언하여  view에 사용됨 단, 일회성이라는 특징을 지님..
	public String register(BoardVO board, RedirectAttributes attr) {
		
		service.register(board);
		
		attr.addFlashAttribute("result", board.getBno() );
		
		
		
		return "redirect:/board/list";
		
	}
	//조회, 수정, 삭제
	
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		
		model.addAttribute("board", service.get(bno));
		
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes attr) {
		
		if(service.modify(board)) {
		attr.addFlashAttribute("result","success");
		}
		
		return "redirect:/board/modify";
		
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes attr) {
		
		
		if(service.remove(bno)) {
			
			attr.addAttribute("result", "success");
		}
		
		
		return "redirect:/board/remove";
	}
	
	
	
	

}
