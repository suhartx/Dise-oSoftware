package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class InitializationWindow { 
	//If it's selected register take to registerWindow 
	//If it's selected login take to loginWindow
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitializationWindow window = new InitializationWindow();
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
	public InitializationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setForeground(Color.BLACK);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("STRAVA");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setBounds(128, 11, 149, 26);
		contentPanel.add(titleLabel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		buttonsPanel.setBounds(62, 36, 307, 183);
		contentPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		JButton toRegisterMenuButton = new JButton("Registrarse");
		toRegisterMenuButton.setForeground(Color.WHITE);
		toRegisterMenuButton.setBackground(Color.DARK_GRAY);
		toRegisterMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toRegisterMenuButton.setBounds(89, 58, 128, 29);
		buttonsPanel.add(toRegisterMenuButton);
		
		JButton toLoginMenuButton = new JButton("Iniciar sesi\u00F3n");
		toLoginMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toLoginMenuButton.setBackground(Color.DARK_GRAY);
		toLoginMenuButton.setForeground(Color.WHITE);
		toLoginMenuButton.setBounds(89, 119, 128, 29);
		buttonsPanel.add(toLoginMenuButton);
		
		JLabel lblNewLabel = new JLabel("Bienvenido/a seleccione una opci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 287, 36);
		buttonsPanel.add(lblNewLabel);
	}
}
