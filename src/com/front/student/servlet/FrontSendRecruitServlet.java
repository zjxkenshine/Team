package com.front.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Recruit;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class FrontSendRecruitServlet
 */
@WebServlet("/FrontSendRecruit.so")
public class FrontSendRecruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontSendRecruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 投递简历
		try{
			//初始化
			student_service stus=new student_service();
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			
			//取值
			Student stu=(Student)request.getSession().getAttribute("student");
			String id=request.getParameter("id");
			stu.setResumeTime(now);
			
			
			//预处理
		//	System.out.println(idString);
			Recruit rec=stus.queryRecruit(id);
			boolean m=stus.checkSendResume(Integer.parseInt(id),stu.getID());
			if(m){
				stus.addResume(rec,stu);
			}
			
			//跳转
			response.sendRedirect("FrontRecruitDetailSet.so?ID="+id);

		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
