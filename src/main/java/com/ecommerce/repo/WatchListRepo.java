package com.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.MyUser;

import com.ecommerce.model.WatchList;

@Repository
public interface WatchListRepo extends JpaRepository<WatchList, Integer> {
	List<WatchList> getWatchListByUser(MyUser user);

}
