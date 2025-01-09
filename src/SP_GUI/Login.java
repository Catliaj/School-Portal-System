package SP_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import SP_SignUp.Step_1_SignUp;
import SP_Backend.LoginBackend;

public class Login extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsernameField;
	private JPasswordField passwordField;
	private JButton btnSignup;
	private JCheckBox ShowPass;
	private JButton LoginBtn;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	
   
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 589);
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/Resources/Usericon.png")));
		lblNewLabel.setBounds(114, 31, 144, 177);
		contentPane.add(lblNewLabel);
		
		UsernameField = new JTextField();
		UsernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		UsernameField.setBounds(33, 246, 313, 54);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
	    LoginBtn = new JButton("Login");
		LoginBtn.setBounds(33, 467, 85, 35);
		LoginBtn.addActionListener(this);
		contentPane.add(LoginBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 209, 128, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(33, 330, 128, 27);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(33, 367, 313, 54);
		contentPane.add(passwordField);
		
	    btnSignup = new JButton("Sign up");
		btnSignup.setBounds(128, 467, 85, 35);
		btnSignup.addActionListener(this);
		contentPane.add(btnSignup);
		
	    ShowPass = new JCheckBox("Show Password");
		ShowPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ShowPass.setBounds(215, 427, 131, 21);
		contentPane.add(ShowPass);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btnSignup)
		{
			dispose();
			new Step_1_SignUp();
		}
		else if(e.getSource() == LoginBtn)
		{
			String UserName = UsernameField.getText();
			String Password = String.valueOf(passwordField.getPassword());
			LoginBackend login = new LoginBackend(UserName,Password);		
			if(login.loginSuccess())
			{
				dispose();
				new Student_Dashboard();			
			}
		}
		
	}
}
