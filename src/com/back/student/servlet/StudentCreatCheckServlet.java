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
 * Servlet implementation class StudentCreatCheckServlet
 */
@WebServlet("/StudentCreatCheck.sdo")
public class StudentCreatCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCreatCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创业认证
		try{
			//初始化
			student_service stus=new student_service();
			HttpSession session = request.getSession(); //获取session
			session.setMaxInactiveInterval(30*60); //设置session时间
			
			//取值
			Student stu=(Student) request.getSession().getAttribute("student");
			String ID_Card=request.getParameter("ID_Card");
			String id=String.valueOf(stu.getID());
			String IdPic=request.getParameter("IdPic");
			String CreaPic=request.getParameter("CreaPic");
		//	System.out.println(IdPic+","+Picture+","+id);
			
			
			//执行更新
			stus.updatecreaCheck(ID_Card, IdPic, CreaPic, id);
			Student stu1=stus.queryOneStudent(id);
			
			//传值跳转
			session.setAttribute("student", stu1); //存值进session
			request.getRequestDispatcher("Back/student-creatCheck.jsp").forward(request, response);	
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
		}
	}

}
