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
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class BuscarRetosWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarRetosWindow window = new BuscarRetosWindow();
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
	public BuscarRetosWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 482, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 477, 391);
		frame.getContentPane().add(contentPanel);
		
		JPanel retoListPanel = new JPanel();
		retoListPanel.setLayout(null);
		retoListPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		retoListPanel.setBounds(10, 45, 457, 327);
		contentPanel.add(retoListPanel);
		
		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		variablesPanel.setBackground(Color.WHITE);
		variablesPanel.setBounds(10, 11, 437, 303);
		retoListPanel.add(variablesPanel);
		
		JPanel reto1Panel = new JPanel();
		reto1Panel.setBounds(10, 11, 407, 130);
		variablesPanel.add(reto1Panel);
		reto1Panel.setLayout(null);
		
		JPanel nombreTextPanel = new JPanel();
		nombreTextPanel.setLayout(null);
		nombreTextPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreTextPanel.setBackground(Color.WHITE);
		nombreTextPanel.setBounds(10, 11, 387, 21);
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
		fechasPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fechasPanel.setBackground(Color.WHITE);
		fechasPanel.setBounds(10, 43, 387, 21);
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
		distanciaPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		distanciaPanel.setBackground(Color.WHITE);
		distanciaPanel.setBounds(10, 75, 191, 21);
		reto1Panel.add(distanciaPanel);
		
		JLabel distanciaTextLabel = new JLabel("Nombre:");
		distanciaTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel.setBackground(new Color(255, 255, 153));
		distanciaTextLabel.setBounds(10, 0, 67, 21);
		distanciaPanel.add(distanciaTextLabel);
		
		JLabel distanciaLabel = new JLabel("Distancia(from DB)");
		distanciaLabel.setBounds(90, 3, 91, 14);
		distanciaPanel.add(distanciaLabel);
		
		JPanel tiempoPanel = new JPanel();
		tiempoPanel.setLayout(null);
		tiempoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tiempoPanel.setBackground(Color.WHITE);
		tiempoPanel.setBounds(206, 75, 191, 21);
		reto1Panel.add(tiempoPanel);
		
		JLabel tiempoTextLabel = new JLabel("Nombre:");
		tiempoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempoTextLabel.setBackground(new Color(255, 255, 153));
		tiempoTextLabel.setBounds(10, 0, 67, 21);
		tiempoPanel.add(tiempoTextLabel);
		
		JLabel tiempoLabel = new JLabel("Tiempo(from DB)");
		tiempoLabel.setBounds(90, 3, 91, 14);
		tiempoPanel.add(tiempoLabel);
		
		//Crea un reto y te salta una alerta de que se ha aceptado el reto.
		//Cuando cierras esa alerta te lleva a menu principal
		JButton empezarRetoButton = new JButton("Aceptar reto");
		empezarRetoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		empezarRetoButton.setBounds(279, 102, 118, 23);
		reto1Panel.add(empezarRetoButton);
		
		JPanel reto1Panel_1 = new JPanel();
		reto1Panel_1.setLayout(null);
		reto1Panel_1.setBounds(10, 152, 407, 130);
		variablesPanel.add(reto1Panel_1);
		
		JPanel nombreTextPanel_1 = new JPanel();
		nombreTextPanel_1.setLayout(null);
		nombreTextPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreTextPanel_1.setBackground(Color.WHITE);
		nombreTextPanel_1.setBounds(10, 11, 387, 21);
		reto1Panel_1.add(nombreTextPanel_1);
		
		JLabel nombreTextLabel_1 = new JLabel("Nombre:");
		nombreTextLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreTextLabel_1.setBackground(new Color(255, 255, 153));
		nombreTextLabel_1.setBounds(10, 0, 67, 21);
		nombreTextPanel_1.add(nombreTextLabel_1);
		
		JLabel nombreLabel_1 = new JLabel("Nombre reto(from DB)");
		nombreLabel_1.setBounds(90, 3, 274, 14);
		nombreTextPanel_1.add(nombreLabel_1);
		
		JPanel fechasPanel_1 = new JPanel();
		fechasPanel_1.setLayout(null);
		fechasPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fechasPanel_1.setBackground(Color.WHITE);
		fechasPanel_1.setBounds(10, 43, 387, 21);
		reto1Panel_1.add(fechasPanel_1);
		
		JLabel fechaInicioTextLabel_1 = new JLabel("Fecha inicio:");
		fechaInicioTextLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaInicioTextLabel_1.setBackground(new Color(255, 255, 153));
		fechaInicioTextLabel_1.setBounds(10, 0, 78, 21);
		fechasPanel_1.add(fechaInicioTextLabel_1);
		
		JLabel fechaInicioLabel_1 = new JLabel("fechaInicio(fromDB)");
		fechaInicioLabel_1.setBounds(90, 3, 98, 14);
		fechasPanel_1.add(fechaInicioLabel_1);
		
		JLabel fechaFinalTextLabel_1 = new JLabel("Fecha final: ");
		fechaFinalTextLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaFinalTextLabel_1.setBackground(new Color(255, 255, 153));
		fechaFinalTextLabel_1.setBounds(198, 0, 70, 21);
		fechasPanel_1.add(fechaFinalTextLabel_1);
		
		JLabel fechaFinalLabel_1 = new JLabel("fechaFin(fromDB)");
		fechaFinalLabel_1.setBounds(291, 3, 86, 14);
		fechasPanel_1.add(fechaFinalLabel_1);
		
		JPanel distanciaPanel_1 = new JPanel();
		distanciaPanel_1.setLayout(null);
		distanciaPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		distanciaPanel_1.setBackground(Color.WHITE);
		distanciaPanel_1.setBounds(10, 75, 191, 21);
		reto1Panel_1.add(distanciaPanel_1);
		
		JLabel distanciaTextLabel_1 = new JLabel("Nombre:");
		distanciaTextLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel_1.setBackground(new Color(255, 255, 153));
		distanciaTextLabel_1.setBounds(10, 0, 67, 21);
		distanciaPanel_1.add(distanciaTextLabel_1);
		
		JLabel distanciaLabel_1 = new JLabel("Distancia(from DB)");
		distanciaLabel_1.setBounds(90, 3, 91, 14);
		distanciaPanel_1.add(distanciaLabel_1);
		
		JPanel tiempoPanel_1 = new JPanel();
		tiempoPanel_1.setLayout(null);
		tiempoPanel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tiempoPanel_1.setBackground(Color.WHITE);
		tiempoPanel_1.setBounds(206, 75, 191, 21);
		reto1Panel_1.add(tiempoPanel_1);
		
		JLabel tiempoTextLabel_1 = new JLabel("Nombre:");
		tiempoTextLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempoTextLabel_1.setBackground(new Color(255, 255, 153));
		tiempoTextLabel_1.setBounds(10, 0, 67, 21);
		tiempoPanel_1.add(tiempoTextLabel_1);
		
		JLabel tiempoLabel_1 = new JLabel("Tiempo(from DB)");
		tiempoLabel_1.setBounds(90, 3, 91, 14);
		tiempoPanel_1.add(tiempoLabel_1);
		
		JButton empezarRetoButton_1 = new JButton("Aceptar reto");
		empezarRetoButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		empezarRetoButton_1.setBounds(279, 102, 118, 23);
		reto1Panel_1.add(empezarRetoButton_1);
		
		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(349, 11, 118, 23);
		contentPanel.add(logOutButton);
		
		JButton backButton = new JButton("Volver");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 11, 118, 23);
		contentPanel.add(backButton);
		
		JLabel titleLabel = new JLabel("Retos");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}
