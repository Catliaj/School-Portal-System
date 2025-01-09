package SP_Backend;
import java.sql.*;

import javax.swing.JOptionPane;

import DB_Connection.DB_SPConnection;
import SP_GUI.Login;
import SP_GUI.Student_Dashboard;
public class LoginBackend 
{
	private String UserName,Password;
	DB_SPConnection spconnection = new DB_SPConnection();
	Connection connection;
	private boolean loginSuccess = false;
	public LoginBackend (String UserName, String Password)
	{
		
		setUserName(UserName);
		setPassword(Password);
		try
		{
			connection = spconnection.getConnection();
			String Query = ("SELECT * FROM STUDENTACCOUNT WHERE USERNAME = ? AND PASSWORDS =?");
			PreparedStatement ps = connection.prepareStatement(Query);
			ps.setString(1, getUserName());
			ps.setString(2, getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				loginSuccess = true;
				JOptionPane.showMessageDialog(null, "Login Successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			}
			
	
		    connection.close();
		}
		catch(Exception ex) 
		{ 
			ex.printStackTrace(); 
			JOptionPane.showMessageDialog( null,"Error: " + ex.getMessage());
		}
		
	}
	
	public boolean  loginSuccess()
	{
		return loginSuccess;
	}
	

	public String getUserName() 
	{
		return UserName;
	}

	public void setUserName(String userName) 
	{
		UserName = userName;
	}

	public String getPassword() 
	{
		return Password;
	}

	public void setPassword(String password) 
	{
		Password = password;
	}
}
