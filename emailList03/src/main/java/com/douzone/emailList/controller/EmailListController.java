package com.douzone.emailList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.emailList.repository.EmailListRepository;
import com.douzone.emailList.vo.EmailListVo;

@Controller
public class EmailListController {
	
	@Autowired
	private EmailListRepository emailListRepository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmailListVo> list = emailListRepository.findAll();
		model.addAttribute("list" ,list);
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmailListVo vo) {
		EmailListRepository.insert(vo);
		return "redirect:/";
	}
	
}
