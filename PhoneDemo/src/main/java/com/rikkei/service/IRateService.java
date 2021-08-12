package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Rate;

public interface IRateService {
	List<Rate> getAllRates();
	
	Rate getRateByID(long id);
	
	List<Rate> getByProduct(long id);
	
	double getAvgProduct(long id);
	
	void createRate(Rate rate);
	
	void deleteRate(long id);
}	
