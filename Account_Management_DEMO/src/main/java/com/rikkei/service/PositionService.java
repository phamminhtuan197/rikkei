package com.rikkei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rikkei.entity.Position;
import com.rikkei.entity.PositionName;
import com.rikkei.repository.IPositionRepository;

@Service
public class PositionService implements IPositionService {
	@Autowired
	private IPositionRepository positionRepository;

	@Override
	public List<Position> getAllPositions() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionByID(short positionID) {
		// TODO Auto-generated method stub
		return positionRepository.findById(positionID).get();
	}

	@Override
	public boolean isPositionExistsByID(short positionID) {
		// TODO Auto-generated method stub
		return positionRepository.existsById(positionID);
	}

	@Override
	public void deletePosition(short positionID) {
		// TODO Auto-generated method stub
		positionRepository.deleteById(positionID);
	}

	@Override
	public Position getPositionByName(PositionName positionName) {
		// TODO Auto-generated method stub
		return positionRepository.getByPositionName(positionName);
	}

	@Override
	public boolean isPositionExistsByName(PositionName positionName) {
		// TODO Auto-generated method stub
		return positionRepository.existsByPositionName(positionName);
	}

}
