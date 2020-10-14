package com.laptrinhjavaweb.api.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5786117499709276346L;
	
	
	@Inject
	private ICategoryService categoryService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryModel = categoryService.save(categoryModel);
		mapper.writeValue(resp.getOutputStream(), categoryModel);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel updateCategory = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		updateCategory = categoryService.update(updateCategory);
		mapper.writeValue(resp.getOutputStream(), updateCategory);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryModel categoryModel = HttpUtil.of(req.getReader()).toModel(CategoryModel.class);
		categoryService.delete(categoryModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
