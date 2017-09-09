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
 * Servlet implementation class StudentItemCheckServlet
 */
@WebServlet("/StudentItemCheck.sdo")
public class StudentItemCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentItemCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//项目审核
		try{
		
				//初始化
				student_service stus=new student_service();
				
				//取值
				int itemId=(int) request.getSession().getAttribute("itemId");
				String BusinessPlan=request.getParameter("BusinessPlan");
				String Descripe =request.getParameter("Descripe");
				String Intention=request.getParameter("MajorID_22");
			
				//存值进Iteml类
				Item ite =new Item();
				ite.setBusinessPlan(BusinessPlan);
				ite.setDescripe(Descripe);
				ite.setID(itemId);
				ite.setIntention(Intention);
				
				//执行更新
				stus.updateItemCheck(ite);

				//跳转
				request.getRequestDispatcher("Back/student-updateSuccess.jsp").forward(request, response);
				
			}catch(Exception e){
				request.setAttribute("message",e.getMessage());	
				request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
			}
	}

}
