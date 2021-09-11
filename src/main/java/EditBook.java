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


/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public class Book {
		private int id;
		private String title;
		private String author;
		private float price;
		private String genre;
		private String description;
		private String img;
	
		public Book(int id, String title, String author, float price, String genre, String description, String img) {
			this.id = id;
			this.title = title;
			this.author = author;
			this.price = price;
			this.genre = genre;
			this.description = description;
			this.img = img;
		}
		
		public int getId() {
			return id;
		}
		public String getTitle() {
			return title;
		}
		
		public String getAuthor() {
			return author;
		}
		
		public float getPrice() {
			return price;
		}
		
		public String getGenre() {
			return genre;
		}
		
		public String getDescription() {
			return description;
		}
		
		public String getImg() {
			return img;
		}

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
		String title = request.getParameter("book");
		String sqlStr = "SELECT * FROM books WHERE title="+ "'" + title + "'";
		try {
			dbConnection = db.DBConnection.getDBConnection();
			if(dbConnection != null) {
				Statement st = dbConnection.createStatement();
				ResultSet rs = st.executeQuery(sqlStr);
			      List<Book> books = new ArrayList<>();
				  while(rs.next()) {
						Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getFloat("price"), rs.getString("genre"), rs.getString("description"), rs.getString("img"));
						books.add(book);
				  }
				  
				  request.setAttribute("books", books);
			}
		} catch(Exception ex) {
			out.println(ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher("edit-book.jsp");
	    rd.forward(request, response);
		try {
			dbConnection.close();
		} catch (SQLException ex) {
			out.println(ex);
		}
	}

}
