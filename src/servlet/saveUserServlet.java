package servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class saveUserServlet extends HttpServlet {
	public saveUserServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		//String st ="/^\w+$/";
		Pattern pattern = Pattern.compile("^\\w+$");
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if (pattern.matcher(password).find()& username.equals("admin")) {
			try {
				System.out.println("mima");
				message = "设置成功";
				XmlService.addUser("admin",password,"001");
				request.setAttribute("message", message);
				request.getRequestDispatcher("/saveUser.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
