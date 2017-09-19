package com.front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_info
 */
@WebServlet("/teacher_info.so")
public class teacher_info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		teacher_service ts = new teacher_service();
		try {
			List<Teacher> teacher = ts.teacher_info();
			request.setAttribute("list", teacher);
			request.getRequestDispatcher("Front/F_teacher_info.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());		
	        request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
