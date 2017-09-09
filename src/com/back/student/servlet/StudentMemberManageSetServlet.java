package com.back.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.StuApply;
import com.back.service.student_service;

/**
 * Servlet implementation class StudentMemberManageSetServlet
 */
@WebServlet("/StudentMemberManageSet.sdo")
public class StudentMemberManageSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMemberManageSetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 成员列表
				try{
					//初始化
					student_service stus=new student_service();
					
					//取值
					int itemId=(int) request.getSession().getAttribute("itemId");
					
					//判断传值
					List<StuApply> lta=new ArrayList<StuApply>();
					if(itemId!=0){
						lta=stus.queryMember(itemId);
					}
					
					//传值
					request.setAttribute("appList", lta);
					
					//跳转
					request.getRequestDispatcher("Back/student-memberManage.jsp").forward(request, response);
					
				}catch(Exception e){
					request.setAttribute("message",e.getMessage());	
					request.getRequestDispatcher("Back/student-error.jsp").forward(request, response);
				}
	}

}
