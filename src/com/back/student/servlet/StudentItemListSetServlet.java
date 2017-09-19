package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Item;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentItemListSetServlet
 */
@WebServlet("/StudentItemListSet.sdo")
public class StudentItemListSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentItemListSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询所有项目
		try{
			//初始化
			student_service stus=new student_service();
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//执行
			List<Item> lte=stus.queryAllItem(stu.getID());
			
			//传值
			request.setAttribute("itemList",lte);
			
			//跳转
			request.getRequestDispatcher("Back/student-itemList.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
