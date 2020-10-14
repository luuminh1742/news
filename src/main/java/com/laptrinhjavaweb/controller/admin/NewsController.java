package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/quan-tri/bai-viet" })
public class NewsController extends HttpServlet {

	private static final long serialVersionUID = -4420657226835614281L;

	@Inject
	private INewsService newsService;
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewsModel model = FormUtil.toModel(NewsModel.class, req);
		String path = "";
		if (model.getType().equals("them-bai-viet")) {
			path = "/views/admin/news/edit.jsp";
			req.setAttribute("categories", categoryService.findAll());
		} else if (model.getType().equals("chinh-sua")) {
			path = "/views/admin/news/edit.jsp";
			req.setAttribute("categories", categoryService.findAll());
			model = newsService.findById(model.getId());
			req.setAttribute("model", model);
		} else {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setListResult(newsService.findAll(pageble));
			model.setTotalItem(newsService.getTotalItem());
			model.setTotalPage((int)Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
			req.setAttribute("model", model);
			path = "/views/admin/news/list.jsp";
		}

		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

	
	
}
