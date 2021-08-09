package com.rikkei.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportInventory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Serializable group;
	private Double sum;
	private Long count;
	public Serializable getGroup() {
		return group;
	}
	public void setGroup(Serializable group) {
		this.group = group;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public ReportInventory(Serializable group, Double sum, Long count) {
		super();
		this.group = group;
		this.sum = sum;
		this.count = count;
	}
	public ReportInventory() {
		super();
	}
	
	
}
