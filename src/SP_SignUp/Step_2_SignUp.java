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

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import SP_Backend.Signup;

public class Step_2_SignUp extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField FNametextField;
	private JTextField MItextField;
	private JTextField LNametextField;
	private JTextField CNtextField;
	private JTextField HAtextField;
	private JTextField RStextField;
	private JButton NextBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Step_2_SignUp frame = new Step_2_SignUp();
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
	public Step_2_SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 589);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		FNametextField = new JTextField();
		FNametextField.setBounds(10, 115, 150, 43);
		contentPane.add(FNametextField);
		FNametextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Step 2: Parent/Guardian Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 27, 366, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 92, 122, 13);
		contentPane.add(lblNewLabel_1);
		
		MItextField = new JTextField();
		MItextField.setColumns(10);
		MItextField.setBounds(167, 115, 82, 43);
		contentPane.add(MItextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("M.I");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(194, 92, 41, 13);
		contentPane.add(lblNewLabel_1_1);
		
		LNametextField = new JTextField();
		LNametextField.setColumns(10);
		LNametextField.setBounds(259, 115, 117, 43);
		contentPane.add(LNametextField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last Name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(259, 92, 122, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Relationship to Student");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 178, 169, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Contact Number:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 254, 122, 13);
		contentPane.add(lblNewLabel_1_3_2);
		
		CNtextField = new JTextField();
		CNtextField.setColumns(10);
		CNtextField.setBounds(10, 277, 366, 43);
		contentPane.add(CNtextField);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Home Address:");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(10, 330, 122, 13);
		contentPane.add(lblNewLabel_1_3_2_1);
		
		HAtextField = new JTextField();
		HAtextField.setColumns(10);
		HAtextField.setBounds(10, 353, 366, 43);
		contentPane.add(HAtextField);
		
	    NextBtn = new JButton("Next");
		NextBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		NextBtn.setBounds(294, 483, 82, 43);
		NextBtn.addActionListener(this);
		contentPane.add(NextBtn);
		
		RStextField = new JTextField();
		RStextField.setColumns(10);
		RStextField.setBounds(10, 201, 366, 43);
		contentPane.add(RStextField);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == NextBtn)
		{
			int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure About Your Details?\n Because You Will Proceed To The Next Step", "Confirmation Parent/Guardian Details", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION)
			{
				Signup signup = new Signup();
				String FirstName = FNametextField.getText();
				String MiddleInitial = MItextField.getText();
				String LastName = LNametextField.getText();
				String RelationToStudent = RStextField.getText();
				String ContactNumber = CNtextField.getText();
				String HomeAddress = RStextField.getText();
				signup.parentOrGuardianInfo(FirstName, MiddleInitial, LastName, RelationToStudent, ContactNumber, HomeAddress);
				dispose();
				new Step_3_SignUp();
			}
		}
		
	}
}
