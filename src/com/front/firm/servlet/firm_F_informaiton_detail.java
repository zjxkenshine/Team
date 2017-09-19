package com.front.firm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.back.model.Firm;
import com.back.model.Recruit;
import com.back.model.Student;
import com.back.service.firm_service;
import com.back.service.student_service;

/**
 * Servlet implementation class firm_F_informaiton_detail
 */
@WebServlet("/firm_F_informaiton_detail.so")
public class firm_F_informaiton_detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public firm_F_informaiton_detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID="0";
		if(request.getParameter("ID")!=null){
			ID=request.getParameter("ID");
		}
		//取值
		String FirmName=request.getParameter("FirmName");
		Student stu=(Student)request.getSession().getAttribute("student");
		
		firm_service fs=new firm_service();
		student_service stus=new student_service();
		try {
			
			Firm firm=fs.firm_F_information_detail(Integer.parseInt(ID),FirmName);	
			List<Recruit> list=fs.firm_F_recruit_list(firm.getFirmName());
			
			//判断是否收藏
			boolean i=false;
			if(stu!=null){
				i=stus.checkCollectFirm(String.valueOf(firm.getID()),stu.getID());
			}
			
			request.setAttribute("checkfirmcollect", i);
			request.setAttribute("list",list);
			request.setAttribute("firm",firm);
			request.getRequestDispatcher("Front/firm_introduce_detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg",e.getMessage());
			request.getRequestDispatcher("Front/error.jsp").forward(request, response);
		}
	}

}
