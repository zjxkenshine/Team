package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentFirmListSetServlet
 */
@WebServlet("/StudentFirmListSet.sdo")
public class StudentFirmListSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFirmListSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 简历投递
		try{
			//初始化
			student_service stus =new student_service();
			//接值
			Student stu =(Student)request.getSession().getAttribute("student");
		
			//执行
			List<Firm> lf=stus.queryAllSchool(); //获取所有公司信息
		//	System.out.println(lf);
			
			
			//传值
			request.setAttribute("firmlist",lf);
			
			//跳转
			request.getRequestDispatcher("Back/student-firmList.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
