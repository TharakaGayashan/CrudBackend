package com.itfac.amc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.amc.entity.AmcMaster;
import com.itfac.amc.service.AmcService;

@RestController()
@RequestMapping("amcMaster/")
public class AmcMasterController {

	@Autowired
	AmcService amcService;
	
	@RequestMapping("add")
	public AmcMaster addNewAmc(@RequestBody AmcMaster amcMaster, HttpServletRequest httpServletRequest) {
		return amcService.addNewAmc(httpServletRequest,amcMaster);
	}
	
	@GetMapping("test")
	public String test() {
		return "WELCOME! It works...";
	}
}
