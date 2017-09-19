package com.front.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.PageBean;
import com.back.model.Recruit;
import com.back.service.student_service;

/**
 * Servlet implementation class FrontQueryRecruitServlet
 */
@WebServlet("/FrontQueryRecruit.so")
public class FrontQueryRecruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontQueryRecruitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 职位搜索
		try{
			//初始化
			student_service stus=new student_service();
			
			Recruit rec=new Recruit();
			String EducationBgd=null;
			String firm=null;
			String work=null;
			
			//接值
			if(request.getParameter("firm")!=null){
				 firm=request.getParameter("firm");
				rec.setFirmName(firm);
			}
			if(request.getParameter("work")!=null){
				 work=request.getParameter("work");
				rec.setJob(work);
			}
			if(request.getParameter("EducationBgd")!=null){
				EducationBgd=request.getParameter("EducationBgd");
				rec.setEducationBgd(EducationBgd);
			}
			
		//	System.out.println(rec);

			
			PageBean page=new PageBean();
			if(request.getParameter("nowPage")!=null){
				page.setNowPage(Integer.parseInt(request.getParameter("nowPage")));//得到当前第几页 
	    		System.out.println("nowpage==="+request.getParameter("nowPage"));
			}
    		page.setTotalcount(stus.getRecruitCount(rec));//得到用户 ——总数量
    		page.setTotalpage(stus.getRecruitCount(rec)%page.getPageSize()==0?stus.getRecruitCount(rec)/page.getPageSize():stus.getRecruitCount(rec)/page.getPageSize()+1);//总页数
			
			//执行
    		List<Recruit> lr=stus.queryRecruitList(rec, page);
			
			
			//传值
			request.setAttribute("recruitlist",lr);
			request.setAttribute("page",page);
			request.setAttribute("firm",firm);
			request.setAttribute("work",work);
			request.setAttribute("EducationBgd",EducationBgd);
			
			//跳转
			request.getRequestDispatcher("Front/recruit_introduce.jsp").forward(request, response);
			
		}catch(Exception e){
			request.setAttribute("message",e.getMessage());	
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
