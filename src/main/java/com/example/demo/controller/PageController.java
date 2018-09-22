package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	


	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value= "name") String name, Model model) {
		model.addAttribute("name", name);
		return "challenge";
	}
	
	@RequestMapping(value={"/challenge/","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name,Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "KB");
		}
		
		
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam("a") int aValue, @RequestParam("b") int bValue, Model model) {
		String aResult ="h";
		
		String result = "";
		
		model.addAttribute("aValue", aValue);
		model.addAttribute("bValue", bValue);
		if(aValue <= 1 && bValue<=1) {
			result+= "hm";	
		}
		else if(aValue<=1 && bValue>1) {
			aResult += "m";
			
			for(int j= bValue;j>0;j--) {
				result+= aResult + " ";
			}
		}
		
		else if(aValue>1 && bValue<=1) {
			for(int i= aValue;i>0;i--) {
				aResult += "m";
				System.out.println(1);
			}
			result += aResult;
			
		}
		
		else {
			for(int i= aValue;i>0;i--) {
				aResult += "m";
				System.out.println(1);
			}
			for(int j= bValue;j>0;j--) {
				result+= aResult + " ";
			}
		}
		model.addAttribute("result", result);
		return "generator";	
	}
	
	
	
}


