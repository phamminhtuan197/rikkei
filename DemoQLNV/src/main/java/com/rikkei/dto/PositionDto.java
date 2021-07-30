package com.rikkei.dto;

import com.rikkei.entity.PositionName;


//Class này dùng để chuyển đổi giữa dữ liệu lấy được từ DB sang dữ hiển thị đẩy lên Frontend.
public class PositionDto {
	private short positionID;
	private PositionName positionName;

	public short getPositionID() {
		return positionID;
	}

	public void setPositionID(short positionID) {
		this.positionID = positionID;
	}

	public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}

	public PositionDto(short positionID, PositionName positionName) {
		super();
		this.positionID = positionID;
		this.positionName = positionName;
	}

}
