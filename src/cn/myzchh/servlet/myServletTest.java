package cn.myzchh.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myServletTest extends HttpServlet {
	private ServletConfig config;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		out.write("\n<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.write("\n<html>");
		out.write("\n<title>myServletTest</title>");
		out.write("\n<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
		out.write("\n<style>p{font-family: \"΢���ź� Light\";font-size: 14px;}</style>");
		out.write("\n<body>");
		out.write("\n<p>hello my friend,I'm ZhangChao,this is my first servlet project,now let's test this page load successfully in your webbrowser</p>");
		String value=config.getInitParameter("haha");
		out.write(("\n<p>����xml��config���ԣ� value="+value+"</p>"));
		out.write(("\n<p>�������ز��ԣ�<a href=\"DownloadTest\">�������</a></p>"));
		out.write(("\n<p>�Զ�ˢ�²��ԣ�<a href=\"AutoRefreshPage\">�������</a></p>"));
		out.write(("\n<p>�����л�����ԣ�<a href=\"NoCache\">�������</a></p>"));
		out.write(("\n<p>Servlet֮������ݹ���<a href=\"ServletContextTest\">����</a>    <a href=\"ServletContextTest2\">����</a></p>"));
		out.write(("\n<p>��ȡȫ�ֲ�����<a href=\"ReadApplocationPublicParameter\">�������</a></p>"));
		out.write(("\n<p>���������ļ������ز��ԣ�<a href=\"DownloadTest2\">�������</a></p>"));
		out.write(("\n<p>������ȡ��Դ�ļ����ԣ�<a href=\"ReadProperties\">�������</a></p>"));
		out.write(("\n<p>��½<a href=\"/ServletTest/login.html\">�������</a></p>"));
		out.write(("\n<p>�趨����ʱ��<a href=\"CacheTime\">�������</a></p>"));
		out.write(("\n<p>�����ض���<a href=\"RequestRedirection\">�������</a></p>"));
		
		out.write("\n</body>");
		out.write("\n</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void init(ServletConfig config) throws ServletException{
		this.config=config;
	}
}
