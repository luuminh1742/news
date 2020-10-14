package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/quan-tri/the-loai" })
public class CategoryController extends HttpServlet{

	
	private static final long serialVersionUID = 8863195775975450179L;
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CategoryModel model = FormUtil.toModel(CategoryModel.class, req);
		String type = req.getParameter("type");
		String path = "/views/admin/category/edit.jsp";
		
		if(type != null && type.equals("them-the-loai")) {
			
		}else if(type != null && type.equals("chinh-sua")) {
			model = categoryService.findById(model.getId());
			req.setAttribute("model", model);
		}else {
			path = "/views/admin/category/list.jsp";
			model.setListResult(categoryService.findAll());
			req.setAttribute("model", model);
		}
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
