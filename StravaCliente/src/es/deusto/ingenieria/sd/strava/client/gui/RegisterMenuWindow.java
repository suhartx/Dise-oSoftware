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

public class RegisterMenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegisterMenuWindow window = new RegisterMenuWindow();
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
	public RegisterMenuWindow() {
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

		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setVerticalAlignment(SwingConstants.TOP);
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistro.setBounds(10, 11, 414, 26);
		contentPanel.add(lblRegistro);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(UIManager.getColor("Button.background"));
		buttonsPanel.setBounds(62, 36, 307, 214);
		contentPanel.add(buttonsPanel);

		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						RegisterWithEmailWindow rw = new RegisterWithEmailWindow();
						RegisterWithEmailWindow.NewScreen();
					}
				});
			}
		});
		btnCrearCuenta.setForeground(UIManager.getColor("CheckBox.focus"));
		btnCrearCuenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCrearCuenta.setBackground(UIManager.getColor("CheckBox.light"));
		btnCrearCuenta.setBounds(51, 61, 187, 71);
		buttonsPanel.add(btnCrearCuenta);

		JButton btnRegistrarseConGoogle = new JButton("Registrarse con Google");
		btnRegistrarseConGoogle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						RegisterWithGoogleWindow rwg = new RegisterWithGoogleWindow();
						RegisterWithGoogleWindow.NewScreen();
					}
				});

			}
		});
		btnRegistrarseConGoogle.setForeground(Color.WHITE);
		btnRegistrarseConGoogle.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRegistrarseConGoogle.setBackground(Color.DARK_GRAY);
		btnRegistrarseConGoogle.setBounds(65, 160, 162, 21);
		buttonsPanel.add(btnRegistrarseConGoogle);

		JLabel lblNewLabel = new JLabel("Bienvenido/a seleccione una opci\u00F3n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 287, 36);
		buttonsPanel.add(lblNewLabel);

		JButton btnRegistrarseConFacebook = new JButton("Registrarse con Facebook");
		btnRegistrarseConFacebook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						RegisterWithFacebookWindow rwF = new RegisterWithFacebookWindow();
						RegisterWithFacebookWindow.NewScreen();

					}
				});

			}
		});
		btnRegistrarseConFacebook.setForeground(Color.WHITE);
		btnRegistrarseConFacebook.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRegistrarseConFacebook.setBackground(Color.DARK_GRAY);
		btnRegistrarseConFacebook.setBounds(65, 182, 162, 21);
		buttonsPanel.add(btnRegistrarseConFacebook);

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
		backButton.setBounds(0, 0, 118, 23);
		contentPanel.add(backButton);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	}
}
