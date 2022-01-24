package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import es.deusto.ingenieria.sd.strava.client.MainProgram;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;

public class EntrenamientoWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(EntrenamientoDTO entrenamiento) {
		//if selectedItem is not finished = panelAceptarRetoIsHidden
		//if selectedItem it's not started = panelEstadoIsHidden
		//if selectedItem it's finished = panelAceptarReto & panelEstadoIsHidden
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EntrenamientoWindow window = new EntrenamientoWindow(entrenamiento);
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
	public EntrenamientoWindow(EntrenamientoDTO entrenamiento) {
		initialize(entrenamiento);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(EntrenamientoDTO entrenamiento) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 582, 321);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 576, 292);
		frame.getContentPane().add(contentPanel);

		JPanel retoListPanel = new JPanel();
		retoListPanel.setLayout(null);
		retoListPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		retoListPanel.setBounds(10, 45, 556, 236);
		contentPanel.add(retoListPanel);

		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 536, 214);
		retoListPanel.add(variablesPanel);

		JPanel reto1Panel = new JPanel();
		reto1Panel.setBounds(10, 11, 516, 192);
		variablesPanel.add(reto1Panel);
		reto1Panel.setLayout(null);

		JPanel nombreTextPanel = new JPanel();
		nombreTextPanel.setLayout(null);
		nombreTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		nombreTextPanel.setBackground(Color.WHITE);
		nombreTextPanel.setBounds(10, 11, 496, 21);
		reto1Panel.add(nombreTextPanel);

		JLabel nombreTextLabel = new JLabel("Nombre:");
		nombreTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreTextLabel.setBackground(new Color(255, 255, 153));
		nombreTextLabel.setBounds(10, 0, 67, 21);
		nombreTextPanel.add(nombreTextLabel);

		JLabel nombreLabel = new JLabel("Nombre reto(from DB)");
		nombreLabel.setText(entrenamiento.getTitulo());
		nombreLabel.setBounds(90, 3, 396, 14);
		nombreTextPanel.add(nombreLabel);

		JPanel fechasPanel = new JPanel();
		fechasPanel.setLayout(null);
		fechasPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		fechasPanel.setBackground(Color.WHITE);
		fechasPanel.setBounds(10, 84, 496, 21);
		reto1Panel.add(fechasPanel);

		JLabel fechaInicioTextLabel = new JLabel("Fecha inicio:");
		fechaInicioTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaInicioTextLabel.setBackground(new Color(255, 255, 153));
		fechaInicioTextLabel.setBounds(10, 0, 78, 21);
		fechasPanel.add(fechaInicioTextLabel);

		JLabel fechaInicioLabel = new JLabel("fechaInicio(fromDB)");
		fechaInicioLabel.setText(entrenamiento.getFechaInicio().toString());
		fechaInicioLabel.setBounds(90, 3, 159, 14);
		fechasPanel.add(fechaInicioLabel);

		JLabel horaInicioTextLabel = new JLabel("Hora Inicio:");
		horaInicioTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		horaInicioTextLabel.setBackground(new Color(255, 255, 153));
		horaInicioTextLabel.setBounds(290, 0, 70, 21);
		fechasPanel.add(horaInicioTextLabel);

		JLabel horaInicioLabel = new JLabel("fechaFin(fromDB)");
		horaInicioLabel.setText(entrenamiento.getHoraInicio());
		horaInicioLabel.setBounds(370, 3, 116, 14);
		fechasPanel.add(horaInicioLabel);

		JPanel distanciaPanel = new JPanel();
		distanciaPanel.setLayout(null);
		distanciaPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		distanciaPanel.setBackground(Color.WHITE);
		distanciaPanel.setBounds(10, 127, 224, 21);
		reto1Panel.add(distanciaPanel);

		JLabel distanciaTextLabel = new JLabel("Distancia:");
		distanciaTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel.setBackground(new Color(255, 255, 153));
		distanciaTextLabel.setBounds(10, 0, 67, 21);
		distanciaPanel.add(distanciaTextLabel);

		JLabel distanciaLabel = new JLabel("Distancia(from DB)");
		distanciaLabel.setText(Double.toString(entrenamiento.getDistancia()));
		distanciaLabel.setBounds(123, 3, 91, 14);
		distanciaPanel.add(distanciaLabel);

		JPanel tiempoPanel = new JPanel();
		tiempoPanel.setLayout(null);
		tiempoPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		tiempoPanel.setBackground(Color.WHITE);
		tiempoPanel.setBounds(294, 127, 212, 21);
		reto1Panel.add(tiempoPanel);

		JLabel tiempoTextLabel = new JLabel("Tiempo:");
		tiempoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempoTextLabel.setBackground(new Color(255, 255, 153));
		tiempoTextLabel.setBounds(13, 0, 67, 21);
		tiempoPanel.add(tiempoTextLabel);

		JLabel tiempoLabel = new JLabel("Tiempo(from DB)");
		tiempoLabel.setText(Double.toString(entrenamiento.getDuracion()) + "minutes");
		tiempoLabel.setBounds(90, 3, 91, 14);
		tiempoPanel.add(tiempoLabel);

		JPanel tipoDeportePanel = new JPanel();
		tipoDeportePanel.setLayout(null);
		tipoDeportePanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		tipoDeportePanel.setBackground(Color.WHITE);
		tipoDeportePanel.setBounds(10, 43, 496, 21);
		reto1Panel.add(tipoDeportePanel);

		JLabel tipoDeporteTextLabel = new JLabel("Deporte:");
		tipoDeporteTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tipoDeporteTextLabel.setBackground(new Color(255, 255, 153));
		tipoDeporteTextLabel.setBounds(10, 0, 67, 21);
		tipoDeportePanel.add(tipoDeporteTextLabel);

		JLabel tipoDeporteLabel = new JLabel("Deporte(fromDB)");
		tipoDeporteLabel.setText(entrenamiento.getTipoDeporte());
		tipoDeporteLabel.setBounds(90, 3, 396, 14);
		tipoDeportePanel.add(tipoDeporteLabel);

		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
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
		logOutButton.setBounds(448, 11, 118, 23);
		contentPanel.add(logOutButton);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						BuscarEntrenamientosWindow bew = new BuscarEntrenamientosWindow();
						BuscarEntrenamientosWindow.NewScreen();

					}
				});
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 11, 118, 23);
		contentPanel.add(backButton);

		JLabel titleLabel = new JLabel("Entrenamiento");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(226, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}