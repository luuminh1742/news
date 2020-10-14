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
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/the-loai" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	@Inject
	private ICategoryService categoryService;
	@Inject
	private INewsService newsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, req);
		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setListResult(categoryService.findAll());
		req.setAttribute("category", categoryModel);

		String categoryId = req.getParameter("categoryid");
		if (categoryId != null) {
			NewsModel newsModel = new NewsModel();
			Long cateId = Long.parseLong(categoryId);
			newsModel.setListResult(newsService.findByCategoryId(cateId));
			CategoryModel categoryModel2 = categoryService.findById(cateId);
			req.setAttribute("model", newsModel);
			req.setAttribute("categoryForName", categoryModel2);
			
		} else {
			//NewsModel model = FormUtil.toModel(NewsModel.class, req);
			model.setMaxPageItem(10);
			model.setSortBy("desc");
			model.setSortName("createddate");
			model.setTotalItem(newsService.getTotalItem());
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			/*
			 * Pageble pageble = new PageRequest(1, 10, new Sorter("createddate", "desc"));
			 */
			model.setListResult(newsService.findAll(pageble)); 
			model.setTotalPage((int)Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
			req.setAttribute("model",model);
			 
		}

		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
}
