package com.back.all.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.School;
import com.back.service.admin_service;

/**
 * Servlet implementation class StudentSchoolManageSetServlet
 */
@WebServlet("/SchoolManageSet.do")
public class SchoolManageSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolManageSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取学校校正信息
		try{
			//初始化
			admin_service adms=new admin_service();
			
			//取值
			List<School> lsch= adms.queryallschoolupdate();
			
			//传值
			request.setAttribute("lsch", lsch);
			
			//跳转
			request.getRequestDispatcher("Back/admin_schoolmessage.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
