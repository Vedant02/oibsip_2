package Guessing_Number;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class guess {

	JFrame frame;
	private JTextField txtEnterNumber;
	Random rand = new Random();
	int guess_no = rand.nextInt(100)+1;
	int attempts_left = 5;
	int point=0;
	int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					guess window = new guess();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 206, 209));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Number Guessing Game");
		
		JTextArea txtrAttemptsLeft = new JTextArea();
		txtrAttemptsLeft.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrAttemptsLeft.setBackground(new Color(0, 0, 0));
		txtrAttemptsLeft.setForeground(new Color(255, 255, 255));
		txtrAttemptsLeft.setFocusable(false);
		txtrAttemptsLeft.setText(""+attempts_left);
		txtrAttemptsLeft.setBounds(312, 8, 62, 22);
		frame.getContentPane().add(txtrAttemptsLeft);
		
		txtEnterNumber = new JTextField();
		txtEnterNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNumber.setBounds(68, 54, 250, 45);
		frame.getContentPane().add(txtEnterNumber);
		txtEnterNumber.setColumns(10);
		
		JTextArea txtrPoints = new JTextArea();
		txtrPoints.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrPoints.setForeground(new Color(255, 255, 255));
		txtrPoints.setText("0");
		txtrPoints.setBackground(new Color(0, 0, 0));
		txtrPoints.setFocusable(false);
		txtrPoints.setBounds(78, 10, 56, 35);
		frame.getContentPane().add(txtrPoints);
		
		JTextArea txtrStart = new JTextArea();
		txtrStart.setForeground(new Color(192, 192, 192));
		txtrStart.setSelectedTextColor(new Color(192, 192, 192));
		txtrStart.setFocusable(false);
		txtrStart.setBackground(new Color(0, 0, 0));
		txtrStart.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrStart.setText("!!! Start !!!");
		txtrStart.setBounds(119, 209, 158, 45);
		frame.getContentPane().add(txtrStart);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Number = txtEnterNumber.getText();
				
				
				if(guess_no==Integer.parseInt(Number))
				{
					txtEnterNumber.setText("");
					attempts_left--; 
					point+=10;
					count++;
					txtrAttemptsLeft.setText(""+attempts_left);
					guess_no = rand.nextInt(100)+1;
					System.out.println(guess_no);
					txtrPoints.setText(""+point);
					txtrStart.setText(" !!!Matched!!!");
					txtrStart.setForeground(new Color(0, 255, 0));
				}
				else if(guess_no>Integer.parseInt(Number))
				{
					txtEnterNumber.setText("");
					txtrStart.setForeground(new Color(255, 0, 0));
					txtrStart.setText("   !Higher!");
					attempts_left--;
					count++;
					txtrAttemptsLeft.setText(""+attempts_left);
					System.out.println(guess_no);
				}
				else if(guess_no<Integer.parseInt(Number))
				{
					txtEnterNumber.setText("");
					txtrStart.setForeground(new Color(255, 255, 0));
					txtrStart.setText("   !Lower!");
					attempts_left--;
					count++;
					txtrAttemptsLeft.setText(""+attempts_left);
					System.out.println(guess_no);
				}
				
				if(attempts_left == 0)
				{
					point = (point/count)*10;
					Cong c = new Cong(point);
					frame.setVisible(false);
					c.frame.setVisible(true);
				}				
			}
		});
		btnNewButton.setBounds(154, 125, 80, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddRounds = new JButton("Add Rounds");
		btnAddRounds.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddRounds.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddRounds.setBorderPainted(false);
		btnAddRounds.setBackground(new Color(255, 160, 122));
		btnAddRounds.setFocusable(false);
		btnAddRounds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attempts_left++;
				txtrAttemptsLeft.setText(""+attempts_left);
			}
		});
		btnAddRounds.setBounds(10, 297, 124, 53);
		frame.getContentPane().add(btnAddRounds);
		
		JLabel lblNewLabel = new JLabel("Points :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setFocusable(false);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(20, 16, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Attempts Left : ");
		lblNewLabel_1.setFocusable(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(201, 14, 124, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnExit = new JButton("Quit");
		btnExit.setFocusable(false);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setBackground(Color.ORANGE);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(250, 297, 124, 53);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				if(point!=0)
					point = (point/count)*10;
				Cong c = new Cong(point);
				c.frame.setVisible(true);
				
			}
		});
		
		
		
	}
}
