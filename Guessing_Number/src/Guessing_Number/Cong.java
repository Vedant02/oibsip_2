package Guessing_Number;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cong {

	JFrame frame;
	int rs;	

	/**
	 * Create the application.
	 */
	public Cong(int ans) {
		rs = ans;
		initialize();
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setFont(new Font("Monospaced", Font.BOLD, 25));
		textArea.setForeground(new Color(0, 0, 128));
		textArea.setBackground(new Color(135, 206, 250));
		textArea.setEditable(false);
		textArea.setText(""+rs);
		textArea.setBounds(167, 150, 60, 38);
		frame.getContentPane().add(textArea);
		
		
		if(rs>0)
		{
			JLabel lblNewLabel = new JLabel("!!!Congratulations!!!");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
			lblNewLabel.setForeground(new Color(33, 101, 141));
			lblNewLabel.setBounds(65, 46, 270, 49);
			frame.getContentPane().add(lblNewLabel);
		}
		else
		{
			JLabel lblNewLabel = new JLabel("Better Luck Next Time");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
			lblNewLabel.setBounds(70, 46, 270, 49);
			frame.getContentPane().add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Your Score :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(31, 144, 157, 49);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Try Again");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
				guess g = new guess(); 
				g.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(24, 301, 118, 49);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFocusable(false);
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnExit.setBackground(Color.ORANGE);
		btnExit.setBorderPainted(false);
		btnExit.setBounds(242, 301, 118, 49);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		
	}
}
