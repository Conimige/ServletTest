package cn.myzchh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��ȡ��Դ�ļ���ʽ
public class ReadProperties extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getOutputStream().write(("\n<p>ServletContext��������ȡ�κ��ļ���ֻ����Web�������ã���</p>").getBytes());
		//����ServletContext��ȡa1.properties��Դ�ļ�
			ServletContext sc=getServletContext();
			String path=sc.getRealPath("/WEB-INF/a1.properties");
			Properties props=new Properties();
			props.load(new FileInputStream(path));
			String value =props.getProperty("username");
			response.getOutputStream().write(("<p>��a1.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value+"</p>").getBytes());
			
		//����ServletContext��ȡa2.properties��Դ�ļ�
			ServletContext sc2=getServletContext();
			String path2=sc2.getRealPath("/WEB-INF/classes/a2.properties");
			Properties props2=new Properties();
			props2.load(new FileInputStream(path2));
			String value2 =props2.getProperty("username");
			response.getOutputStream().write(("\n<p>��a2.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value2+"</p>").getBytes());
		
		//����ServletContext��ȡa3.properties��Դ�ļ�
			ServletContext sc3=getServletContext();
			String path3=sc3.getRealPath("/WEB-INF/classes/cn/myzchh/properties/a3.properties");
			Properties props3=new Properties();
			props3.load(new FileInputStream(path3));
			String value3 =props3.getProperty("username");
			response.getOutputStream().write(("\n<p>��a3.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value3+"</p>").getBytes());

		response.getOutputStream().write(("\n<p>ResourceBundle���������ڷ�Web�����¡�����ֻ�ܶ�ȡ·���е�Prooerties�ļ�����</p>").getBytes());
		
		//����ResourceBundle��ȡa2.properties��Դ�ļ�
			ResourceBundle rb=ResourceBundle.getBundle("a2");		//����
			String value4 =rb.getString("username");
			response.getOutputStream().write(("\n<p>��a2.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value4+"</p>").getBytes());

		//����ResourceBundle��ȡa3.properties��Դ�ļ�
			ResourceBundle rb2=ResourceBundle.getBundle("cn.myzchh.properties.a3");		//����
			String value5 =rb2.getString("username");
			response.getOutputStream().write(("\n<p>��a3.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value5+"</p>").getBytes());
			
			response.getOutputStream().write(("\n<p>ResourceBundle�����޷���ȡa1��ֵ</p>").getBytes());

			response.getOutputStream().write(("\n<p>���ü�������ȡ�����ļ����������ڷ�Web�����¡����Ƕ�ȡ�κ�·���е��ļ�����</p>").getBytes());
		
		//���ü�������ȡ�����ļ�����
			ClassLoader c1=ReadProperties.class.getClassLoader();//�õ�ReadProperties�������
			//InputStream in= c1.getResourceAsStream("a2.properties");
			InputStream in= c1.getResourceAsStream("cn.myzchh.properties.a3.properties");//����a3
			Properties props6=new Properties();
			props6.load(in);
			String value6=props6.getProperty("username");
			response.getOutputStream().write(("\n<p>��a2.properties�ļ��ж�ȡ����\"username\"��ֵ�ǣ�"+value6+"</p>").getBytes());
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
