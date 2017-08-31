package com.back.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentUploadResumeServlet
 */
@WebServlet("/StudentUploadResume.sdo")
public class StudentUploadResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUploadResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 图片上传处理
		try{
			//初始化
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			student_service stus=new student_service();
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String url=request.getParameter("Resume");
			
			//更新数据库
			stus.uploadResume(url, now,String.valueOf(stu.getID()));
			
			//跳转
			request.getRequestDispatcher("Back/student-uploadSuccess.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
		
	}

}
