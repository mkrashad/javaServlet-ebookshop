import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		Cookie ck = new Cookie("user", user);
		response.addCookie(ck);
		
		Connection dbConnection = null;
		int role = 0;				
		
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				PreparedStatement st = dbConnection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ? LIMIT 1");
				st.setString(1, user);
				st.setString(2, password);
				ResultSet rs = st.executeQuery();
				if(rs.next()) {
					try {
						role = rs.getInt("role");
						dbConnection.close();
					} catch (SQLException ex) {
						out.println(ex);
					}
					HttpSession session = request.getSession(false);
					session.setAttribute("user", user);
					session.setAttribute("role", role);
					response.sendRedirect("/ebookshop/books");
				}
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
			out.print("Sorry Login or Password Incorrect!");
		}
		
			
	    RequestDispatcher rd = request.getRequestDispatcher("login.html");
	    rd.include(request, response);
		
	}

}
