package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentConnectSchoolServlet
 */
@WebServlet("/StudentConnectSchool.sdo")
public class StudentConnectSchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentConnectSchoolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 绑定学校
		try{
			//初始化
			student_service stus=new student_service();
			
			//接值
			String province=request.getParameter("Province");
			String school=request.getParameter("School");
			String academy=request.getParameter("Academy");
			String major=request.getParameter("Major");
			Student stu=(Student)request.getSession().getAttribute("student");
			
			//更新
			stus.updateStudentSchool(province,school,academy,major,stu.getID());
			
			//传值跳转
			response.sendRedirect("StudentSelfMessageSet.sdo");
			
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
