package com.front.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Recruit;
import com.back.model.Student;
import com.back.service.student_service;

/**
 * Servlet implementation class FrontRecruitDetailSetServlet
 */
@WebServlet("/FrontRecruitDetailSet.so")
public class FrontRecruitDetailSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontRecruitDetailSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 职位详情
		try{
			//初始化
			student_service stus=new student_service();
		
			
			//接值
			String id=request.getParameter("ID");
			Student stu=(Student)request.getSession().getAttribute("student");
			
			//查询
			Recruit rec=stus.queryRecruit(id);
			List<Recruit> lr= stus.queryRecruitByFirmName(rec.getFirmName());
			
			//判断是否已收藏
			boolean i=false;
			boolean a=false;
			if(stu!=null){
				i=stus.checkCollectRecruit(id,stu.getID());
				a=stus.checkSendResume(Integer.parseInt(id),stu.getID());
			}
			
			//传值
			request.setAttribute("recruit", rec);
			request.setAttribute("recruitlist", lr);
			request.setAttribute("checkrecruitcollect", i);
			request.setAttribute("checkresumesend", a);
			
			//跳转
			request.getRequestDispatcher("Front/recruit_introduce_detail.jsp").forward(request, response);
			
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
