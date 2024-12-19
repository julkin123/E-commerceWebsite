package com.ecommerce.modelMapper;

import com.ecommerce.Dto.WatchListDto;
import com.ecommerce.model.WatchList;

public class WatchListModelMapper {

	public static WatchList dtoToEntity(WatchListDto watchListDto) {

		return new WatchList(watchListDto.getId(), watchListDto.getProduct(), watchListDto.getUser());

	}

	public static WatchListDto entityToDto(WatchList watchList) {

		return new WatchListDto(watchList.getId(), watchList.getProduct(), watchList.getUser());

	}

}
