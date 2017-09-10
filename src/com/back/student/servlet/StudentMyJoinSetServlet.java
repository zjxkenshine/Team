package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentMyJoinSetServlet
 */
@WebServlet("/StudentMyJoinSet.sdo")
public class StudentMyJoinSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMyJoinSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 我加入的项目初始化
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			
			//执行
			int itid =stus.queryJoinItemId(stu.getID());
			Item ite=new Item();
			if(itid!=0){
			ite=stus.queryItemByItemId(itid);
			}
			
			//传值
			request.setAttribute("item",ite);
			
			//跳转
			request.getRequestDispatcher("Back/student-myJoinItem.jsp").forward(request, response);
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
