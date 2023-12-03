package gui;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businessLogic.UserController;
import businessLogic.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

public class ManagerHome {
private int userId;
	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerHome window = new ManagerHome();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public void onManageButtonClicked()
	{
		
		EventQueue.invokeLater(() -> {
       	 // Dispose the current Signup frame
       	frame.dispose();
           CarInventory window = new CarInventory();
			window.getFrame().setVisible(true);
       });
	}
	/**
	 * Create the application.
	 */
	public ManagerHome(int UserId) {
		this.userId=UserId;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 1037, 711);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(0, 204, 204));
		textPane.setBounds(10, 11, 1001, 38);
		frame.getContentPane().add(textPane);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(0, 204, 204));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(20, 56, 232, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("About Us");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setForeground(new Color(0, 204, 204));
		btnNewButton_2.setBounds(282, 56, 278, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Cars");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setForeground(new Color(0, 204, 204));
		btnNewButton_3.setBackground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(582, 55, 285, 46);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ManagerHomeController(this));
		
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setForeground(new Color(0, 204, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(885, 60, 126, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		UserController User= new UserController();
		user userInfo = User.retreiveUserInfo(userId);
		
		JLabel lblNewLabel= new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
		lblNewLabel.setBounds(192, 0, 1151, 700);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(27, 210, 63, 17);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Screenshot 2023-05-13 051758.png"));
		lblNewLabel_3.setBounds(27, 253, 46, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email ID");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(27, 308, 86, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(27, 481, 100, 22);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\email logo.jpg"));
		lblNewLabel_6.setBounds(27, 350, 46, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Screenshot 2023-05-13 052224.png"));
		lblNewLabel_7.setBounds(27, 525, 46, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("User ID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(30, 113, 75, 22);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\idicon.jpg"));
		lblNewLabel_9.setBounds(27, 161, 46, 31);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Contact Information");
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(27, 405, 186, 22);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_1 = new JLabel(String.valueOf(userId));
		lblNewLabel_1.setForeground(new Color(0, 204, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(103, 161, 175, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_11 = new JLabel(userInfo.getName());
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_11.setForeground(new Color(0, 204, 204));
		lblNewLabel_11.setBounds(103, 253, 149, 31);
		frame.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel(userInfo.getEmailID());
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_12.setForeground(new Color(0, 204, 204));
		lblNewLabel_12.setBounds(103, 343, 216, 38);
		frame.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel(userInfo.getPassword());
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_13.setForeground(new Color(0, 204, 204));
		lblNewLabel_13.setBounds(84, 438, 168, 32);
		frame.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel(userInfo.getContactInfo());
		lblNewLabel_14.setForeground(new Color(0, 204, 204));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_14.setBounds(94, 514, 168, 31);
		frame.getContentPane().add(lblNewLabel_14);
		
		JButton btnNewButton_4 = new JButton("Change Password");
		btnNewButton_4.setBackground(new Color(0, 204, 204));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(410, 576, 216, 46);
		frame.getContentPane().add(btnNewButton_4);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(27, 576, 207, 46);
		frame.getContentPane().add(passwordField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 576, 212, 46);
		frame.getContentPane().add(passwordField);

        // Add ActionListener to the button
		btnNewButton_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actions to perform when the button is clicked
                String newPassword = new String(passwordField.getPassword());

                userInfo.setPassword(newPassword);
                User.changePassword(userId, newPassword);
                
                // For example, display a message
                JOptionPane.showMessageDialog(null, "Password Updated Successfully");
            }
        });
        
		}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setBackground(new Color(0, 0, 0));
	}
}
