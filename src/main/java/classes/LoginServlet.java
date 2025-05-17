package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String pw = request.getParameter("loginPw");

		String dbUrl = "jdbc:postgresql://localhost:5432/users";
		String dbUserName = "postgres";
		String dbPassword = "password";

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.postgresql.Driver");
			// DB接続
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

			// SQL（loginテーブルからIDとPW一致するレコードを探す）
			String sql = "SELECT * FROM users WHERE loginId = ? AND loginPw = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();

			ServletContext sc = this.getServletContext();

			if (rs.next()) {
				// ログイン成功
				response.sendRedirect("/timer.jsp");
			} else {
				// ログイン失敗
				request.setAttribute("error", "ログインIDまたはパスワードが間違えています。");
				RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			out.println("データベースエラー: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			out.println("ドライバが見つかりません: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// リソースを閉じる
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				out.println("クローズエラー: " + e.getMessage());
			}
		}
	}
}