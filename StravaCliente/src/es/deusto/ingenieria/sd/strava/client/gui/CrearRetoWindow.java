package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class CrearRetoWindow {

	private JFrame frame;
	private JTextField nombreTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRetoWindow window = new CrearRetoWindow();
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
	public CrearRetoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 345);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 477, 306);
		frame.getContentPane().add(contentPanel);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(10, 42, 457, 256);
		contentPanel.add(buttonsPanel);
		
		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 437, 233);
		buttonsPanel.add(variablesPanel);
		
		JPanel nombrePanel = new JPanel();
		nombrePanel.setLayout(null);
		nombrePanel.setBounds(10, 11, 374, 21);
		variablesPanel.add(nombrePanel);
		
		JPanel nombreTextPanel = new JPanel();
		nombreTextPanel.setLayout(null);
		nombreTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreTextPanel.setBackground(Color.WHITE);
		nombreTextPanel.setBounds(0, 0, 374, 21);
		nombrePanel.add(nombreTextPanel);
		
		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBackground(new Color(255, 255, 153));
		nombreLabel.setBounds(10, 0, 92, 21);
		nombreTextPanel.add(nombreLabel);
		
		nombreTextField = new JTextField();
		nombreTextField.setToolTipText("");
		nombreTextField.setText("reto 1");
		nombreTextField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		nombreTextField.setColumns(10);
		nombreTextField.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		nombreTextField.setBackground(Color.WHITE);
		nombreTextField.setBounds(112, 2, 261, 18);
		nombreTextPanel.add(nombreTextField);
		
		JPanel deportePanel = new JPanel();
		deportePanel.setLayout(null);
		deportePanel.setBounds(10, 43, 114, 21);
		variablesPanel.add(deportePanel);
		
		JPanel deporteTextPanel = new JPanel();
		deporteTextPanel.setLayout(null);
		deporteTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		deporteTextPanel.setBackground(Color.WHITE);
		deporteTextPanel.setBounds(0, 0, 113, 21);
		deportePanel.add(deporteTextPanel);
		
		JLabel deporteLabel = new JLabel("Deporte:");
		deporteLabel.setBackground(new Color(255, 255, 153));
		deporteLabel.setBounds(10, 0, 92, 21);
		deporteTextPanel.add(deporteLabel);
		
		JPanel distanciaPanel = new JPanel();
		distanciaPanel.setLayout(null);
		distanciaPanel.setBounds(10, 120, 170, 21);
		variablesPanel.add(distanciaPanel);
		
		JPanel distanciaTextPanel = new JPanel();
		distanciaTextPanel.setLayout(null);
		distanciaTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		distanciaTextPanel.setBackground(Color.WHITE);
		distanciaTextPanel.setBounds(0, 0, 170, 21);
		distanciaPanel.add(distanciaTextPanel);
		
		JLabel distanciaLabel = new JLabel("Distancia: ");
		distanciaLabel.setBackground(new Color(255, 255, 153));
		distanciaLabel.setBounds(10, 0, 92, 21);
		distanciaTextPanel.add(distanciaLabel);
		
		JSpinner kmSpinner = new JSpinner();
		kmSpinner.setModel(new SpinnerNumberModel(0, null, null,1));
		kmSpinner.setBounds(96, 1, 46, 19);
		distanciaTextPanel.add(kmSpinner);
		
		JLabel kmLabel = new JLabel("km");
		kmLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		kmLabel.setBounds(144, 3, 24, 14);
		distanciaTextPanel.add(kmLabel);
		
		JPanel duracionPanel = new JPanel();
		duracionPanel.setLayout(null);
		duracionPanel.setBounds(10, 166, 374, 21);
		variablesPanel.add(duracionPanel);
		
		JPanel duracionTextPanel = new JPanel();
		duracionTextPanel.setLayout(null);
		duracionTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		duracionTextPanel.setBackground(Color.WHITE);
		duracionTextPanel.setBounds(0, 0, 374, 21);
		duracionPanel.add(duracionTextPanel);
		
		JLabel duracionLabel = new JLabel("Duraci\u00F3n: ");
		duracionLabel.setBackground(new Color(255, 255, 153));
		duracionLabel.setBounds(10, 0, 92, 21);
		duracionTextPanel.add(duracionLabel);
		
		JSpinner hourSpinner = new JSpinner();
		hourSpinner.setBounds(62, 1, 40, 19);
		duracionTextPanel.add(hourSpinner);
		
		JLabel hoursLabel = new JLabel("hours");
		hoursLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		hoursLabel.setBounds(112, 3, 58, 14);
		duracionTextPanel.add(hoursLabel);
		
		JSpinner minutesSpinner = new JSpinner();
		minutesSpinner.setBounds(158, 1, 40, 19);
		duracionTextPanel.add(minutesSpinner);
		
		JLabel minutesLabel = new JLabel("minutes");
		minutesLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		minutesLabel.setBounds(208, 3, 58, 14);
		duracionTextPanel.add(minutesLabel);
		
		JSpinner secondsSpinner = new JSpinner();
		secondsSpinner.setBounds(266, 1, 40, 19);
		duracionTextPanel.add(secondsSpinner);
		
		JLabel secondsLabel = new JLabel("seconds");
		secondsLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		secondsLabel.setBounds(316, 4, 58, 14);
		duracionTextPanel.add(secondsLabel);
		
		JPanel fechaInicioPanel = new JPanel();
		fechaInicioPanel.setLayout(null);
		fechaInicioPanel.setBounds(10, 75, 114, 21);
		variablesPanel.add(fechaInicioPanel);
		
		JPanel fechaInicioTextPanel = new JPanel();
		fechaInicioTextPanel.setLayout(null);
		fechaInicioTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fechaInicioTextPanel.setBackground(Color.WHITE);
		fechaInicioTextPanel.setBounds(0, 0, 113, 21);
		fechaInicioPanel.add(fechaInicioTextPanel);
		
		JLabel fechaInicioLabel = new JLabel("Fecha inicio:");
		fechaInicioLabel.setBackground(new Color(255, 255, 153));
		fechaInicioLabel.setBounds(10, 0, 92, 21);
		fechaInicioTextPanel.add(fechaInicioLabel);
		
		JDateChooser fechaInicioCalendar = new JDateChooser();
		fechaInicioCalendar.setBounds(138, 76, 20, 21);
		variablesPanel.add(fechaInicioCalendar);
		
		JButton CrearEntrenamientoButton = new JButton("Crear Entrenamiento");
		CrearEntrenamientoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		CrearEntrenamientoButton.setBounds(133, 198, 170, 23);
		variablesPanel.add(CrearEntrenamientoButton);
		
		JPanel fechaFinPanel = new JPanel();
		fechaFinPanel.setLayout(null);
		fechaFinPanel.setBounds(236, 74, 114, 21);
		variablesPanel.add(fechaFinPanel);
		
		JPanel fechaFinTextPanel = new JPanel();
		fechaFinTextPanel.setLayout(null);
		fechaFinTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fechaFinTextPanel.setBackground(Color.WHITE);
		fechaFinTextPanel.setBounds(0, 0, 113, 21);
		fechaFinPanel.add(fechaFinTextPanel);
		
		JLabel fechaFinLabel = new JLabel("Fecha fin:");
		fechaFinLabel.setBackground(new Color(255, 255, 153));
		fechaFinLabel.setBounds(10, 0, 92, 21);
		fechaFinTextPanel.add(fechaFinLabel);
		
		JDateChooser fechaFinCalendar = new JDateChooser();
		fechaFinCalendar.setBounds(364, 75, 20, 21);
		variablesPanel.add(fechaFinCalendar);
		
		JRadioButton ciclismoRadioButton = new JRadioButton("Ciclismo");
		ciclismoRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ciclismoRadioButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ciclismoRadioButton.setBounds(138, 41, 109, 23);
		variablesPanel.add(ciclismoRadioButton);
		
		JRadioButton runningRadioButton = new JRadioButton("Running");
		runningRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		runningRadioButton.setBounds(275, 41, 109, 23);
		variablesPanel.add(runningRadioButton);
		
		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(349, 8, 118, 23);
		contentPanel.add(logOutButton);
		
		JButton backButton = new JButton("Volver");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 8, 118, 23);
		contentPanel.add(backButton);
		
		JLabel titleLabel = new JLabel("Crear reto");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		titleLabel.setBounds(138, 8, 146, 23);
		contentPanel.add(titleLabel);
	}
}
