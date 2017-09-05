package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student_Province;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentSchoolSetServlet
 */
@WebServlet("/StudentSchoolSet.sdo")
public class StudentSchoolSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSchoolSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 绑定学校-学校加载
		try{
			//初始化
			student_service stus=new student_service();
			
			//查询省份信息
			List<Student_Province> ls=stus.queryProvinceAll();
			
			//传值
			request.setAttribute("prolist", ls);
			request.getRequestDispatcher("Back/student-school.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
