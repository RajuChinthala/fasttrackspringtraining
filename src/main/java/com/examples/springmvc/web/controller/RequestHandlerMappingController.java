package com.examples.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/api")
public class RequestHandlerMappingController {
	

	@RequestMapping()
	@ResponseBody
	public String defaultMethod(){
		return "default method";
	}
	

	@RequestMapping("*")
	@ResponseBody
	public String fallbackMethod(){
		return "fallback method";
	}



	@RequestMapping(value={"/hello/url1","/hello/url2"})
	@ResponseBody
	public String sameMethodWithMultipeUrls(){
		return "sameMethodWithMultipeUrls";
	}

	//@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);
		return model;

	}
	
	//http://localhost:2001/spring3-mvc-maven-xml-hello-world-1.0-SNAPSHOT/api/hello/raju/admin
	@RequestMapping(value = "/hello/{name}/{password}", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView multiHTTPMethods(@PathVariable("name") String name , 
										 @PathVariable("password") String password) {
		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name + ": " + password);
		return model;

	}
	
	@RequestMapping(value="/headerWithSingleValue", headers="name=raju")
	@ResponseBody
	public String headerWithSingleValue(){
		return "headerWithSingleValue";
	}
		
	@RequestMapping(value="/headerWithMuilpeValue", headers={"name=raju", "id=1"})
	@ResponseBody
	public String headerWithMuilpeValue(){
		return "headerWithMuilpeValue";
	}

	@RequestMapping(value="/produceandconsume", produces={"application/json","application/xml"}, consumes="text/html")
	@ResponseBody
	public String produce(){
		return "produceandconsume";
	}

}