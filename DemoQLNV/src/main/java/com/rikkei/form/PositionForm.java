package com.rikkei.form;

public class PositionForm {
	private short positionName;

	public short getPositionName() {
		return positionName;
	}

	public void setPositionName(short positionName) {
		this.positionName = positionName;
	}

	public PositionForm(short positionName) {
		super();
		this.positionName = positionName;
	}

}
