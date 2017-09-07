package com.back.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Recruit;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentSendResumeServlet
 */
@WebServlet("/StudentSendResume.sdo")
public class StudentSendResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSendResumeServlet() {
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
					student_service stus=new student_service();
					Date nowTime =new Date();
					SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String now = sf.format(nowTime);
					
					//取值
					Student stu=(Student)request.getSession().getAttribute("student");
					String idString=request.getParameter("CollectID");
					stu.setResumeTime(now);
					
					//预处理
					System.out.println(idString);
					String [] lid=idString.split(",");
					
					//添加数据库
					for(String a:lid){
					//	System.out.println(a);
						Recruit rec=stus.queryRecruit(a);
						boolean m=stus.checkSendResume(Integer.parseInt(a),stu.getID());
						if(m){
							stus.addResume(rec,stu);
						}
					}
				
					
					//跳转
					request.getRequestDispatcher("Back/student-sendSuccess.jsp").forward(request, response);
					
				}catch(Exception e){
					request.setAttribute("message",e.getMessage());	
					request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
				}
	}

}
