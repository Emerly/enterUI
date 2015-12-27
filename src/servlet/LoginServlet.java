package servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	//public LoginServlet() {
	//}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String result = "";
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		System.out.println(password+username);
		String message = "密码输入错误";
//		if (password == "") {
//			request.setAttribute("message", message);
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//		} else {
//
//		}
		if(XmlService.isUser(password)& username.equals("admin")){
			System.out.println("登录成功");
		}else if (password.equals("change")& username.equals("admin")) {
			System.out.println("YSE");
			try {
				result = "请重置密码";
				request.setAttribute("message", result);
				request.getRequestDispatcher("/saveUser.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			result = "密码或用户名输入错误";
			request.setAttribute("message",result);
		   request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
