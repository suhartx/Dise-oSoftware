package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterWithFacebookWindow {

	private JFrame frame;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegisterWithFacebookWindow window = new RegisterWithFacebookWindow();
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
	public RegisterWithFacebookWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(contentPanel);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(SystemColor.menu);
		buttonsPanel.setBounds(10, 36, 414, 214);
		contentPanel.add(buttonsPanel);

		JButton toMenuButton = new JButton("Acceder");
		toMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						frame.setVisible(false);
						MenuWindow mw = new MenuWindow();
						mw.NewScreen();
						
					}
				});
				
			}
		});
		toMenuButton.setForeground(Color.BLACK);
		toMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toMenuButton.setBackground(SystemColor.controlShadow);
		toMenuButton.setBounds(135, 174, 128, 29);
		buttonsPanel.add(toMenuButton);

		JPanel enterUserPanel = new JPanel();
		enterUserPanel.setLayout(null);
		enterUserPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		enterUserPanel.setBackground(SystemColor.controlHighlight);
		enterUserPanel.setBounds(10, 36, 394, 43);
		buttonsPanel.add(enterUserPanel);

		JPanel enterEmailTextPanel = new JPanel();
		enterEmailTextPanel.setLayout(null);
		enterEmailTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterEmailTextPanel.setBackground(Color.WHITE);
		enterEmailTextPanel.setBounds(10, 11, 374, 21);
		enterUserPanel.add(enterEmailTextPanel);

		JLabel emailLabel = new JLabel("Correo electr\u00F3nico:");
		emailLabel.setBackground(new Color(255, 255, 153));
		emailLabel.setBounds(10, 0, 92, 21);
		enterEmailTextPanel.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setToolTipText("");
		emailTextField.setText("example@gmail.com");
		emailTextField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		emailTextField.setColumns(10);
		emailTextField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		emailTextField.setBackground(Color.WHITE);
		emailTextField.setBounds(112, 2, 261, 18);
		enterEmailTextPanel.add(emailTextField);

		JPanel enterPasswordPanel = new JPanel();
		enterPasswordPanel.setLayout(null);
		enterPasswordPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		enterPasswordPanel.setBackground(SystemColor.controlHighlight);
		enterPasswordPanel.setBounds(10, 101, 394, 43);
		buttonsPanel.add(enterPasswordPanel);

		JPanel enterPasswordTextPanel = new JPanel();
		enterPasswordTextPanel.setLayout(null);
		enterPasswordTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterPasswordTextPanel.setBackground(Color.WHITE);
		enterPasswordTextPanel.setBounds(10, 11, 374, 21);
		enterPasswordPanel.add(enterPasswordTextPanel);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 0, 92, 21);
		enterPasswordTextPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(112, 2, 260, 17);
		enterPasswordTextPanel.add(passwordField);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						frame.setVisible(false);
						RegisterMenuWindow rw = new RegisterMenuWindow();
						rw.NewScreen();
						
					}
				});
			
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 2, 118, 23);
		buttonsPanel.add(backButton);

		JLabel titleLabel = new JLabel("Registro con Facebook");
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setBounds(10, 11, 414, 26);
		contentPanel.add(titleLabel);
	}
}
