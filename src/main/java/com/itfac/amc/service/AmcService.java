package com.itfac.amc.service;

import javax.servlet.http.HttpServletRequest;

import com.itfac.amc.entity.AmcMaster;

public interface AmcService {

	AmcMaster addNewAmc(HttpServletRequest httpServletRequest, AmcMaster amc);

}
