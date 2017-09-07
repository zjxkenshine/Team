package com.back.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentRealMessageCheckServlet
 */
@WebServlet("/StudentRealMessageCheck.sdo")
public class StudentRealMessageCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRealMessageCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//学生真实姓名验证
		try{
			//初始化
			student_service stus=new student_service();
			HttpSession session = request.getSession(); //获取session
			session.setMaxInactiveInterval(30*60); //设置session时间
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String RealName=request.getParameter("RealName");
			String EducationBgd=request.getParameter("EducationBgd");
			String id=String.valueOf(stu.getID());
			String IdPic=request.getParameter("IdPic");
			String Picture=request.getParameter("Picture");
		//	System.out.println(IdPic+","+Picture+","+id);
			
			
			//执行更新
			stus.updateSelfMessageCheck(RealName, EducationBgd, IdPic, Picture, id);
			Student stu1=stus.queryOneStudent(id);
			
			//传值跳转
			session.setAttribute("student", stu1); //存值进session
			request.getRequestDispatcher("Back/student-realMessageCheck.jsp").forward(request, response);	
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
