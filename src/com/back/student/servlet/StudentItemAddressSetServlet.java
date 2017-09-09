package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentItemAddressSetServlet
 */
@WebServlet("/StudentItemAddressSet.sdo")
public class StudentItemAddressSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentItemAddressSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			int itemId=(int) request.getSession().getAttribute("itemId");
			
			//获取项目信息
			Item it=stus.queryItemById(String.valueOf(itemId));
			
			//传值
			request.setAttribute("Item", it);
			
			//跳转
			request.getRequestDispatcher("Back/student-itemAddress.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
