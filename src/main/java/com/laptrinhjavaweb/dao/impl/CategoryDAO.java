package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.mysql.cj.jdbc.result.UpdatableResultSet;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql,new CategoryMapper());
	}

	@Override
	public CategoryModel findById(Long id) {
		String sql = "select * from category where id = ?";
		return findOne(sql, new CategoryMapper(), id);
	}
	
	@Override
	public Long save(CategoryModel categoryModel) {
		StringBuilder sql = new StringBuilder("insert into category ");
		sql.append(" (name,code,createddate,createdby) ");
		sql.append(" values (?,?,?,?)");
		return insert(sql.toString(), categoryModel.getName(),
				categoryModel.getCode(),categoryModel.getCreatedDate(),
				categoryModel.getCreatedBy());
	}
	
	@Override
	public void update(CategoryModel updateCategory) {
		StringBuilder sql = new StringBuilder("update category set ");
		sql.append("name = ?, code = ?, modifieddate = ?");
		sql.append(", modifiedby = ? where id = ?");
		update(sql.toString(),updateCategory.getName(),
				updateCategory.getCode(),updateCategory.getModifiedDate(),
				updateCategory.getModifiedBy(),updateCategory.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from category where id = ?";
		update(sql,id);
	}

}
