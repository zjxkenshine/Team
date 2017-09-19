package com.front.student.servlet;

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
 * Servlet implementation class FrontCollectFirmServlet
 */
@WebServlet("/FrontCollectFirm.so")
public class FrontCollectFirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCollectFirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 收藏公司
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
			boolean m=stus.checkCollectFirm(id,stu.getID());
			if(m){
				stus.addCollectFirm(id,stu.getID(),now);
			}
			
			//跳转
			response.sendRedirect("firm_F_informaiton_detail.so?ID="+id);

		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
