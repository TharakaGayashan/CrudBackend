package com.itfac.amc.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itfac.amc.entity.AmcMaster;
import com.itfac.amc.entity.AmcSerial;
import com.itfac.amc.repository.AmcMasterRepository;
import com.itfac.amc.repository.AmcSerialRepository;
import com.itfac.amc.service.AmcSerialService;

@Service
public class AmcSerialServiceImpl implements AmcSerialService{
	
	@Autowired
	AmcSerialRepository amcSerialRepository;
	
	@Autowired
	AmcMasterRepository amcMasterRepository;

	@Override
	@Transactional
	public AmcSerial addAmcSerial(AmcSerial amcSerial, String amcNo) {
		int lastSerialNo = amcSerialRepository.getAmcLastSerialNo(amcNo) + 1;
		String amcSerialNo = amcNo + lastSerialNo;
		amcSerial.setAmcSerialNo(amcSerialNo);
		
		AmcMaster amcMaster = amcMasterRepository.findById(amcNo).get();
		BigDecimal totalValueLkrSerial = amcSerial.getMtcAmtPerAnnumLkr();
		BigDecimal totalValueLkrMaster = amcMaster.getTotalValueLkr();
		if(!(totalValueLkrMaster.equals(totalValueLkrSerial))) {
			amcMaster.setTotalValueLkr(totalValueLkrSerial);
			amcMaster.setTotalValue(amcSerial.getMtcAmtPerAnnum());
			amcMasterRepository.save(amcMaster);
		}
		
		amcSerialRepository.setAmcSerialNo(amcNo, lastSerialNo);
		amcSerialRepository.save(amcSerial);
		return amcSerial;
	}

}
