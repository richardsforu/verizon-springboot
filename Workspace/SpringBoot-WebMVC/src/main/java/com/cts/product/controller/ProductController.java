package com.cts.product.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes("s1")
public class ProductController {

	@RequestMapping("/s1")
	public void f1() {
		System.out.println("--- ProductController f1 method");

	}
	
	
	@RequestMapping("/s2")
	public String f2() {
		System.out.println("--- ProductController f2 method");
		return "one";
	}
	
	@RequestMapping("/s3")
	public ModelAndView f3() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("one");
		return mav;
	}
	
	//@RequestMapping("/s4")
	@GetMapping("/s4")
	public ModelAndView f4(Model data) {
		ModelAndView mav=new ModelAndView();
		data.addAttribute("user", "Praveen");
		mav.setViewName("two");
		return mav;
	}
	
	//@RequestMapping(value="/s5",method=RequestMethod.DELETE)
	@DeleteMapping("/s5")
	public ModelAndView f4() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("user", "Richards");
		mav.addObject("s1","Session data");
		mav.setViewName("two");
		return mav;
	}
	
	


}
