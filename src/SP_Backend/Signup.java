package SP_Backend;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


import DB_Connection.DB_SPConnection;

public class Signup 
{
	private String firstName,middleInitial,LastName,gender,contactNumber,email,homeAddress,dateOfbirth
	,relationToStudent, seniorHighName, dateGraduated, seniorHighAddress,honorOrAwards,
	programCourse, schoolarshipApplication, userName, Password;
	private File ID,TOR,Certificate;
	private int FinalAvarage;
	private static int StudentID;
	DB_SPConnection db_spconnection = new DB_SPConnection();
	Connection connection;
	
	
	public Signup(String firstName,String middleInitial,String LastName,String gender,String dateOfbirth,String contactNumber,String email,String homeAddress)
	{
		try
		{
			setFirstName(firstName);
			setMiddleInitial(middleInitial);
			setLastName(LastName);
			setGender(gender);
			setDateOfbirth(dateOfbirth);
			setContactNumber(contactNumber);
			setEmail(email);
			setHomeAddress(homeAddress);
			
			connection = db_spconnection.getConnection();
			String query = ("INSERT INTO STUDENTS_PERSONAL_DETAILS(FirstName, MiddleInitial, LastName, Gender, DateOfBirth,ContactNumber, Email, HomeAddress) VALUES (?,?,?,?,?,?,?,?)");
			PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, getFirstName());
			ps.setString(2, getMiddleInitial());
			ps.setString(3, getLastName());
			ps.setString(4, getGender());
			ps.setString(5, getDateOfbirth());
			ps.setString(6, getContactNumber());
			ps.setString(7, getEmail());
			ps.setString(8, getHomeAddress());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                setStudentID(rs.getInt(1)); // Store StudentID
            }
		}
		catch(Exception ex)
		{
			 ex.printStackTrace(); 
	         JOptionPane.showMessageDialog( null,"Error: " + ex.getMessage() );
		}
		
	}
	
	public Signup() {};
	
	public void parentOrGuardianInfo(String firstName,String middleInitial,String LastName, String RelationToStudent,String contactNumber,String homeAddress)
	{
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(LastName);
		setRelationToStudent(RelationToStudent);
		setContactNumber(contactNumber);
		setHomeAddress(homeAddress);
		try
		{
			connection = db_spconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO PARENTINFO(StudentID,FirstName, MiddleInitial, LastName, RelationshipStudent, ContactNumber, HomeAddress) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, getStudentID());
			ps.setString(2, getFirstName());
			ps.setString(3, getMiddleInitial());
			ps.setString(4, getLastName());
			ps.setString(5, getRelationToStudent());
			ps.setString(6, getContactNumber());
			ps.setString(7, getHomeAddress());
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(); 
	        JOptionPane.showMessageDialog( null,"Error: " + ex.getMessage() );
		}
	}
	
	public void AcademicBackground(String seniorHighName, String dateGraduated, String seniorHighAddress, int FinalAvarage, String honorOrAwards)
	{
		setSeniorHighName(seniorHighName);
		setDateGraduated(dateGraduated);
		setSeniorHighAddress(seniorHighAddress);
		setFinalAvarage(FinalAvarage);
		setHonorOrAwards(honorOrAwards);
		try
		{
			connection = db_spconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO ACADEMICBACKGROUND(StudentID,HighSchoolName, DateGraduated, SeniorHighAddress, FinalAvarage, HonorRewards) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, getStudentID());
			ps.setString(2, getSeniorHighName());
			ps.setString(3, getDateGraduated());
			ps.setString(4, getSeniorHighAddress());
			ps.setInt(5, getFinalAvarage());
			ps.setString(6, getHonorOrAwards());
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
	}
	
	public void EnrollmentDetails(String programCourse, String schoolarshipApplication, File ID, File TOR, File Certificate)
	{
		setProgramCourse(programCourse);
		setSchoolarshipApplication(schoolarshipApplication);
		setID(ID);
		setTOR(TOR);
		setCertificate(Certificate);
		try
		{
			connection = db_spconnection.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO COURSEENROLLMENTDETAILS(studentID, ProgramCourse, SchoolarApplication, ID_Picture, TOR, Good_Moral) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, getStudentID());
			ps.setString(2, getProgramCourse());
			ps.setString(3, getSchoolarshipApplication());
			FileInputStream IDfs = new FileInputStream(ID);
			FileInputStream TORfs = new FileInputStream(TOR);
			FileInputStream Certificatefs = new FileInputStream(Certificate);
			ps.setBinaryStream(4, IDfs, (int) ID.length());
			ps.setBinaryStream(5, TORfs, (int) TOR.length());
			ps.setBinaryStream(6, Certificatefs, (int) Certificate.length());
			ps.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
	}
	
	
	public void studentAccount(String UserName, String Password)
	{
		setUserName(UserName);
		setPassword(Password);
		try
		{
			connection = db_spconnection.getConnection();
			String query = ("INSERT INTO STUDENTACCOUNT(StudentID, UserName, Passwords) VALUES(?,?,?)");
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, getStudentID());
			ps.setString(2, getUserName());
			ps.setString(3, getPassword());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Successfully Created Account");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Error: " + ex.getMessage());
		}
	}
	
    public ImageIcon getStudentImage() {
        ImageIcon imageIcon = null;
        try {
            connection = db_spconnection.getConnection(); // Reuse existing DB connection
            String sql = "SELECT ID_Picture FROM COURSEENROLLMENTDETAILS WHERE StudentID = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, getStudentID());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Fetch image as byte array
                byte[] imgBytes = rs.getBytes("ID_Picture");
                if (imgBytes != null) {
                    // Convert bytes to ImageIcon
                    imageIcon = new ImageIcon(imgBytes);
                }
            }
            pstmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return imageIcon; // Return image or null
    }
    
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getMiddleInitial() 
	{
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) 
	{
		this.middleInitial = middleInitial;
	}

	public String getLastName() 
	{
		return LastName;
	}

	public void setLastName(String lastName) 
	{
		LastName = lastName;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getContactNumber() 
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) 
	{
		this.contactNumber = contactNumber;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getHomeAddress() 
	{
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) 
	{
		this.homeAddress = homeAddress;
	}
	
	public String getDateOfbirth() 
	{
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) 
	{
		this.dateOfbirth = dateOfbirth;
	}
	
	public String getRelationToStudent() 
	{
		return relationToStudent;
	}

	public void setRelationToStudent(String relationToStudent) 
	{
		this.relationToStudent = relationToStudent;
	}
	
	public String getSeniorHighName() 
	{
		return seniorHighName;
	}

	public void setSeniorHighName(String seniorHighName) 
	{
		this.seniorHighName = seniorHighName;
	}

	public String getDateGraduated() 
	{
		return dateGraduated;
	}

	public void setDateGraduated(String dateGradauted) 
	{
		this.dateGraduated = dateGradauted;
	}

	public String getSeniorHighAddress() 
	{
		return seniorHighAddress;
	}

	public void setSeniorHighAddress(String seniorHighAddress) 
	{
		this.seniorHighAddress = seniorHighAddress;
	}

	public String getHonorOrAwards() 
	{
		return honorOrAwards;
	}

	public void setHonorOrAwards(String honorOrAwards) 
	{
		this.honorOrAwards = honorOrAwards;
	}

	public int getFinalAvarage() 
	{
		return FinalAvarage;
	}

	public void setFinalAvarage(int finalAvarage) 
	{
		FinalAvarage = finalAvarage;
	}
	
	public String getProgramCourse() 
	{
		return programCourse;
	}

	public void setProgramCourse(String programCourse) 
	{
		this.programCourse = programCourse;
	}

	public String getSchoolarshipApplication() 
	{
		return schoolarshipApplication;
	}

	public void setSchoolarshipApplication(String schoolarshipApplication) 
	{
		this.schoolarshipApplication = schoolarshipApplication;
	}
	
	public File getID() 
	{
		return ID;
	}

	public void setID(File iD) 
	{
		ID = iD;
	}

	public File getTOR() {
		return TOR;
	}

	public void setTOR(File tOR) 
	{
		TOR = tOR;
	}

	public File getCertificate() 
	{
		return Certificate;
	}

	public void setCertificate(File certificate) 
	{
		Certificate = certificate;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	public static int getStudentID() {
		return StudentID;
	}

	public static void setStudentID(int studentID) {
		StudentID = studentID;
	}
}
