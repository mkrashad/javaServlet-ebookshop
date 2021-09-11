import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import db.DBConnection;

public class LogCreateFilter extends DBConnection {
	
	public int create(String user, String ip, Timestamp currentTimestamp) {
		if(user == null || user.isEmpty() || ip == null || ip.isEmpty() || currentTimestamp == null) {
			return 0;
		}
		
		
		Connection dbConnection = getDBConnection();
		if(dbConnection == null) {
			return 0;
		}
		
		try {
			PreparedStatement st = dbConnection.prepareStatement("INSERT INTO login_history(user, ip, date) VALUES(?,?,?)");
			st.setString(1, user);
			st.setString(2, ip);
			st.setTimestamp(3, currentTimestamp);
			return st.executeUpdate();
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return 0;
	}
}
