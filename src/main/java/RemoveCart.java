

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
 * Servlet implementation class RemoveCart
 */
@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCart() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbConnection = null;
		String[] records = request.getParameterValues("record");
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				for (int i = 0; i < records.length; i++) {
					PreparedStatement st = dbConnection.prepareStatement("DELETE FROM order_records WHERE title=?");
					st.setString(1, records[i]);
					st.executeUpdate();
				} 	
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher("remove-cart.jsp");
		rd.forward(request, response);
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}
	}

}
