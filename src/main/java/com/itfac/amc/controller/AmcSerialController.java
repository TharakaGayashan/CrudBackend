package com.itfac.amc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itfac.amc.entity.AmcSerial;
import com.itfac.amc.service.AmcSerialService;

@RestController()
@RequestMapping("amcSerial/")
public class AmcSerialController {
	
	@Autowired
	AmcSerialService amcSerialService;
	
	@RequestMapping("add/{amcNo}")
	public AmcSerial addNewAmcSerial(@RequestBody AmcSerial amcSerial, @PathVariable(value = "amcNo") String amcNo) {
		return amcSerialService.addAmcSerial(amcSerial, amcNo);
	}

}
