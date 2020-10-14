package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		return newsDAO.findAll(pageble);
	}

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("MT");
		Long id = newsDAO.save(newsModel);
		return newsDAO.findById(id);
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDAO.findById(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("MT");
		newsDAO.update(updateNews);
		return newsDAO.findById(updateNews.getId());
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids) {
			newsDAO.delete(id);
		}
		
	}

	@Override
	public NewsModel findById(Long id) {
		return newsDAO.findById(id);
	}

	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}

}
