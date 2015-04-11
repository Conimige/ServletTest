package cn.myzchh.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdentifyingCode extends HttpServlet {
//�����֤��ͼƬ
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//��д����
		response.setHeader("Expires", "0");
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Cache-Control", "no-store");  
		response.addHeader("Cache-Control", "must-revalidate");
		response.setHeader("Pragma", "no-cache");
	//��ʼ����С
		int width=120;
		int height=25;
				
	//����һ���ڴ�ͼ��BufferedImage
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//�������
	//�õ����ڸ�ͼƬ�Ļ���Graphics
		Graphics g=image.getGraphics();
	//���߿�
		g.setColor(Color.BLUE);//������ɫ
		g.drawRect(0, 0, width, height);
		
	//��䱳��ɫ
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width-2, height-2);
	//��������
		g.setColor(Color.GREEN);
		Random r=new Random();
		for(int i=0;i<10;i++){
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
			
		}
	//�������
		g.setColor(Color.RED);
		g.setFont(new Font("΢���ź�",Font.BOLD|Font.ITALIC,20));
		int x=23;
		for(int i=0;i<4;i++){
			g.drawString(r.nextInt(10)+"", x, 20);
			x+=20;
		}
	//����������ImageIO
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
