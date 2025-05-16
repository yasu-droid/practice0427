package classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pw = request.getParameter("loginPw");
		

		ServletContext sc = this.getServletContext();
		if("yasuda".equals(id)&&"0712".equals(pw)) {
			response.sendRedirect("timer.jsp");

		}else {
			request.setAttribute("error", "ログインIDまたはパスワードが間違えています。");
			RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

		
		
	}

}
