/**
 * Copyright(c)2012 Beijing PeaceMap Co.,Ltd.
 * All right reserved. 
 */
package com.wittc.servlet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class ValidateCode
 */

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * 定义Log
	 */
	private static Logger log = LoggerFactory.getLogger(ImageServlet.class);
	
	/**
	 *  放到session中的key  
	 */
	public static final String VALIDATE_CODE = "validateCode";
	
	/**
	 * 初始化路径
	 */
	private static final String path = "/validatecode.properties";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("restriction")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("image/png");
		 //设置相应类型,告诉浏览器输出的内容为图片       
		 response.setHeader("Pragma", "No-cache");
		 //设置响应头信息，告诉浏览器不要缓存此内容       
		 response.setHeader("Cache-Control", "no-cache");
		 response.setDateHeader("Expire", 0);
		 try { 
			// 创建内存图象并获得其图形上下文
				BufferedImage image = new BufferedImage(60, 20, BufferedImage.TYPE_INT_RGB);
				Graphics g = image.getGraphics();

				// 产生随机的认证码并画图
				char[] rands = this.generateCheckCode();
				this.drawBackground(g);
				this.drawRands(g, rands);

				// 结束图像的绘制过程，完成图像
				g.dispose();

				// 将当前验证码存入到Session中
				//session.setAttribute("validateNum", new String(rands));

				// 将图像输出到客户端
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
				encoder.encode(image);
			
			request.getSession().setAttribute(VALIDATE_CODE , new String(rands));
			 } catch (Exception e) {
				 e.printStackTrace();        
			}
		 }
	
	/**
	 * 产生随机数。
	 * @return
	 */
	private char[] generateCheckCode()
	{
		// 定义验证码的字符表
		String chars = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
		char[] rands = new char[4];
		for (int i = 0; i < 4; i++)
		{
			int rand = (int) (Math.random() * 28);
			rands[i] = chars.charAt(rand);
		}
		return rands;
	}

	/**
	 * 画随机数。
	 * @param g
	 * @param rands
	 */
	private void drawRands(Graphics g, char[] rands)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.PLAIN | Font.BOLD, 18));
		// 在不同的高度上输出验证码的每个字符
		g.drawString("" + rands[0], 1, 17);
		g.drawString("" + rands[1], 16, 15);
		g.drawString("" + rands[2], 31, 18);
		g.drawString("" + rands[3], 46, 16);
		System.out.println(rands);
	}

	/**
	 * 画图片背景。
	 * @param g
	 */
	private void drawBackground(Graphics g)
	{
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, 60, 20);
		// 随机产生120个干扰点
		for (int i = 0; i < 120; i++)
		{
			int x = (int) (Math.random() * 60);
			int y = (int) (Math.random() * 20);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
	}
}
