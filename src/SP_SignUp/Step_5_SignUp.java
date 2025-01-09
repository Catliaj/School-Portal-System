package SP_SignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import SP_Backend.Signup;
import SP_GUI.Login;
import java.awt.Color;

public class Step_5_SignUp extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernametxt;
	private JPasswordField passtxt;
	private JPasswordField confirmpasstxt;
	private JButton SignUpBtn;
	private JLabel USERPROFILE;
	Signup Signup = new Signup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Step_5_SignUp frame = new Step_5_SignUp();
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
	public Step_5_SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 589);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane.setLayout(null);
		
		usernametxt = new JTextField();
		usernametxt.setBounds(10, 236, 366, 43);
		contentPane.add(usernametxt);
		usernametxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Step 5: Account Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 366, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 213, 122, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(10, 299, 169, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Confirm Password");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 375, 122, 13);
		contentPane.add(lblNewLabel_1_3_2);
		
	    SignUpBtn = new JButton("Sign Up");
		SignUpBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		SignUpBtn.setBounds(281, 499, 105, 43);
		SignUpBtn.addActionListener(this);
		contentPane.add(SignUpBtn);
		
		passtxt = new JPasswordField();
		passtxt.setBounds(10, 325, 366, 43);
		contentPane.add(passtxt);
		
		confirmpasstxt = new JPasswordField();
		confirmpasstxt.setBounds(10, 398, 366, 43);
		contentPane.add(confirmpasstxt);
		
	    USERPROFILE = new JLabel("");
		USERPROFILE.setBackground(Color.WHITE);
		USERPROFILE.setBounds(106, 53, 150, 150);
		contentPane.add(USERPROFILE);
		fetchImage();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == SignUpBtn)
		{
			String UserName = usernametxt.getText();
			String Password = String.valueOf(passtxt.getPassword());
			String ConfirmPass = String.valueOf(confirmpasstxt.getPassword());
			if(Password.equals(ConfirmPass))
			{
		        int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure About Your Details?\n Because you will proceed to the next Step", "Confirmation Academic Background Details", JOptionPane.YES_NO_OPTION); 
				if(confirm == JOptionPane.YES_OPTION)
				{
					
					Signup.studentAccount(UserName, Password);
					dispose();
					new Login();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Password not match");
			}
		}
		
	}
    private void fetchImage() 
    {
        try {
            ImageIcon imageIcon = Signup.getStudentImage();  // Retrieve from backend
            if (imageIcon != null) {
                // Resize and display image
                Image image = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                USERPROFILE.setIcon(new ImageIcon(image));
            } else {
                JOptionPane.showMessageDialog(null, "Image not found for Student ID!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
