package com.back.all.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.admin_service;

/**
 * Servlet implementation class PassSchoolMessageServlet
 */
@WebServlet("/PassSchoolMessage.do")
public class PassSchoolMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassSchoolMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 通过校正
		try{
			//初始化
			admin_service adms=new admin_service();
			
			//取值
			String id=request.getParameter("id");
			
			//执行
			adms.passschoolupdate(id);
	
			
			//跳转
			request.getRequestDispatcher("SchoolManageSet.do").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
	}

}
