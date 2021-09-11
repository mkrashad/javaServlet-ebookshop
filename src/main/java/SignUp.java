import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("sign-up.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		

		int role = 0;
		Connection dbConnection = null;
		
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				PreparedStatement st = dbConnection.prepareStatement("INSERT INTO users (username, password, email, fullname, role) VALUES(?,?,?,?,?)");
				st.setString(1, username);
				st.setString(2, password);
				st.setString(3, email);
				st.setString(4, fullName);
				st.setInt(5, role);
				st.executeUpdate();
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.forward(request, response);
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}
	}

}


