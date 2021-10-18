package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list" ,list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping("add")
	public String add(GuestbookVo vo) {
		
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int no, Model model) {
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="delete/{no}", method=RequestMethod.POST)
	public String delete(@PathVariable("no") int no, String password) {
		guestbookRepository.delete(no, password);
		return "redirect:/";
	}

}
