import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }
    public class Record {
    	private int id;
    	private String user;
		private String title;
		
		
		public Record(int id, String user, String title) {
			this.id = id;
			this.user = user;
			this.title = title;
		}
		
		public int getId() {
			return id;
		}
		public String getUser() {
			return user;
		}
		public String getTitle() {
			return title;
		}

	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbConnection = null;
		List<Record> records = new ArrayList<>();
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("user");
		String sqlStr = "SELECT * FROM order_records WHERE user_name=" + "'" + user + "'";
		
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
					Statement stmt = dbConnection.createStatement();
					ResultSet rs = stmt.executeQuery(sqlStr);
				     while(rs.next()) {
				    	 	Record record = new Record(rs.getInt("id"), rs.getString("user_name"), rs.getString("title"));
				    	 	records.add(record);
		        }
			}
		}catch(Exception ex) {
			 out.println("<p>Error: " + ex.getMessage() + "</p>");
			 ex.printStackTrace();
		}
	
		request.setAttribute("user", user);
		request.setAttribute("records", records);
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
		
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		doGet(request, response);
	}
}
