package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.entity.Position;
import com.rikkei.entity.PositionName;

public interface IPositionRepository extends JpaRepository<Position, Short> {

	public Position getByPositionName(PositionName positionName);

	public boolean existsByPositionName(PositionName positionName);
}
