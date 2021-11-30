package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class InitializationWindow {
	// If it's selected register take to registerWindow
	// If it's selected login take to loginWindow
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("Button.shadow"));
		contentPanel.setForeground(Color.BLACK);
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel titleLabel = new JLabel("STRAVA");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setBounds(10, 11, 414, 26);
		contentPanel.add(titleLabel);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setForeground(new Color(0, 0, 0));
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(UIManager.getColor("Button.background"));
		buttonsPanel.setBounds(59, 67, 307, 183);
		contentPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);

		JButton toRegisterMenuButton = new JButton("Registrarse");
		toRegisterMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						RegisterMenuWindow rw = new RegisterMenuWindow();
						RegisterMenuWindow.NewScreen();

					}
				});

			}
		});
		toRegisterMenuButton.setForeground(UIManager.getColor("CheckBox.focus"));
		toRegisterMenuButton.setBackground(UIManager.getColor("CheckBox.light"));
		toRegisterMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toRegisterMenuButton.setBounds(89, 58, 128, 29);
		buttonsPanel.add(toRegisterMenuButton);

		JButton toLoginMenuButton = new JButton("Iniciar sesi\u00F3n");
		toLoginMenuButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						LoginMenuWindow lw = new LoginMenuWindow();
						LoginMenuWindow.NewScreen();

					}
				});

			}
		});
		toLoginMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toLoginMenuButton.setBackground(UIManager.getColor("CheckBox.light"));
		toLoginMenuButton.setForeground(UIManager.getColor("CheckBox.focus"));
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
