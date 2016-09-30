package kr.co.c;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//방법1 : paraemter로 클라이언트 요청 구분
		//String command = request.getParameter("command");
		
		//방법2 : 요청 url로 클라이언트 요청 구분
		String ss = request.getRequestURI();
		int idx = ss.lastIndexOf("/");
		StringTokenizer st = new StringTokenizer(ss.substring(idx + 1), ".");
		ss = st.nextToken();
		String command = ss;
		
		commandInter inter = null;
		String prefix = "/view/";
		String surfix = ".jsp";
		String viewName = "";
		
		try {
			if(command.equals("sang")){
				inter = SangpumImpl.Instance();
				viewName = prefix + inter.showData(request, response) + surfix;
				request.getRequestDispatcher(viewName).forward(request, response);
				
			}else if(command.equals("jik")){
				inter = sawonImpl.Instance();
				viewName = prefix + inter.showData(request, response) + surfix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}else if(command.equals("sawon")){
				inter = sawonImpl.Instance();
				viewName = prefix + inter.showData(request, response) + surfix;
				request.getRequestDispatcher(viewName).forward(request, response);
			}else{
				viewName = "error.html";
				response.sendRedirect(viewName);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
