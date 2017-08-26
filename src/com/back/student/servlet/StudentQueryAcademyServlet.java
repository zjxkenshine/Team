package com.back.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.service.student_service;
import com.google.gson.Gson;

/**
 * Servlet implementation class StudentQueryAcademyServlet
 */
@WebServlet("/StudentQueryAcademy.sdo")
public class StudentQueryAcademyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentQueryAcademyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 三级联动-查询学院
		try{
			//初始化
			System.out.println("执行2");
			student_service stus=new student_service();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out =response.getWriter();
			Gson gson = new Gson();
			
			//取值
			String school=request.getParameter("School");
			System.out.println(school);
			
			//查询学校
			List<Map<String,Object>> laca=stus.queryAcademy(school);
		//	System.out.println(laca);
			
			//传值
			String json =gson.toJson(laca);
    		out.write(json);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
