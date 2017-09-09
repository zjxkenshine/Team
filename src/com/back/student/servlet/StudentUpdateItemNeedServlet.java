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
 * Servlet implementation class StudentUpdateItemNeedServlet
 */
@WebServlet("/StudentUpdateItemNeed.sdo")
public class StudentUpdateItemNeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateItemNeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 更新人才需求
		try{
			//	System.out.println("更新项目信息");
				//初始化
				student_service stus=new student_service();
				
				//取值
				int itemId=(int) request.getSession().getAttribute("itemId");
				String NeedNumber=request.getParameter("NeedNumber");
				String NeedDescripe=request.getParameter("Discripe");
			
				//存值进Iteml类
				Item ite =new Item();
				ite.setID(itemId);
				ite.setNeedNumber(Integer.valueOf(NeedNumber));
				ite.setNeedDiscripe(NeedDescripe);
				
				//执行更新
				stus.updateItemNeed(ite);

				//跳转
				request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
				
			}catch(Exception e){
				request.setAttribute("message",e.getMessage());	
				request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
			}
	}

}
