package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import es.deusto.ingenieria.sd.strava.client.controller.LoginController;
import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;

public class RegisterWithEmailWindow {

	private JFrame frame;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JTextField nombreTextField;
	private JYearChooser yearChooserSpinner;
	private JMonthChooser monthChooserSpinner;
	private JSpinner dayChooserSpinner;
	private LoginController loginController;
	private static ServiceLocator serviceLocator = new ServiceLocator();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		ServiceLocator serviceLocator = new ServiceLocator();
//		serviceLocator.setService(args[0], args[1], args[2]);
//	}
	public static void NewScreen() {
		//serviceLocator = new ServiceLocator();
		//serviceLocator.getService();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RegisterWithEmailWindow window = new RegisterWithEmailWindow();
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
	public RegisterWithEmailWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//loginController = new LoginController(serviceLocator);
		frame = new JFrame();
		frame.setBounds(100, 100, 483, 381);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 467, 342);
		frame.getContentPane().add(contentPanel);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonsPanel.setBackground(SystemColor.menu);
		buttonsPanel.setBounds(10, 36, 447, 295);
		contentPanel.add(buttonsPanel);

		JButton toMenuButton = new JButton("Acceder");
		toMenuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						int anyo = yearChooserSpinner.getValue();
						int mes = monthChooserSpinner.getMonth();
						int dia = (Integer)dayChooserSpinner.getValue();
						String str = Integer.toString(dia) + " " + Integer.toString(mes) + " " + Integer.toString(anyo);
						SimpleDateFormat df = new SimpleDateFormat("MM dd yyyy");
						long tiempo = 0;
						try {
							tiempo = df.parse(str).getTime();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//loginController.registro(emailTextField.getText(), nombreTextField.getText(), new Date(tiempo), passwordField.getPassword().toString());
						//check if user exists!
						frame.setVisible(false);
						MenuWindow mw = new MenuWindow();
						MenuWindow.NewScreen();

					}
				});


			}
		});
		toMenuButton.setForeground(Color.BLACK);
		toMenuButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		toMenuButton.setBackground(SystemColor.controlShadow);
		toMenuButton.setBounds(148, 255, 128, 29);
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
		enterPasswordPanel.setBounds(10, 207, 394, 43);
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
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 2, 118, 23);
		buttonsPanel.add(backButton);

		JPanel enterNamePanel = new JPanel();
		enterNamePanel.setLayout(null);
		enterNamePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		enterNamePanel.setBackground(SystemColor.controlHighlight);
		enterNamePanel.setBounds(10, 90, 394, 43);
		buttonsPanel.add(enterNamePanel);

		JPanel enterNameTextPanel = new JPanel();
		enterNameTextPanel.setLayout(null);
		enterNameTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterNameTextPanel.setBackground(Color.WHITE);
		enterNameTextPanel.setBounds(10, 11, 374, 21);
		enterNamePanel.add(enterNameTextPanel);

		JLabel nameLabel = new JLabel("Nombre: ");
		nameLabel.setBackground(new Color(255, 255, 153));
		nameLabel.setBounds(10, 0, 92, 21);
		enterNameTextPanel.add(nameLabel);

		nombreTextField = new JTextField();
		nombreTextField.setToolTipText("");
		nombreTextField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		nombreTextField.setColumns(10);
		nombreTextField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nombreTextField.setBackground(Color.WHITE);
		nombreTextField.setBounds(112, 2, 261, 18);
		enterNameTextPanel.add(nombreTextField);

		JPanel enterFechaNacimientoPanel = new JPanel();
		enterFechaNacimientoPanel.setLayout(null);
		enterFechaNacimientoPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		enterFechaNacimientoPanel.setBackground(SystemColor.controlHighlight);
		enterFechaNacimientoPanel.setBounds(10, 147, 394, 49);
		buttonsPanel.add(enterFechaNacimientoPanel);

		JPanel enterFechaNacimientoTextPanel = new JPanel();
		enterFechaNacimientoTextPanel.setLayout(null);
		enterFechaNacimientoTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterFechaNacimientoTextPanel.setBackground(Color.WHITE);
		enterFechaNacimientoTextPanel.setBounds(10, 11, 374, 28);
		enterFechaNacimientoPanel.add(enterFechaNacimientoTextPanel);

		JLabel fechaNacimientoLabel = new JLabel("Fecha nacimiento: ");
		fechaNacimientoLabel.setBackground(new Color(255, 255, 153));
		fechaNacimientoLabel.setBounds(10, 0, 92, 28);
		enterFechaNacimientoTextPanel.add(fechaNacimientoLabel);

		yearChooserSpinner = new JYearChooser();
		yearChooserSpinner.setBounds(300, 4, 48, 20);
		yearChooserSpinner.setEndYear(2021);
		yearChooserSpinner.setStartYear(1900);
		enterFechaNacimientoTextPanel.add(yearChooserSpinner);

		monthChooserSpinner = new JMonthChooser();
		monthChooserSpinner.setBounds(178, 4, 100, 20);
		enterFechaNacimientoTextPanel.add(monthChooserSpinner);

		dayChooserSpinner = new JSpinner();
		dayChooserSpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		dayChooserSpinner.setBounds(128, 4, 30, 20);
		enterFechaNacimientoTextPanel.add(dayChooserSpinner);

		JLabel lblRegistroConEmail = new JLabel("Registro con Email");
		lblRegistroConEmail.setVerticalAlignment(SwingConstants.TOP);
		lblRegistroConEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroConEmail.setForeground(Color.WHITE);
		lblRegistroConEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRegistroConEmail.setBounds(10, 11, 414, 26);
		contentPanel.add(lblRegistroConEmail);
	}
}
