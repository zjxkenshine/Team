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
 * Servlet implementation class StudentDeleteRecruitCollectServlet
 */
@WebServlet("/StudentDeleteRecruitCollect.sdo")
public class StudentDeleteRecruitCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteRecruitCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 删除收藏表(职位)
			try{
				//初始化
				student_service stus=new student_service();
				
				//取值
				Student stu=(Student) request.getSession().getAttribute("student");
				String idString=request.getParameter("CollectID");
				
				
				//预处理
				System.out.println(idString);
				String [] lid=idString.split(",");
				
				//执行删除
				for(String a:lid){
					stus.deleteCollectRecruit(a, stu.getID());
				}
				
				//跳转
				request.getRequestDispatcher("Back/student-cancelSuccess.jsp").forward(request, response);
					
			}catch(Exception e){
				request.setAttribute("message",e.getMessage());	
				request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
			}
	}

}
