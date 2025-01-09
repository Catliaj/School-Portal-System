package SP_SignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import SP_Backend.Signup;


public class Step_1_SignUp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstnametxtfield;
	private JTextField MItxtfield;
	private JTextField lastnametxtfield;
	private JTextField contactnumbertxtfield;
	private JTextField emailtxtfield;
	private JTextField hometxtfield;
	private JButton nextbtn;
	private JDateChooser datebirth;
	private JRadioButton malerdbtn;
	private JRadioButton femalerdbtn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Step_1_SignUp frame = new Step_1_SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Step_1_SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 589);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		firstnametxtfield = new JTextField();
		firstnametxtfield.setBounds(10, 115, 150, 43);
		contentPane.add(firstnametxtfield);
		firstnametxtfield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Step 1: Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 25, 307, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 92, 122, 13);
		contentPane.add(lblNewLabel_1);
		
		MItxtfield = new JTextField();
		MItxtfield.setColumns(10);
		MItxtfield.setBounds(167, 115, 82, 43);
		contentPane.add(MItxtfield);
		
		JLabel lblNewLabel_1_1 = new JLabel("M.I");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(194, 92, 41, 13);
		contentPane.add(lblNewLabel_1_1);
		
		lastnametxtfield = new JTextField();
		lastnametxtfield.setColumns(10);
		lastnametxtfield.setBounds(259, 115, 117, 43);
		contentPane.add(lastnametxtfield);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(259, 92, 122, 13);
		contentPane.add(lblNewLabel_1_2);
		
	    datebirth = new JDateChooser();
		datebirth.setBounds(10, 191, 366, 50);
		contentPane.add(datebirth);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date Of Birth:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 168, 122, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Gender:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(10, 251, 122, 13);
		contentPane.add(lblNewLabel_1_3_1);
		
	    malerdbtn = new JRadioButton("Male");
		malerdbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		malerdbtn.setBounds(104, 247, 103, 21);
		malerdbtn.addActionListener(this);
		contentPane.add(malerdbtn);
		
	    femalerdbtn = new JRadioButton("Female");
		femalerdbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		femalerdbtn.setBounds(209, 247, 103, 21);
		femalerdbtn.addActionListener(this);
		contentPane.add(femalerdbtn);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Contact Number:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 274, 122, 13);
		contentPane.add(lblNewLabel_1_3_2);
		
		contactnumbertxtfield = new JTextField();
		contactnumbertxtfield.setColumns(10);
		contactnumbertxtfield.setBounds(10, 297, 366, 43);
		contentPane.add(contactnumbertxtfield);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Email Address:");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(10, 350, 122, 13);
		contentPane.add(lblNewLabel_1_3_2_1);
		
		emailtxtfield = new JTextField();
		emailtxtfield.setColumns(10);
		emailtxtfield.setBounds(10, 373, 366, 43);
		contentPane.add(emailtxtfield);
		
	    nextbtn = new JButton("Next");
		nextbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		nextbtn.setBounds(294, 502, 82, 40);
		nextbtn.addActionListener(this);
		contentPane.add(nextbtn);
		
		JLabel lblNewLabel_1_3_2_1_1 = new JLabel("Home Address");
		lblNewLabel_1_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1_1.setBounds(10, 426, 122, 13);
		contentPane.add(lblNewLabel_1_3_2_1_1);
		
		hometxtfield = new JTextField();
		hometxtfield.setColumns(10);
		hometxtfield.setBounds(10, 449, 366, 43);
		contentPane.add(hometxtfield);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextbtn)
		{
		
			int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure About Your Details?\n Because you will proceed to the next Step", "Confirmation Student Details", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION)
			{
				String FirstName = firstnametxtfield.getText();
				String MiddleInitial = MItxtfield.getText();
				String LastName = lastnametxtfield.getText();
				String ContactNumber = contactnumbertxtfield.getText();
				String Email = emailtxtfield.getText();
				String HomeAddress = hometxtfield.getText();
				
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yy,MM,dd");
		        String date = (datebirth.getDate() != null) ? dateFormat.format(datebirth.getDate()) : "Not Selected";
				if(malerdbtn.isSelected())
				{
					String Male = "Male";
					new Signup(FirstName, MiddleInitial, LastName, Male, date,ContactNumber,Email,HomeAddress);
					dispose();
					new Step_2_SignUp();
				}
				else if(femalerdbtn.isSelected())
				{
					String Female = "Female";
					new Signup(FirstName, MiddleInitial, LastName, Female, date,ContactNumber,Email,HomeAddress);
					dispose();
					new Step_2_SignUp();
				}
			}
			
		}
		
	}
}
