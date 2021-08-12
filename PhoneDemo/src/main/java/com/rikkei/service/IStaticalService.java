package com.rikkei.service;

import java.util.List;

public interface IStaticalService {
	List<Object[]> getStatisticalMonthYear(int year);
	
	List<Object[]> getStatisticalYear();
	
	List<Object[]> getStatisticalMonth();
	
	List<Object[]> getStatisticalDate();
	
	List<Integer> getYears();
	
}
