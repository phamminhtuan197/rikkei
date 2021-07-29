package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Position;
import com.rikkei.entity.PositionName;

public interface IPositionService {
	public List<Position> getAllPositions();

	public Position getPositionByID(short positionID);

	public Position getPositionByName(PositionName positionName);

	public boolean isPositionExistsByID(short positionID);

	public boolean isPositionExistsByName(PositionName positionName);

	public void deletePosition(short positionID);
}
