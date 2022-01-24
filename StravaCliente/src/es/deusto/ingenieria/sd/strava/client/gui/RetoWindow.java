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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import es.deusto.ingenieria.sd.strava.client.MainProgram;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

public class RetoWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen(RetoDTO reto) {
		//if selectedItem is not finished = panelAceptarRetoIsHidden
		//if selectedItem it's not started = panelEstadoIsHidden
		//if selectedItem it's finished = panelAceptarReto & panelEstadoIsHidden
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RetoWindow window = new RetoWindow(reto);
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
	public RetoWindow(RetoDTO reto) {
		initialize(reto);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(RetoDTO reto) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 541, 388);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 535, 359);
		frame.getContentPane().add(contentPanel);

		JPanel retoListPanel = new JPanel();
		retoListPanel.setLayout(null);
		retoListPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		retoListPanel.setBounds(10, 45, 515, 303);
		contentPanel.add(retoListPanel);

		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 495, 281);
		retoListPanel.add(variablesPanel);

		JPanel reto1Panel = new JPanel();
		reto1Panel.setBounds(10, 11, 475, 259);
		variablesPanel.add(reto1Panel);
		reto1Panel.setLayout(null);

		JPanel nombreTextPanel = new JPanel();
		nombreTextPanel.setLayout(null);
		nombreTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		nombreTextPanel.setBackground(Color.WHITE);
		nombreTextPanel.setBounds(10, 24, 387, 21);
		reto1Panel.add(nombreTextPanel);

		JLabel nombreTextLabel = new JLabel("Nombre:");
		nombreTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreTextLabel.setBackground(new Color(255, 255, 153));
		nombreTextLabel.setBounds(10, 0, 67, 21);
		nombreTextPanel.add(nombreTextLabel);

		JLabel nombreLabel = new JLabel("Nombre reto(from DB)");
		nombreLabel.setText(reto.getNombre());
		nombreLabel.setBounds(90, 3, 274, 14);
		nombreTextPanel.add(nombreLabel);

		JPanel fechasPanel = new JPanel();
		fechasPanel.setLayout(null);
		fechasPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		fechasPanel.setBackground(Color.WHITE);
		fechasPanel.setBounds(10, 56, 440, 71);
		reto1Panel.add(fechasPanel);

		JLabel fechaInicioTextLabel = new JLabel("Fecha inicio:");
		fechaInicioTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaInicioTextLabel.setBackground(new Color(255, 255, 153));
		fechaInicioTextLabel.setBounds(10, 4, 78, 21);
		fechasPanel.add(fechaInicioTextLabel);

		JLabel fechaFinalTextLabel = new JLabel("Fecha final: ");
		fechaFinalTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaFinalTextLabel.setBackground(new Color(255, 255, 153));
		fechaFinalTextLabel.setBounds(10, 32, 70, 21);
		fechasPanel.add(fechaFinalTextLabel);
		
		JPanel fechaFinLabel = new JPanel();
		fechaFinLabel.setBounds(90, 32, 340, 21);
		fechasPanel.add(fechaFinLabel);
				fechaFinLabel.setLayout(null);
		
				JLabel fechaFinalLabel = new JLabel("fechaFin(fromDB)");
				fechaFinalLabel.setBounds(0, 0, 340, 19);
				fechaFinLabel.add(fechaFinalLabel);
				fechaFinalLabel.setText(reto.getFechaFin().toString());
				
				JPanel panel = new JPanel();
				panel.setBounds(90, 4, 340, 21);
				fechasPanel.add(panel);
				panel.setLayout(null);
				
						JLabel fechaInicioLabel = new JLabel("fechaInicio(fromDB)");
						fechaInicioLabel.setBounds(0, 0, 337, 21);
						panel.add(fechaInicioLabel);
						fechaInicioLabel.setBackground(Color.LIGHT_GRAY);
						fechaInicioLabel.setText(reto.getFechaInicio().toString());

		JPanel distanciaPanel = new JPanel();
		
		distanciaPanel.setLayout(null);
		distanciaPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		distanciaPanel.setBackground(Color.WHITE);
		distanciaPanel.setBounds(10, 150, 191, 21);
		reto1Panel.add(distanciaPanel);

		JLabel distanciaTextLabel = new JLabel("Distancia:");
		distanciaTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel.setBackground(new Color(255, 255, 153));
		distanciaTextLabel.setBounds(10, 0, 67, 21);
		distanciaPanel.add(distanciaTextLabel);

		JLabel distanciaLabel = new JLabel("Distancia(from DB)");
		distanciaLabel.setText(Double.toString(reto.getDistancia()));
		distanciaLabel.setBounds(90, 3, 91, 14);
		distanciaPanel.add(distanciaLabel);

		JPanel tipoDeportePanel = new JPanel();
		tipoDeportePanel.setLayout(null);
		tipoDeportePanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		tipoDeportePanel.setBackground(Color.WHITE);
		tipoDeportePanel.setBounds(259, 150, 191, 21);
		reto1Panel.add(tipoDeportePanel);

		JLabel tipoDeporteTextLabel = new JLabel("Deporte:");
		tipoDeporteTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tipoDeporteTextLabel.setBackground(new Color(255, 255, 153));
		tipoDeporteTextLabel.setBounds(10, 0, 67, 21);
		tipoDeportePanel.add(tipoDeporteTextLabel);

		JLabel tipoDeporteLabel = new JLabel("Tiempo(from DB)");
		tipoDeporteLabel.setText(reto.getTipoDeporte());
		tipoDeporteLabel.setBounds(90, 3, 91, 14);
		tipoDeportePanel.add(tipoDeporteLabel);



		JPanel estadoPanel = new JPanel();//Wether what reto is seleceted is visible or not
		estadoPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		estadoPanel.setBackground(Color.WHITE);
		estadoPanel.setBounds(10, 191, 191, 23);
		reto1Panel.add(estadoPanel);
		estadoPanel.setLayout(null);

		JLabel estadoTextLabel = new JLabel("Estado:");
		estadoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		estadoTextLabel.setBackground(new Color(255, 255, 153));
		estadoTextLabel.setBounds(10, 0, 67, 21);
		estadoPanel.add(estadoTextLabel);

		JLabel estadoLabel = new JLabel("%Estado(fromDB)");
		estadoLabel.setText(Integer.toString(reto.getPorcentaje()));
		estadoLabel.setBounds(87, 3, 104, 14);
		estadoPanel.add(estadoLabel);

		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						//logout
						MainProgram.getInstance().getLoginController().logout();
						frame.setVisible(true);
						InitializationWindow iw = new InitializationWindow();
						InitializationWindow.NewScreen();

					}
				});
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(388, 11, 118, 23);
		contentPanel.add(logOutButton);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						BuscarRetosWindow brw = new BuscarRetosWindow();
						BuscarRetosWindow.NewScreen();

					}
				});
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(22, 11, 118, 23);
		contentPanel.add(backButton);
		
		// Crea un reto y te salta una alerta de que se ha aceptado el reto.
		// Cuando cierras esa alerta te lleva a menu principal
		JButton empezarRetoButton = new JButton("Aceptar reto");
		if (reto.getPorcentaje() != 0){
			empezarRetoButton.setVisible(false);
		}else {
			empezarRetoButton.setVisible(true);
		}
		empezarRetoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {//reto aceptado
				JOptionPane.showMessageDialog(frame,
						"Reto Aceptado!");
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						frame.setVisible(false);
						//alerta
						long token = MainProgram.getInstance().getLoginController().getToken();
						MainProgram.getInstance().getRetoController().aceptarReto(token, reto.getIdReto());
						

						MenuWindow mw = new MenuWindow();
						MenuWindow.NewScreen();

					}
				});
			}
		});
		empezarRetoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		empezarRetoButton.setBounds(190, 225, 118, 23);
		reto1Panel.add(empezarRetoButton);

		JLabel titleLabel = new JLabel("Reto");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}