package cn.myzchh.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//д�����ݹ���
		ServletContext sc=getServletContext();
		sc.setAttribute("a", "abc");
		response.getOutputStream().write(("�Ѵ���;name=\"a\",obj=\"abc\"").getBytes());
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void init() throws ServletException {
		
	}

}
