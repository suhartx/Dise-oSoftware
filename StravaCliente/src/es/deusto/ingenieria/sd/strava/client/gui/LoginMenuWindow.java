package es.deusto.ingenieria.sd.strava.client.gui;

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

public class LoginMenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginMenuWindow window = new LoginMenuWindow();
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
	public LoginMenuWindow() {
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
		contentPanel.setForeground(UIManager.getColor("Button.shadow"));
		contentPanel.setBackground(UIManager.getColor("Button.shadow"));
		contentPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(contentPanel);

		JLabel lblTitle = new JLabel("INICIO SESI\u00D3N");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(10, 11, 414, 26);
		contentPanel.add(lblTitle);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(UIManager.getColor("Button.background"));
		buttonsPanel.setBounds(62, 36, 307, 214);
		contentPanel.add(buttonsPanel);

		JButton btnIniciarSesion = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						LoginWithEmailWindow lw = new LoginWithEmailWindow();
						LoginWithEmailWindow.NewScreen();
					}
				});
			}
		});
		btnIniciarSesion.setForeground(UIManager.getColor("CheckBox.focus"));
		btnIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIniciarSesion.setBackground(UIManager.getColor("CheckBox.light"));
		btnIniciarSesion.setBounds(51, 61, 187, 71);
		buttonsPanel.add(btnIniciarSesion);

		JButton btnInicioGoogle = new JButton("Iniciar sesi\u00F3n con Google");
		btnInicioGoogle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {

						frame.setVisible(false);
						LoginWithGoogleWindow lwG = new LoginWithGoogleWindow();
						LoginWithGoogleWindow.NewScreen();

					}
				});

			}
		});
		btnInicioGoogle.setForeground(Color.WHITE);
		btnInicioGoogle.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnInicioGoogle.setBackground(Color.DARK_GRAY);
		btnInicioGoogle.setBounds(51, 160, 187, 21);
		buttonsPanel.add(btnInicioGoogle);

		JLabel lblNewLabel = new JLabel("Bienvenido/a seleccione una opci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 287, 36);
		buttonsPanel.add(lblNewLabel);

		JButton btnInicioConFacebook = new JButton("Iniciar sesi\u00F3n con Facebook");
		btnInicioConFacebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						LoginWithFacebookWindow lwF = new LoginWithFacebookWindow();
						LoginWithFacebookWindow.NewScreen();

					}
				});

			}
		});
		btnInicioConFacebook.setForeground(Color.WHITE);
		btnInicioConFacebook.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnInicioConFacebook.setBackground(Color.DARK_GRAY);
		btnInicioConFacebook.setBounds(51, 182, 187, 21);
		buttonsPanel.add(btnInicioConFacebook);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						InitializationWindow iw = new InitializationWindow();
						InitializationWindow.NewScreen();

					}
				});

			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(0, 0, 118, 23);
		contentPanel.add(backButton);
	}
}
