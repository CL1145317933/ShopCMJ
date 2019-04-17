package com.sunshine.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sunshine.pojo.Category;
import com.sunshine.service.AdminCategoryService;
import com.sunshine.service.impl.AdminCategoryServiceImpl;

public class AdminCategoryServlet extends BaseServlet{
	private AdminCategoryService service=new AdminCategoryServiceImpl();
	/*
	 * 后台商品分类
	 */
	public void adminCategoryList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		List<Category> list = service.list();
		Gson gson=new Gson();
		String json = gson.toJson(list);
		resp.getWriter().write(json);
	}

}
