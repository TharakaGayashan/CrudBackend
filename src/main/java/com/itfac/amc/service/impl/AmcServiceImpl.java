package com.itfac.amc.service.impl;

import java.time.Year;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.amc.entity.AmcMaster;
import com.itfac.amc.repository.AmcMasterRepository;
import com.itfac.amc.service.AmcService;

@Service
public class AmcServiceImpl implements AmcService {

	@Autowired
	AmcMasterRepository amcMasterRepository;

	@Override
	@Transactional
	public AmcMaster addNewAmc(HttpServletRequest httpServletRequest ,AmcMaster amc) {
		String ipAddress = httpServletRequest.getRemoteAddr();
		String currentYear = String.valueOf(Year.now().getValue());
		String receivedLastNo = amcMasterRepository.getAmcLastNo(currentYear);
		int lastNo = 0;
		if(receivedLastNo != null) {
			lastNo = (Integer.parseInt(receivedLastNo)) + 1;
		}
		else {
			lastNo += 1; 
		}
		String amcNo = currentYear + lastNo;
		String amcSerialNo = amcNo + 1;
		amc.setAmcNo(amcNo);
		amc.setSavedIp(ipAddress);
		amc.getAmcSerials().get(0).setAmcSerialNo(amcSerialNo);
		amcMasterRepository.setAmcNo(currentYear, lastNo);
		amcMasterRepository.setAmcSerialNo(amcNo);
		return amcMasterRepository.save(amc);
	}

}
