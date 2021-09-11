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
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
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

		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String genre = request.getParameter("genre");
		String img = request.getParameter("img");
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
			PreparedStatement st = dbConnection.prepareStatement("INSERT INTO books (title, author, price, description, genre, img) VALUES(?,?,?,?,?,?)");
			st.setString(1, title);
			st.setString(2, author);
			st.setString(3, price);
			st.setString(4, description);
			st.setString(5, genre);
			st.setString(6, img);
			st.executeUpdate();
				
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher("add-book.jsp");
		rd.forward(request, response);
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}

	}

}
