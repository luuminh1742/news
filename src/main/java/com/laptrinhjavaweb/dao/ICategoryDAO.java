package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findById(Long id);
	Long save(CategoryModel categoryModel);
	void update(CategoryModel updateCategory);
	void delete(Long id);
}
