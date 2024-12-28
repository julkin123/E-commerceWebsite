package com.ecommerce.service.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.Dto.ProductDto;
import com.ecommerce.Dto.WatchListDto;
import com.ecommerce.Exception.ProductNotFoundException;
import com.ecommerce.Exception.ResourceNotFoundException;
import com.ecommerce.Exception.UserNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.model.MyUser;
import com.ecommerce.model.WatchList;
import com.ecommerce.modelMapper.WatchListModelMapper;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.UserRepo;
import com.ecommerce.repo.WatchListRepo;
import com.ecommerce.service.WatchListService;

@Service
public class WatchListServiceImpl implements WatchListService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	WatchListRepo watchListRepo;
	@Autowired
	ProductRepo productRepo;

	@Override
	public WatchListDto createWatchList(int userId, int productId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user is not exisit with id:" + userId));
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("product is not exisit with id:" + productId));
		WatchList watchList = new WatchList(0, product, user);
		watchList.setProduct(product);
		watchList.setUser(user);
		watchListRepo.save(watchList);

		return WatchListModelMapper.entityToDto(watchList);
	}

	@Override
	public void deleteWatchList(int watchListId) {
		WatchList watchList = watchListRepo.findById(watchListId)
				.orElseThrow(() -> new ResourceNotFoundException("user is not exisit with id:" + watchListId));

		watchListRepo.delete(watchList);

	}

	@Override
	public List<WatchListDto> getWatchListByUser(int userId) {
		MyUser user = userRepo.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("user is not exisit with id:" + userId));
		List<WatchList> watchLists = watchListRepo.getWatchListByUser(user);
		List<WatchListDto> watchListDto = watchLists.stream()
				.map((watchList) -> WatchListModelMapper.entityToDto(watchList)).collect(Collectors.toList());
		return watchListDto;
	}

}
