package com.front.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.PageBean;
import com.back.model.TeaMessage;
import com.back.model.Teacher;
import com.back.service.teacher_service;

/**
 * Servlet implementation class teacher_singleinfo
 */
@WebServlet("/teacher_singleinfo.so")
public class teacher_singleinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacher_singleinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int ID = Integer.parseInt(request.getParameter("ID"));
		teacher_service ts=new teacher_service();
		
		Teacher teacher;
		try {
			teacher = ts.queryoneteacher(ID);
			List<Teacher> ltea=ts.querytuijianteacher();
			

			PageBean page=new PageBean();
			page.setPageSize(4);
			if(request.getParameter("nowPage")!=null){
				page.setNowPage(Integer.parseInt(request.getParameter("nowPage")));//得到当前第几页 
	    		System.out.println("nowpage==="+request.getParameter("nowPage"));
			}
    		page.setTotalcount(ts.getTeaMessageCount(teacher.getID()));//得到用户 ——总数量
    		page.setTotalpage(ts.getTeaMessageCount(teacher.getID())%page.getPageSize()==0?ts.getTeaMessageCount(teacher.getID())/page.getPageSize():ts.getTeaMessageCount(teacher.getID())/page.getPageSize()+1);//总页数
			
    		
    		//查询留言
    		List<TeaMessage> ltm=ts.queryallleavecomment(teacher.getID());
    		
    		//查询留言回复
    		List<TeaMessage> lteam=ts.queryreplyleavecomment(teacher.getID());
    		
    		
    				
			request.setAttribute("tuijianlist", ltea);
			request.setAttribute("teacher", teacher);
			request.setAttribute("commentlist", ltm);
			request.setAttribute("replylist", lteam);
			request.setAttribute("page", page);
			request.getRequestDispatcher("Front/F_teacher_information.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 request.getRequestDispatcher("Front0/error.jsp").forward(request, response);
		}
		
	}

}
