package com.laptrinhjavaweb.api.admin;

import java.io.IOException;
import java.util.Base64;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.utils.HttpUtil;
import com.laptrinhjavaweb.utils.UploadFileUtil;

@WebServlet(urlPatterns = { "/api-admin-news" })
public class NewsAPI extends HttpServlet {

	private static final long serialVersionUID = -1738930342832535647L;

	@Inject
	private INewsService newsService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		
		if(!newsModel.getBase64().equals("")) {
			byte[] decodeBase64 = Base64.getDecoder().decode(newsModel.getBase64().split(",")[1].getBytes());
			UploadFileUtil.writeOrUpdateFile(decodeBase64, "/thumbnail/"+newsModel.getThumbnail());
		}
		
		newsModel = newsService.save(newsModel);
		

		mapper.writeValue(resp.getOutputStream(), newsModel);
	}


	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel updateNews = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		updateNews = newsService.update(updateNews);
		if(!updateNews.getBase64().equals("")) {
			byte[] decodeBase64 = Base64.getDecoder().decode(updateNews.getBase64().split(",")[1].getBytes());
			UploadFileUtil.writeOrUpdateFile(decodeBase64, "/thumbnail/"+updateNews.getThumbnail());
		}
		
		
		mapper.writeValue(resp.getOutputStream(), updateNews);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);
		newsService.delete(newsModel.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}

}
