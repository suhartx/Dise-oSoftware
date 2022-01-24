package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import es.deusto.ingenieria.sd.strava.client.MainProgram;

public class CrearRetoWindow {

	private JFrame frame;
	private JTextField nombreTextField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frame.setBounds(100, 100, 493, 376);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 477, 337);
		frame.getContentPane().add(contentPanel);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(10, 42, 457, 284);
		contentPanel.add(buttonsPanel);

		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 437, 262);
		buttonsPanel.add(variablesPanel);

		JPanel nombrePanel = new JPanel();
		nombrePanel.setLayout(null);
		nombrePanel.setBounds(10, 11, 374, 21);
		variablesPanel.add(nombrePanel);

		JPanel nombreTextPanel = new JPanel();
		nombreTextPanel.setLayout(null);
		nombreTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
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
		deporteTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		deporteTextPanel.setBackground(Color.WHITE);
		deporteTextPanel.setBounds(0, 0, 113, 21);
		deportePanel.add(deporteTextPanel);

		JLabel deporteLabel = new JLabel("Deporte:");
		deporteLabel.setBackground(new Color(255, 255, 153));
		deporteLabel.setBounds(10, 0, 92, 21);
		deporteTextPanel.add(deporteLabel);

		JPanel distanciaPanel = new JPanel();
		distanciaPanel.setLayout(null);
		distanciaPanel.setBounds(116, 164, 170, 21);
		variablesPanel.add(distanciaPanel);

		JPanel distanciaTextPanel = new JPanel();
		distanciaTextPanel.setLayout(null);
		distanciaTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		distanciaTextPanel.setBackground(Color.WHITE);
		distanciaTextPanel.setBounds(0, 0, 170, 21);
		distanciaPanel.add(distanciaTextPanel);

		JLabel distanciaLabel = new JLabel("Distancia: ");
		distanciaLabel.setBackground(new Color(255, 255, 153));
		distanciaLabel.setBounds(10, 0, 92, 21);
		distanciaTextPanel.add(distanciaLabel);

		JSpinner kmSpinner = new JSpinner();
		kmSpinner.setModel(new SpinnerNumberModel(0, null, null, 1));
		kmSpinner.setBounds(96, 1, 46, 19);
		distanciaTextPanel.add(kmSpinner);

		JLabel kmLabel = new JLabel("km");
		kmLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		kmLabel.setBounds(144, 3, 24, 14);
		distanciaTextPanel.add(kmLabel);

		JPanel fechaInicioPanel = new JPanel();
		fechaInicioPanel.setLayout(null);
		fechaInicioPanel.setBounds(10, 75, 114, 29);
		variablesPanel.add(fechaInicioPanel);

		JPanel fechaInicioTextPanel = new JPanel();
		fechaInicioTextPanel.setLayout(null);
		fechaInicioTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		fechaInicioTextPanel.setBackground(Color.WHITE);
		fechaInicioTextPanel.setBounds(0, 0, 113, 29);
		fechaInicioPanel.add(fechaInicioTextPanel);

		JLabel fechaInicioLabel = new JLabel("Fecha inicio:");
		fechaInicioLabel.setBackground(new Color(255, 255, 153));
		fechaInicioLabel.setBounds(10, 0, 92, 29);
		fechaInicioTextPanel.add(fechaInicioLabel);




		JPanel fechaFinPanel = new JPanel();
		fechaFinPanel.setLayout(null);
		fechaFinPanel.setBounds(10, 115, 114, 29);
		variablesPanel.add(fechaFinPanel);

		JPanel fechaFinTextPanel = new JPanel();
		fechaFinTextPanel.setLayout(null);
		fechaFinTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		fechaFinTextPanel.setBackground(Color.WHITE);
		fechaFinTextPanel.setBounds(0, 0, 113, 28);
		fechaFinPanel.add(fechaFinTextPanel);

		JLabel fechaFinLabel = new JLabel("Fecha fin:");
		fechaFinLabel.setBackground(new Color(255, 255, 153));
		fechaFinLabel.setBounds(10, 0, 92, 28);
		fechaFinTextPanel.add(fechaFinLabel);

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



		JPanel duracionTextPanel = new JPanel();
		duracionTextPanel.setBounds(44, 196, 374, 21);
		variablesPanel.add(duracionTextPanel);
		duracionTextPanel.setLayout(null);
		duracionTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		duracionTextPanel.setBackground(Color.WHITE);

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

		JPanel duracionPanel = new JPanel();
		duracionPanel.setLayout(null);
		duracionPanel.setBounds(44, 196, 374, 21);
		variablesPanel.add(duracionPanel);

		JPanel enterFechaInicioTextPanel = new JPanel();
		enterFechaInicioTextPanel.setLayout(null);
		enterFechaInicioTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterFechaInicioTextPanel.setBackground(Color.WHITE);
		enterFechaInicioTextPanel.setBounds(139, 75, 245, 29);
		variablesPanel.add(enterFechaInicioTextPanel);

		JYearChooser yearChooserSpinnerInicio = new JYearChooser();
		yearChooserSpinnerInicio.setBounds(187, 4, 48, 20);
		enterFechaInicioTextPanel.add(yearChooserSpinnerInicio);

		JMonthChooser monthChooserSpinnerInicio = new JMonthChooser();
		monthChooserSpinnerInicio.setBounds(65, 4, 100, 20);
		enterFechaInicioTextPanel.add(monthChooserSpinnerInicio);

		JSpinner dayChooserSpinnerInicio = new JSpinner();
		dayChooserSpinnerInicio.setBounds(10, 4, 30, 20);
		enterFechaInicioTextPanel.add(dayChooserSpinnerInicio);




		JPanel enterFechaFinTextPanel = new JPanel();
		enterFechaFinTextPanel.setLayout(null);
		enterFechaFinTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		enterFechaFinTextPanel.setBackground(Color.WHITE);
		enterFechaFinTextPanel.setBounds(139, 115, 245, 28);
		variablesPanel.add(enterFechaFinTextPanel);

		JYearChooser yearChooserSpinnerFin = new JYearChooser();
		yearChooserSpinnerFin.setBounds(187, 4, 48, 20);
		enterFechaFinTextPanel.add(yearChooserSpinnerFin);

		JMonthChooser monthChooserSpinnerFin = new JMonthChooser();
		monthChooserSpinnerFin.setBounds(65, 4, 100, 20);
		enterFechaFinTextPanel.add(monthChooserSpinnerFin);

		JSpinner dayChooserSpinnerFin = new JSpinner();
		dayChooserSpinnerFin.setBounds(10, 4, 30, 20);
		enterFechaFinTextPanel.add(dayChooserSpinnerFin);


		int yearInicio = yearChooserSpinnerInicio.getYear();
		int monthInicio = monthChooserSpinnerInicio.getMonth();
		int dayInicio = (Integer)dayChooserSpinnerInicio.getValue();
		
		int yearFin = yearChooserSpinnerFin.getYear();
		int monthFin = monthChooserSpinnerFin.getMonth();
		int dayFin = (Integer)dayChooserSpinnerFin.getValue();
		
		String str1 = Integer.toString(dayFin) + " " + Integer.toString(monthFin) + " " + Integer.toString(yearFin);
		

		JButton CrearRetoButton = new JButton("Crear Reto");


		String str = Integer.toString(dayInicio) + " " + Integer.toString(monthInicio) + " " + Integer.toString(yearInicio);
		SimpleDateFormat df = new SimpleDateFormat("MM dd yyyy");

		CrearRetoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						//alerta reto creado
						String deporte = null;
						if (ciclismoRadioButton.isSelected()||runningRadioButton.isSelected()) {
							if (ciclismoRadioButton.isSelected()) {
								deporte = "ciclismo";


							}else{
								deporte = "running";
							}
							Long tiempo= 0l;
							long tiempo1= 0l;
							try {
								tiempo = df.parse(str).getTime();
								tiempo1 = df.parse(str1).getTime();
								
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							double i = (int) kmSpinner.getValue();
							MainProgram.getInstance().getRetoController().crearReto(MainProgram.getInstance().getLoginController().getToken(), nombreTextField.getText(), new Date(tiempo), new Date(tiempo1), i, deporte);

							frame.setVisible(false);
							BuscarRetosWindow brw = new BuscarRetosWindow();
							BuscarRetosWindow.NewScreen();


						}else {
							JOptionPane.showMessageDialog(frame,
									"ERROR: Introduce un deporte.");

						}


					}
				});
			}
		});
		CrearRetoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		CrearRetoButton.setBounds(138, 228, 170, 23);
		variablesPanel.add(CrearRetoButton);

		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						//logout
						MainProgram.getInstance().getLoginController().logout();
						frame.setVisible(false);
						InitializationWindow iw = new InitializationWindow();
						InitializationWindow.NewScreen();

					}
				});
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(349, 8, 118, 23);
		contentPanel.add(logOutButton);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						MenuWindow mw = new MenuWindow();
						MenuWindow.NewScreen();

					}
				});
			}
		});
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