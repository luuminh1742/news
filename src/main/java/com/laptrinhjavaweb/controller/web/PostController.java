package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;

@WebServlet(urlPatterns = {"/bai-viet"})
public class PostController extends HttpServlet{

	private static final long serialVersionUID = 1944262768568431200L;
	@Inject
	private INewsService newsService;
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setListResult(categoryService.findAll());
		req.setAttribute("category", categoryModel);
		
		
		String newsId = req.getParameter("id");
		NewsModel news = newsService.findById(Long.parseLong(newsId));
		req.setAttribute("news", news);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/post.jsp");
		rd.forward(req, resp);
	}
}
