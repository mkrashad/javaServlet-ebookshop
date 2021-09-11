import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListiner
 *
 */
@WebListener
public class SessionListiner implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListiner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    System.out.println("-- HttpSessionListener sessionCreated invoked --");
   	 HttpSession session = se.getSession();
   	 System.out.println("session id: " + session.getId());
   	 session.setMaxInactiveInterval(60);//in seconds
    }

	/**


	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
      	 System.out.println("-- HttpSessionListener session Destroyed --");
    }
	
}
