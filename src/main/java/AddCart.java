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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart2
 */
@WebServlet("/AddCart2")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbConnection = null;
		
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("user");
		String[] booksTitle = request.getParameterValues("book");
		
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				for (int i = 0; i < booksTitle.length; i++) {
					PreparedStatement st = dbConnection.prepareStatement("INSERT INTO order_records (title, user_name) VALUES(?,?)");
					st.setString(1, booksTitle[i]);
					st.setString(2, user);
					st.executeUpdate();
				} 	
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher("add-cart.jsp");
	    rd.forward(request, response);
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}

	}

}
