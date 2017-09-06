package com.back.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Recruit;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentRecuritSetServlet
 */
@WebServlet("/StudentRecuritSet.sdo")
public class StudentRecuritSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRecuritSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 查询职位
		try{
			//初始化
			student_service stus =new student_service();
			//接值
		
			//执行
			List<Recruit> lr=stus.queryAllRecruit(); //获取所有职位信息
		//	System.out.println(lf);
			
			
			//传值
			request.setAttribute("recruitlist",lr);
			
			//跳转
			request.getRequestDispatcher("Back/student-recruit.jsp").forward(request, response);

			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
