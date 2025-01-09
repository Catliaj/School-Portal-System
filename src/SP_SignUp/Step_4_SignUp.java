package SP_SignUp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import SP_Backend.Signup;

public class Step_4_SignUp extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IDtextfield;
	private JTextField TORtextField;
	private JTextField certificateGMCtxtfield;
	private JButton btnUploadID;
	private JButton btnUploadTOR;
	private JButton btnUploadCertificateGMC;
	private File selectedFileID;
	private File selectedFileTOR;
	private File selectedFileCertificate;
	private JButton nextBtn;
	private JComboBox ProgramCoursecomboBox;
	private JComboBox schoolarshipComboBox;
	private JRadioButton yesrdbtn;
	private JRadioButton rdbtnNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Step_4_SignUp frame = new Step_4_SignUp();
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
	public Step_4_SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(400, 620);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Step 4: Course Enrollment Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 27, 366, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Program or Course");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 92, 194, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Type of Scholarship (if yes):");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2.setBounds(10, 223, 217, 19);
		contentPane.add(lblNewLabel_1_3_2);
		
	    nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		nextBtn.setBounds(290, 550, 82, 30);
		contentPane.add(nextBtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Schoolarship Application(if applicable)");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 168, 307, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3_2_2 = new JLabel("Documents to Submit (Image Uploads)");
		lblNewLabel_1_3_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3_2_2.setBounds(10, 305, 325, 19);
		contentPane.add(lblNewLabel_1_3_2_2);
		
		IDtextfield = new JTextField();
		IDtextfield.setColumns(10);
		IDtextfield.setBounds(10, 362, 260, 33);
		contentPane.add(IDtextfield);
		
	    ProgramCoursecomboBox = new JComboBox();
		ProgramCoursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Bachelor of Science in Information Technology (BSIT)", "Bachelor of Science in Criminology (BSC)", "Bachelor of Science in Accountacy( BSA)", "Bachelor of Arts in Communication (BAC)", ""}));
		ProgramCoursecomboBox.setBounds(10, 115, 366, 43);
		contentPane.add(ProgramCoursecomboBox);
		
	    yesrdbtn = new JRadioButton("Yes\r\n");
		yesrdbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yesrdbtn.setBounds(10, 196, 103, 21);
		contentPane.add(yesrdbtn);
		
	    rdbtnNo = new JRadioButton("No");
		rdbtnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNo.setBounds(124, 196, 103, 21);
		contentPane.add(rdbtnNo);
		
	    schoolarshipComboBox = new JComboBox();
		schoolarshipComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Academic", "Athletic", "Needs-Based", "Goverment", "Private Sponsorship"}));
		schoolarshipComboBox.setBounds(10, 252, 366, 43);
		contentPane.add(schoolarshipComboBox);
		
	    btnUploadID = new JButton("Upload");
		btnUploadID.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUploadID.setBounds(280, 362, 96, 33);
		btnUploadID.addActionListener(this);
		contentPane.add(btnUploadID);
		
		JLabel lblNewLabel_1_3_2_2_1 = new JLabel("ID Picture(2 x 2 size):");
		lblNewLabel_1_3_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2_1.setBounds(10, 335, 247, 19);
		contentPane.add(lblNewLabel_1_3_2_2_1);
		
		JLabel lblNewLabel_1_3_2_2_1_1 = new JLabel("Transcript of Records (TOR):");
		lblNewLabel_1_3_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2_1_1.setBounds(10, 405, 247, 19);
		contentPane.add(lblNewLabel_1_3_2_2_1_1);
		
		TORtextField = new JTextField();
		TORtextField.setColumns(10);
		TORtextField.setBounds(10, 436, 260, 33);
		contentPane.add(TORtextField);
		
	    btnUploadTOR = new JButton("Upload");
		btnUploadTOR.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUploadTOR.setBounds(280, 434, 96, 33);
		btnUploadTOR.addActionListener(this);
		contentPane.add(btnUploadTOR);
		
		certificateGMCtxtfield = new JTextField();
		certificateGMCtxtfield.setColumns(10);
		certificateGMCtxtfield.setBounds(10, 509, 260, 33);
		contentPane.add(certificateGMCtxtfield);
		
		JLabel lblNewLabel_1_3_2_2_1_1_1 = new JLabel("Certificate of Good Moral Character:");
		lblNewLabel_1_3_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_2_2_1_1_1.setBounds(10, 480, 247, 19);
		contentPane.add(lblNewLabel_1_3_2_2_1_1_1);
		
	    btnUploadCertificateGMC = new JButton("Upload");
		btnUploadCertificateGMC.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUploadCertificateGMC.setBounds(280, 507, 96, 33);
		btnUploadCertificateGMC.addActionListener(this);
		contentPane.add(btnUploadCertificateGMC);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btnUploadID)
		{
			JFileChooser filechoose = new JFileChooser();
			filechoose.setDialogTitle("Select an Image");
			filechoose.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
			int result = filechoose.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				selectedFileID = filechoose.getSelectedFile();
				IDtextfield.setText(selectedFileID.getAbsolutePath());
			}
		}
		else if(e.getSource() == btnUploadTOR)
		{
			JFileChooser filechoose = new JFileChooser();
			filechoose.setDialogTitle("Select an Image");
			filechoose.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
			int result = filechoose.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				selectedFileTOR = filechoose.getSelectedFile();
				TORtextField.setText(selectedFileTOR.getAbsolutePath());
			}
		}
		else if(e.getSource() == btnUploadCertificateGMC)
		{
			JFileChooser filechoose = new JFileChooser();
			filechoose.setDialogTitle("Select an Image");
			filechoose.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
			int result = filechoose.showOpenDialog(null);
			
			if(result == JFileChooser.APPROVE_OPTION)
			{
				selectedFileCertificate = filechoose.getSelectedFile();
				certificateGMCtxtfield.setText(selectedFileCertificate.getAbsolutePath());
			}
		}
		
		else if(e.getSource() == nextBtn)
		{
			int confirm = JOptionPane.showConfirmDialog(null, "Are You Sure About Your Details?\n Because you will proceed to the next Step", "Confirmation Student Details", JOptionPane.YES_NO_OPTION);
			if(confirm == JOptionPane.YES_OPTION)
			{
				Signup signup = new Signup();
				String ProgramCourse = (String) ProgramCoursecomboBox.getSelectedItem();
				if(yesrdbtn.isSelected())
				{
					String Schoolar = (String) schoolarshipComboBox.getSelectedItem();
					signup.EnrollmentDetails(ProgramCourse, Schoolar, selectedFileID, selectedFileTOR, selectedFileCertificate);
					dispose();
					new Step_5_SignUp();
				}
				else
				{
					String Schoolar = "No Schoolar";
					signup.EnrollmentDetails(ProgramCourse, Schoolar, selectedFileID, selectedFileTOR, selectedFileCertificate);
					dispose();
					new Step_5_SignUp();
				}	
			}
		}
	}
	
	
}
