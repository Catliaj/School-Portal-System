package DB_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB_SPConnection 
{
	private static Connection connection;
	private static DB_SPConnection db;
	public DB_SPConnection() 
	{
	    new JOptionPane();
	    
		connection = null;
		try
		{
		connection = DriverManager.getConnection
        (
            "jdbc:mysql://localhost:3306/studentportal", 
            "admin", 
            "admin"     
        );
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Connection Error"+ e.getMessage());
		}
		
	}
	
	public static DB_SPConnection getDbConnection()
	{
		if(db == null)
		{
			db = new DB_SPConnection();
		}
		return db;
	}
	
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentportal", 
                "admin", 
                "admin"
            );
        }
        return connection;
    }
	
}
