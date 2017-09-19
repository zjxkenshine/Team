package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.ItemCollect;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentCollectItemListSetServlet
 */
@WebServlet("/StudentCollectItemListSet.sdo")
public class StudentCollectItemListSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCollectItemListSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 收藏项目设置
		try{
			//初始化
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			
			//获取该学生收藏项目
			List<ItemCollect> lic=stus.queryAllItemCollect(stu.getID());
		//	System.out.println(lic);
			
			//传值
			request.setAttribute("itemList",lic);
			
			//跳转
			request.getRequestDispatcher("Back/student-itemCollect.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
