package cn.myzchh.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String filepath=getServletContext().getRealPath("/1.jpg");
			//֪ͨ�ͻ��������ط�ʽ��
			response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
			response.setHeader("Content-Type", "application/octet-stream");//֪ͨ�ͻ�����������
			InputStream in=new FileInputStream(filepath);
			OutputStream out= response.getOutputStream();
			int len=-1;
			byte b[] =new byte[1024];
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
			}
			in.close();
			out.close();
			
			//�����Ǿ�����룺
			/*
			//�õ�Ҫ���ص��ļ�
			ServletContext sc=getServletContext();		
			String path=sc.getRealPath("/1.jpg");		//��ȡ�ļ���ʵ·�����ԡ�/����ͷ����ǰӦ��
			System.out.println("��ȡ�ļ�·����ֵ�ǣ�"+path);
			
			//����������
			response.setHeader("Content-Disposition", "attachment;filename=1.jpg");
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
			*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
