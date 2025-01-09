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

public class Step_3_SignUp extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField SHSNametextField;
	private JTextField SHSAddresstextField;
	private JTextField FinalAvaragetextField;
	private JTextField HOAtextField;
	private JDateChooser datetextfield;
	private JButton NextBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Step_3_SignUp frame = new Step_3_SignUp();
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
	public Step_3_SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 589);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane.setLayout(null);
		
		SHSNametextField = new JTextField();
		SHSNametextField.setBounds(10, 115, 366, 43);
		contentPane.add(SHSNametextField);
		SHSNametextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Step 3: Academic Background");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 27, 366, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senior High School Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 92, 194, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Senior High School Address:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 254, 217, 19);
		contentPane.add(lblNewLabel_1_3_2);
		
		SHSAddresstextField = new JTextField();
		SHSAddresstextField.setColumns(10);
		SHSAddresstextField.setBounds(10, 277, 366, 43);
		contentPane.add(SHSAddresstextField);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Final Avarage:");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_1.setBounds(10, 336, 122, 30);
		contentPane.add(lblNewLabel_1_3_2_1);
		
		FinalAvaragetextField = new JTextField();
		FinalAvaragetextField.setColumns(10);
		FinalAvaragetextField.setBounds(113, 332, 263, 43);
		contentPane.add(FinalAvaragetextField);
		
	    NextBtn = new JButton("Next");
		NextBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		NextBtn.setBounds(294, 483, 82, 43);
		NextBtn.addActionListener(this);
		contentPane.add(NextBtn);
		
	    datetextfield = new JDateChooser();
		datetextfield.setBounds(10, 201, 366, 43);
		contentPane.add(datetextfield);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date Graduated:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 178, 194, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3_2_2 = new JLabel("Honors or Awards(if any):");
		lblNewLabel_1_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2.setBounds(10, 385, 217, 19);
		contentPane.add(lblNewLabel_1_3_2_2);
		
		HOAtextField = new JTextField();
		HOAtextField.setColumns(10);
		HOAtextField.setBounds(10, 408, 366, 43);
		contentPane.add(HOAtextField);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub	
		if(e.getSource() == NextBtn)
		{
			Signup signup = new Signup();
			String SeniorHighName = SHSNametextField.getText();
			String SeniorHighAddress = SHSAddresstextField.getText();
			String FinalAvarage = FinalAvaragetextField.getText();
			int ConverIntFinalAvarage = Integer.parseInt(FinalAvarage);
			String HonorsOrAwards = HOAtextField.getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yy,MM,dd");
	        String date = (datetextfield.getDate() != null) ? dateFormat.format(datetextfield.getDate()) : "Not Selected";		
			
	        int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure About Your Details?\n Because you will proceed to the next Step", "Confirmation Academic Background Details", JOptionPane.YES_NO_OPTION); 
			if(confirm == JOptionPane.YES_OPTION)
			{
				signup.AcademicBackground(SeniorHighName, date, SeniorHighAddress, ConverIntFinalAvarage, HonorsOrAwards);
				dispose();
				new Step_4_SignUp();
			}
		}
		
	}
}
