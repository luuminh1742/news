package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewsMapper());
	}

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		StringBuilder sql = new StringBuilder("insert into news  ");
		sql.append(" (title,base64,thumbnail,shortdescription,");
		sql.append("content,categoryid,createddate,createdby) ");
		sql.append(" values (?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(),newsModel.getTitle(),newsModel.getBase64(),
				newsModel.getThumbnail(),newsModel.getShortDescription(),
				newsModel.getContent(),newsModel.getCategoryId(),
				newsModel.getCreatedDate(),newsModel.getCreatedBy());
	}

	@Override
	public void update(NewsModel updateNews) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" base64 = ?, shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?,modifieddate = ?,modifiedby= ? WHERE id = ?");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(),updateNews.getBase64(), 
				updateNews.getShortDescription(),updateNews.getContent(), updateNews.getCategoryId(), 
				updateNews.getCreatedDate(), updateNews.getCreatedBy(),updateNews.getModifiedDate(),
				updateNews.getModifiedBy(), updateNews.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from news where id = ?";
		update(sql, id);
	}

	@Override
	public NewsModel findById(Long id) {
		String sql = "select * from news where id = ?";
		return findOne(sql, new NewsMapper(),id);
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from news";
		return count(sql);
	}

}
