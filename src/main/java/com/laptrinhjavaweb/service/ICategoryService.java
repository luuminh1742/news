package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
	CategoryModel findById(Long id);
	CategoryModel save(CategoryModel categoryModel);
	CategoryModel update(CategoryModel updateCategory);
	void delete(Long[] ids);
}
