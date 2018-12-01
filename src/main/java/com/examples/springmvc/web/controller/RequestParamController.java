package com.examples.springmvc.web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/requestparam")
public class RequestParamController {

	@RequestMapping(value="/method9")
	@ResponseBody
	public String method9(@RequestParam("id") int id){
		return "method9 with id= "+id;
	}
	
	
	/*@RequestMapping(value="/method9")
	@ResponseBody
	public String method9(@QuaryParam("id") int id){
		return "method9 with id= "+id;
	}
	*/
	

}
