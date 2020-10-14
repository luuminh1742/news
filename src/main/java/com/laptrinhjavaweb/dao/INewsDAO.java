package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewsDAO extends GenericDAO<NewsModel>{
	List<NewsModel> findAll(Pageble pageble);
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel findById(Long id);
	Long save(NewsModel newsModel);
	void update(NewsModel updateNews);
	void delete(Long id);
	int getTotalItem();	
}
