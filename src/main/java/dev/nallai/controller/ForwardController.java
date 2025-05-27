package dev.nallai.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ForwardController
{
	public String forward()
	{
		return "forward:/index.html";
	}
}
