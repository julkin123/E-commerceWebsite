package com.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Dto.WatchListDto;

import com.ecommerce.service.WatchListService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class WachListController {
	@Autowired
	WatchListService watchListService;

	@PostMapping("/user/{userId}/product/{productId}/watchList")
	public ResponseEntity<WatchListDto> createWatchList(@PathVariable int userId, @PathVariable int productId) {

		return new ResponseEntity<WatchListDto>(watchListService.createWatchList(userId, productId), HttpStatus.OK);
	}

	@GetMapping("/user/{userId}/watchList")
	public ResponseEntity<List<WatchListDto>> getWatchListByUser(@PathVariable int userId) {
		return new ResponseEntity<List<WatchListDto>>(watchListService.getWatchListByUser(userId), HttpStatus.OK);
	}

	@DeleteMapping("/user/watchList/{watchListId}")
	public ResponseEntity<String> deleteWatchList(@PathVariable int watchListId) {
		watchListService.deleteWatchList(watchListId);
		return new ResponseEntity<String>("Item deleted", HttpStatus.OK);
	}

}
