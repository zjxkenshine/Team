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
 * Servlet implementation class StudentUpdateItemAddressServlet
 */
@WebServlet("/StudentUpdateItemAddress.sdo")
public class StudentUpdateItemAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateItemAddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 地址更新
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			int itemId=(int) request.getSession().getAttribute("itemId");
			String School=request.getParameter("School");
			String Address=request.getParameter("map");
			System.out.println(Address);
		
			//存值进Iteml类
			Item ite =new Item();
			ite.setID(itemId);
			ite.setSchool(School);
			ite.setAddresss(Address);
			
			
			//执行更新
			stus.updateItemAddress(ite);

			//跳转
			request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
