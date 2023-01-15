package com.example.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.exam.model.Model;
import com.example.exam.repo.Repo;

@org.springframework.stereotype.Controller

public class Controller {
	@Autowired
	Repo repo;
	@RequestMapping("index")
	public String index() {
		return( "index.jsp");
	}
	
	@RequestMapping("addEmp")
	public String addemp(Model model) {
		repo.save(model);
		return ("index.jsp");
	}
	
	@RequestMapping("getEmp")
	public ModelAndView getEmp(@RequestParam int id ) {
		ModelAndView mv =new ModelAndView("display.jsp");
		Model model=repo.findById(id).orElse(new Model());
		mv.addObject(model);
		return mv;
		
	}
	
	@RequestMapping("delEmp")
	public ModelAndView delEmp(@RequestParam int id)
	{
		ModelAndView mv=new ModelAndView("delete.jsp");
				repo.deleteById(id);
		return mv;
		
	}
	
	@RequestMapping("updEmp")
	public ModelAndView updEmp(@RequestParam int id )
	{
		
		ModelAndView mv=new ModelAndView("update.jsp");
		Model model =repo.findById(id).orElse(new Model());
		mv.addObject(model);
		return mv;
	}
}
