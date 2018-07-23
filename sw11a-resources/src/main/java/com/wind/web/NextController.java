package com.wind.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/next")
public class NextController {

	@RequestMapping("/{id}")
	public String next1(@PathVariable String id, Model model) {
		model.addAttribute("id",911);
		return "next/pageone";
	}
}
