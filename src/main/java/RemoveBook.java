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
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class RemoveBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		String[] books = request.getParameterValues("book");
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				for (int i = 0; i < books.length; i++) {
					PreparedStatement st = dbConnection.prepareStatement("DELETE FROM books WHERE id=" + books[i]);
					st.executeUpdate();
				} 	
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher("remove-book.jsp");
		rd.forward(request, response);
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}
	}

}
