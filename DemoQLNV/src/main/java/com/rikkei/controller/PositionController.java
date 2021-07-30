package com.rikkei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.entity.Position;
import com.rikkei.entity.PositionName;
import com.rikkei.service.IPositionService;

//Giải thích giống class AccountController

@RestController
@RequestMapping(value = "api/v1/positions")
@CrossOrigin("*")
public class PositionController {
	@Autowired
	private IPositionService positionService;

	@GetMapping()
	public ResponseEntity<?> getAllPositions() {
		List<Position> listPositions = positionService.getAllPositions();
		return new ResponseEntity<List<Position>>(listPositions, HttpStatus.OK);
	}

	@GetMapping(value = "/positionID/{positionID}")
	public ResponseEntity<?> getPositionByID(@PathVariable(name = "positionID") short positionID) {
		return new ResponseEntity<Position>(positionService.getPositionByID(positionID), HttpStatus.OK);
	}

	@DeleteMapping(value = "/positionID/{positionID}")
	public ResponseEntity<?> deletePosition(@PathVariable(name = "positionID") short positionID) {
		positionService.deletePosition(positionID);
		return new ResponseEntity<String>("Delete success", HttpStatus.OK);
	}

	@GetMapping(value = "/positionName/{positionName}")
	public ResponseEntity<?> getPositionByName(@PathVariable(name = "positionName") PositionName positionName) {
		return new ResponseEntity<Position>(positionService.getPositionByName(positionName), HttpStatus.OK);
	}
}
