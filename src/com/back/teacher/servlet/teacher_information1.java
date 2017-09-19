package com.back.teacher.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_information1
 */
@WebServlet("/teacher_information1.do")
public class teacher_information1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_information1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String TeacherName=(String) request.getSession().getAttribute("TeacherName");
	    System.out.println(TeacherName+"***********+++");
		teacher_service ts=new teacher_service();
		try {
			Teacher teacher=ts.teacher_information(TeacherName);
			
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("Back/T_teacher_information_update.jsp").forward(request, response);
			System.out.println("成功跳转！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			try {
				throw new Exception(e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        request.getRequestDispatcher("Back/404.jsp").forward(request, response);
		}
		
	}

}
