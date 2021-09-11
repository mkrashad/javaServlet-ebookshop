import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogHistoryFIlter
 */
public class LogHistoryFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
       	HttpServletRequest req = (HttpServletRequest) request;
       	
       	
       	HttpSession session = req.getSession(false);
		String user = (String) session.getAttribute("user");
		String ipAddress = request.getRemoteAddr();
		
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		
	
		LogCreateFilter logHistory = new LogCreateFilter();
		logHistory.create(user, ipAddress , currentTimestamp);
	

		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
		chain.doFilter(request, response);
		
	}
	
	public void destroy() {
		//
	}

}

