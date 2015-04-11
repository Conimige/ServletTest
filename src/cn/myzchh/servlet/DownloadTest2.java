package cn.myzchh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTest2 extends HttpServlet {
//����Դ�ļ���ȡ�ķ�ʽ�����ļ��������ļ���
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�õ�Ҫ���ص��ļ�
		ServletContext sc=getServletContext();		
		String path=sc.getRealPath("/�����ļ������ļ�.jpg");		//��ȡ�ļ���ʵ·�����ԡ�/����ͷ����ǰӦ��
		//��ȡ�ļ���
		String filenameString=path.substring(path.lastIndexOf("\\")+1);
		System.out.println("��ȡ�ļ�·����ֵ�ǣ�"+path);
		
		//����������
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filenameString,"UTF-8"));//�����ļ����˴�Ҫ����URL����
		response.setHeader("Content-Type", "application/octet-stream");//֪ͨ�ͻ�����������
		InputStream in=new FileInputStream(path);
		
		//���������
		OutputStream out=response.getOutputStream();
		int len=-1;
		byte b[] =new byte[1024];
		while((len=in.read(b))!=-1){
			out.write(b, 0, len);
		}
		in.close();
		out.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
