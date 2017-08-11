package com.back.student.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentReLoginServlet
 */
@WebServlet("/StudentReLogin.sdo")
public class StudentReLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentReLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 重新登录
		try{
			//初始化
			HttpSession session = request.getSession(); //获取session
			Date nowTime =new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = sf.format(nowTime);
			student_service stuse=new student_service();
			
			//取值
			Student stu1=(Student)request.getSession().getAttribute("student"); //获取student信息
			//System.out.println(stuid);
			Student stu=stuse.queryOneStudent(String.valueOf(stu1.getID()));
			//System.out.println(stu);
			
			//更新登陆次数
			int num = stu.getLoginNum()+1;
			
			//更新学生信息
			stuse.updateStudentLoginMessage(now,num,String.valueOf(stu1.getID()));
			
			//传值
			session.setMaxInactiveInterval(30*60); //设置session时间
			session.setAttribute("student", stu); //存值进
			response.sendRedirect("StudentLoginTransform.sdo");  //跳转
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
