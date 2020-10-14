package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewsService {
	List<NewsModel> findAll(Pageble pageble);
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel findById(Long id);
	NewsModel save(NewsModel newsModel);
	NewsModel update(NewsModel updateNews);
	void delete(Long[] ids);
	int getTotalItem();
}
