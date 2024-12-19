package com.ecommerce.service;

import java.util.List;

 
import com.ecommerce.Dto.WatchListDto;

public interface WatchListService {

	WatchListDto createWatchList(int userId, int productId);

	void deleteWatchList(int watchListId);

	List<WatchListDto> getWatchListByUser(int userId);

}
