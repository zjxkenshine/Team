package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.service.admin_service;

/**
 * Servlet implementation class StopItemServlet
 */
@WebServlet("/StopItem.do")
public class StopItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StopItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 项目禁用
		try{
			//初始化
			admin_service adms=new admin_service();
			
			//接值
			String id= request.getParameter("id");
	 
			//禁用
			adms.stopItem(id);
			
			//跳转
			request.getRequestDispatcher("ItemListSet.do").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
