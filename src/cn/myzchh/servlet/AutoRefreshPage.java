package cn.myzchh.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoRefreshPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r=new Random();
		String s=r.nextInt()+"";
		response.setHeader("Refresh", "2");//���һ��ˢ��һ��
		//response.setHeader("Refresh", "3;URL=/WebTest/MyHtml.html");
		response.getOutputStream().write(("<p>����һ��������ֵĲ��ԣ�����Կ�����ҳԴ���룬ʲô��û�У�����ͨ��Servlet��ִ�еģ�ÿ��������һ���µ�������ֲ�ˢ�¡�</p>").getBytes());
		response.getOutputStream().write(s.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
