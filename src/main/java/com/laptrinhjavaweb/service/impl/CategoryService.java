package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.ConvertCodeUtil;

public class CategoryService implements ICategoryService{

	@Inject
	private ICategoryDAO categoryDAO;
	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}
	@Override
	public CategoryModel findById(Long id) {
		return categoryDAO.findById(id);
	}
	@Override
	public CategoryModel save(CategoryModel categoryModel) {
		categoryModel.setCode(ConvertCodeUtil.toCode(categoryModel.getName()));
		categoryModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		categoryModel.setCreatedBy("MT");
		Long id = categoryDAO.save(categoryModel);
		return categoryDAO.findById(id);
	}
	@Override
	public CategoryModel update(CategoryModel updateCategory) {
		CategoryModel oldNews = categoryDAO.findById(updateCategory.getId());
		updateCategory.setCreatedDate(oldNews.getCreatedDate());
		updateCategory.setCreatedBy(oldNews.getCreatedBy());
		updateCategory.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateCategory.setCode(ConvertCodeUtil.toCode(updateCategory.getName()));
		updateCategory.setModifiedBy("MT");
		categoryDAO.update(updateCategory);
		return categoryDAO.findById(updateCategory.getId());
	}
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids) {
			categoryDAO.delete(id);
		}
		
	}

}
