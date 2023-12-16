package gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;

public class GenerateReport {
	

	private JFrame frame;
	 private ChartPanel chartPanel;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public GenerateReport() {
		initialize();
		frame.setVisible(true);
		generateAndDisplayReport();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 810, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon logoIcon = new ImageIcon("D:\\logocar.png");

        chartPanel = new ChartPanel();
        chartPanel.setForeground(new Color(0, 204, 204));
        chartPanel.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        chartPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sales Report");
        lblNewLabel.setBounds(-10, 31, 786, 29);
        chartPanel.add(lblNewLabel);
        lblNewLabel.setForeground(SystemColor.inactiveCaption);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	
	 private void generateAndDisplayReport() {
	        String url = "jdbc:mysql://localhost:3306/carshowroom";
	        String user = "root";
	        String password = "vcpkf2021";

	        try (Connection connection = DriverManager.getConnection(url, user, password)) {
	            String query = "SELECT * FROM sales";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    while (resultSet.next()) {
	                        int saleID = resultSet.getInt("SaleID");
	                        String carSold = resultSet.getString("carSold");

	                        chartPanel.addBar(saleID, carSold);
	        	            	                        
	                    }
	                    JOptionPane.showMessageDialog(frame, "Report Displayed");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(frame, "Error connecting to the database or retrieving data");
	        }
	    }

	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}

}


 class ChartPanel extends JPanel {
    private static final int BAR_WIDTH = 140;
    private static final int GAP = 10;

    private final java.util.List<Bar> bars;

    public ChartPanel() {
        this.bars = new java.util.ArrayList<>();
    }

    public void addBar(int value, String label) {
        bars.add(new Bar(value, label));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = GAP;

        for (Bar bar : bars) {
            g.setColor(Color.cyan);
            g.fillRect(x, getHeight() - bar.getHeight(), BAR_WIDTH, bar.getHeight());

            g.setColor(Color.cyan);
            g.drawString(bar.getLabel() + " (" + bar.getValue() + ")", x, getHeight() - bar.getHeight() - GAP);

            x += BAR_WIDTH + GAP;
        }
    }

    private static class Bar {
        private final int height;
        private final String label;
        private final int value;

        public Bar(int value, String label) {
            this.height = value * 130;
            this.label = label;
            this.value = value;
        }

        public int getHeight() {
            return height;
        }

        public String getLabel() {
            return label;
        }

        public int getValue() {
            return value;
        }
    }
}

   

