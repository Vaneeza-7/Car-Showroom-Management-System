package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class signIn {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public signIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		  frame = new JFrame();
	        getFrame().setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\logocar.png"));
	        getFrame().setBounds(100, 100, 933, 784);
	        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Create a panel with BorderLayout
	        JPanel panel = new JPanel();
	        panel.setBackground(Color.BLACK);

	        // Add a JLabel with your logo to the center
	        ImageIcon logoIcon = new ImageIcon(""); // Change the file extension if needed
	        panel.setLayout(null);
	        JLabel logoLabel = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\automotive.png"));
	        logoLabel.setBounds(259, 0, 919, 572);
	        panel.add(logoLabel);

	        // Create a panel for buttons at the bottom
	        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        buttonPanel.setBounds(0, 697, 919, 50);
	        buttonPanel.setBackground(new Color(0, 0, 0));

	        // Add the button panel to the bottom of the main panel
	        panel.add(buttonPanel);

	        // Add the main panel to the frame content pane
	        getFrame().getContentPane().add(panel);
	        
	                // Add Sign Up button
	                JButton btnNewButton = new JButton("Sign Up");
	                btnNewButton.setBackground(new Color(51, 204, 204));
	                btnNewButton.setFont(new Font("Myanmar Text", Font.BOLD, 13));
	                btnNewButton.setBounds(506, 602, 120, 40);
	                panel.add(btnNewButton);
	                btnNewButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                    	EventQueue.invokeLater(() -> {
                 	        	
                 	        	getFrame().dispose();
                 	            signup window = new signup();
                 				window.getFrame().setVisible(true);
                 	        });
	                    }
	                });
	                btnNewButton.setPreferredSize(new Dimension(120, 40));
	                
	                        // Add Login button
	                        JButton btnNewButton_1 = new JButton("Login");
	                        btnNewButton_1.setBackground(new Color(51, 204, 204));
	                        btnNewButton_1.setFont(new Font("Myanmar Text", Font.BOLD, 13));
	                        btnNewButton_1.setBounds(787, 602, 120, 40);
	                        panel.add(btnNewButton_1);
	                        btnNewButton_1.addActionListener(new ActionListener() {
	                            public void actionPerformed(ActionEvent e) {
	                            	
	                            	  EventQueue.invokeLater(() -> {
	                     	        	
	                     	        	getFrame().dispose();
	                     	            Login window = new Login();
	                     				window.getFrame().setVisible(true);
	                     	        });
	                            }
	                        });
	                        btnNewButton_1.setPreferredSize(new Dimension(120, 40));
	        getFrame().setVisible(true);
	    }

	public JFrame getFrame() {
		return frame;
	}
}
