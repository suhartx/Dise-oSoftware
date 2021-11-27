package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RetoWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		//if selectedItem is not finished = panelAceptarRetoIsHidden
		//if selectedItem it's not started = panelEstadoIsHidden
		//if selectedItem it's finished = panelAceptarReto & panelEstadoIsHidden
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RetoWindow window = new RetoWindow();
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
	public RetoWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 482, 315);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 477, 391);
		frame.getContentPane().add(contentPanel);

		JPanel retoListPanel = new JPanel();
		retoListPanel.setLayout(null);
		retoListPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		retoListPanel.setBounds(10, 45, 457, 235);
		contentPanel.add(retoListPanel);

		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 437, 205);
		retoListPanel.add(variablesPanel);

		JPanel reto1Panel = new JPanel();
		reto1Panel.setBounds(10, 11, 407, 177);
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
		nombreLabel.setBounds(90, 3, 274, 14);
		nombreTextPanel.add(nombreLabel);

		JPanel fechasPanel = new JPanel();
		fechasPanel.setLayout(null);
		fechasPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		fechasPanel.setBackground(Color.WHITE);
		fechasPanel.setBounds(10, 56, 387, 21);
		reto1Panel.add(fechasPanel);

		JLabel fechaInicioTextLabel = new JLabel("Fecha inicio:");
		fechaInicioTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaInicioTextLabel.setBackground(new Color(255, 255, 153));
		fechaInicioTextLabel.setBounds(10, 0, 78, 21);
		fechasPanel.add(fechaInicioTextLabel);

		JLabel fechaInicioLabel = new JLabel("fechaInicio(fromDB)");
		fechaInicioLabel.setBounds(90, 3, 98, 14);
		fechasPanel.add(fechaInicioLabel);

		JLabel fechaFinalTextLabel = new JLabel("Fecha final: ");
		fechaFinalTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaFinalTextLabel.setBackground(new Color(255, 255, 153));
		fechaFinalTextLabel.setBounds(198, 0, 70, 21);
		fechasPanel.add(fechaFinalTextLabel);

		JLabel fechaFinalLabel = new JLabel("fechaFin(fromDB)");
		fechaFinalLabel.setBounds(291, 3, 86, 14);
		fechasPanel.add(fechaFinalLabel);

		JPanel distanciaPanel = new JPanel();
		distanciaPanel.setLayout(null);
		distanciaPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		distanciaPanel.setBackground(Color.WHITE);
		distanciaPanel.setBounds(10, 88, 191, 21);
		reto1Panel.add(distanciaPanel);

		JLabel distanciaTextLabel = new JLabel("Distancia:");
		distanciaTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel.setBackground(new Color(255, 255, 153));
		distanciaTextLabel.setBounds(10, 0, 67, 21);
		distanciaPanel.add(distanciaTextLabel);

		JLabel distanciaLabel = new JLabel("Distancia(from DB)");
		distanciaLabel.setBounds(90, 3, 91, 14);
		distanciaPanel.add(distanciaLabel);

		JPanel tiempoPanel = new JPanel();
		tiempoPanel.setLayout(null);
		tiempoPanel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		tiempoPanel.setBackground(Color.WHITE);
		tiempoPanel.setBounds(206, 88, 191, 21);
		reto1Panel.add(tiempoPanel);

		JLabel tiempoTextLabel = new JLabel("Tiempo:");
		tiempoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempoTextLabel.setBackground(new Color(255, 255, 153));
		tiempoTextLabel.setBounds(10, 0, 67, 21);
		tiempoPanel.add(tiempoTextLabel);

		JLabel tiempoLabel = new JLabel("Tiempo(from DB)");
		tiempoLabel.setBounds(90, 3, 91, 14);
		tiempoPanel.add(tiempoLabel);

		// Crea un reto y te salta una alerta de que se ha aceptado el reto.
		// Cuando cierras esa alerta te lleva a menu principal
		JButton empezarRetoButton = new JButton("Aceptar reto");
		empezarRetoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//reto aceptado
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						//alerta
						frame.setVisible(false);
						MenuWindow mw = new MenuWindow();
						mw.NewScreen();
						
					}
				});
			}
		});
		empezarRetoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		empezarRetoButton.setBounds(279, 135, 118, 23);
		reto1Panel.add(empezarRetoButton);
		
		JPanel estadoPanel = new JPanel();//Wether what reto is seleceted is visible or not
		estadoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		estadoPanel.setBackground(Color.WHITE);
		estadoPanel.setBounds(10, 135, 191, 23);
		reto1Panel.add(estadoPanel);
		estadoPanel.setLayout(null);
		
		JLabel estadoTextLabel = new JLabel("Estado:");
		estadoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		estadoTextLabel.setBackground(new Color(255, 255, 153));
		estadoTextLabel.setBounds(10, 0, 67, 21);
		estadoPanel.add(estadoTextLabel);
		
		JLabel estadoLabel = new JLabel("%Estado(fromDB)");
		estadoLabel.setBounds(87, 3, 104, 14);
		estadoPanel.add(estadoLabel);

		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						//logout
						frame.setVisible(false);
						InitializationWindow iw = new InitializationWindow();
						iw.NewScreen();
						
					}
				});
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(349, 11, 118, 23);
		contentPanel.add(logOutButton);

		JButton backButton = new JButton("Volver");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						frame.setVisible(false);
						BuscarRetosWindow brw = new BuscarRetosWindow();
						brw.NewScreen();
						
					}
				});
			}
		});
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 11, 118, 23);
		contentPanel.add(backButton);

		JLabel titleLabel = new JLabel("Reto");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}