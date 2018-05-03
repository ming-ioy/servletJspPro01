package com.ming.servlet;

//导入必需的 java 库
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayHeader")

// 扩展 HttpServlet 类
public class DisplayHeader extends HttpServlet {

	// 处理 GET 方法请求的方法
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "HTTP Header 请求实例 - 菜鸟教程实例";
		String docType = "<!DOCTYPE html> \n";
		out.println(docType + "<html>\n" + "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n"
				+ "<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<tr bgcolor=\"#949494\">\n"
				+ "<th>Header 名称</th><th>Header 值</th>\n" + "</tr>\n");
        //获取头信息
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String paramName = (String) headerNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue = request.getHeader(paramName);
			out.println("<td> " + paramValue + "</td></tr>\n");
		}
		out.print("</table>\n");
		//获取cookies信息
		out.println("<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<tr bgcolor=\"#949494\">\n"
				+ "<th>cookie名称</th><th>cookie值</th>\n" + "</tr>\n");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.print("<tr><td>" + cookie.getName() + "</td>\n");
				out.println("<td> " + cookie.getValue() + "</td></tr>\n");
			}
		}
		out.print("</table>\n");
		//获取cookies信息
		out.println("<table width=\"100%\" border=\"1\" align=\"center\">\n" + "<tr bgcolor=\"#949494\">\n"
				+ "<th>Local名称</th><th>Local值</th>\n" + "</tr>\n");
		Locale locale = request.getLocale();
		out.print("<tr><td>" + locale.getLanguage() + "</td>\n");
		out.print("</table>\n");
		out.println("</table>\n</body></html>");
	}

	// 处理 POST 方法请求的方法
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}