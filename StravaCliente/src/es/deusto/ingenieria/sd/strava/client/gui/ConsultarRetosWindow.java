package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ConsultarRetosWindow {

	private JFrame frame;
	private JLabel distanciaLabel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRetosWindow window = new ConsultarRetosWindow();
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
	public ConsultarRetosWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 429);
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
		reto1Panel.setLayout(null);
		reto1Panel.setBounds(10, 11, 407, 130);
		variablesPanel.add(reto1Panel);
		
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
		
		JPanel estadoPanel = new JPanel();
		estadoPanel.setLayout(null);
		estadoPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		estadoPanel.setBackground(Color.WHITE);
		estadoPanel.setBounds(78, 102, 191, 21);
		reto1Panel.add(estadoPanel);
		
		JLabel estadoTextLabel = new JLabel("Estado: ");
		estadoTextLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		estadoTextLabel.setBackground(new Color(255, 255, 153));
		estadoTextLabel.setBounds(10, 0, 67, 21);
		estadoPanel.add(estadoTextLabel);
		
		JLabel estadoLabel = new JLabel("Estado(from DB)");
		estadoLabel.setBounds(90, 3, 91, 14);
		estadoPanel.add(estadoLabel);
		
		JPanel reto2Panel = new JPanel();
		reto2Panel.setLayout(null);
		reto2Panel.setBounds(10, 152, 407, 130);
		variablesPanel.add(reto2Panel);
		
		JPanel nombreTextPanel2 = new JPanel();
		nombreTextPanel2.setLayout(null);
		nombreTextPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		nombreTextPanel2.setBackground(Color.WHITE);
		nombreTextPanel2.setBounds(10, 11, 387, 21);
		reto2Panel.add(nombreTextPanel2);
		
		JLabel nombreTextLabel2 = new JLabel("Nombre:");
		nombreTextLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreTextLabel2.setBackground(new Color(255, 255, 153));
		nombreTextLabel2.setBounds(10, 0, 67, 21);
		nombreTextPanel2.add(nombreTextLabel2);
		
		JLabel nombreLabel2 = new JLabel("Nombre reto(from DB)");
		nombreLabel2.setBounds(90, 3, 274, 14);
		nombreTextPanel2.add(nombreLabel2);
		
		JPanel fechasPanel2 = new JPanel();
		fechasPanel2.setLayout(null);
		fechasPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		fechasPanel2.setBackground(Color.WHITE);
		fechasPanel2.setBounds(10, 43, 387, 21);
		reto2Panel.add(fechasPanel2);
		
		JLabel fechaInicioTextLabel2 = new JLabel("Fecha inicio:");
		fechaInicioTextLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaInicioTextLabel2.setBackground(new Color(255, 255, 153));
		fechaInicioTextLabel2.setBounds(10, 0, 78, 21);
		fechasPanel2.add(fechaInicioTextLabel2);
		
		JLabel fechaInicioLabel2 = new JLabel("fechaInicio(fromDB)");
		fechaInicioLabel2.setBounds(90, 3, 98, 14);
		fechasPanel2.add(fechaInicioLabel2);
		
		JLabel fechaFinalTextLabel2 = new JLabel("Fecha final: ");
		fechaFinalTextLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaFinalTextLabel2.setBackground(new Color(255, 255, 153));
		fechaFinalTextLabel2.setBounds(198, 0, 70, 21);
		fechasPanel2.add(fechaFinalTextLabel2);
		
		JLabel fechaFinalLabel2 = new JLabel("fechaFin(fromDB)");
		fechaFinalLabel2.setBounds(291, 3, 86, 14);
		fechasPanel2.add(fechaFinalLabel2);
		
		JPanel distanciaPanel2 = new JPanel();
		distanciaPanel2.setLayout(null);
		distanciaPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		distanciaPanel2.setBackground(Color.WHITE);
		distanciaPanel2.setBounds(10, 75, 191, 21);
		reto2Panel.add(distanciaPanel2);
		
		JLabel distanciaTextLabel2 = new JLabel("Nombre:");
		distanciaTextLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		distanciaTextLabel2.setBackground(new Color(255, 255, 153));
		distanciaTextLabel2.setBounds(10, 0, 67, 21);
		distanciaPanel2.add(distanciaTextLabel2);
		
		distanciaLabel2 = new JLabel("Distancia(from DB)");
		distanciaLabel2.setBounds(90, 3, 91, 14);
		distanciaPanel2.add(distanciaLabel2);
		
		JPanel tiempoPanel2 = new JPanel();
		tiempoPanel2.setLayout(null);
		tiempoPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		tiempoPanel2.setBackground(Color.WHITE);
		tiempoPanel2.setBounds(206, 75, 191, 21);
		reto2Panel.add(tiempoPanel2);
		
		JLabel tiempoTextLabel2 = new JLabel("Nombre:");
		tiempoTextLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
		tiempoTextLabel2.setBackground(new Color(255, 255, 153));
		tiempoTextLabel2.setBounds(10, 0, 67, 21);
		tiempoPanel2.add(tiempoTextLabel2);
		
		JLabel tiempoLabel2 = new JLabel("Tiempo(from DB)");
		tiempoLabel2.setBounds(90, 3, 91, 14);
		tiempoPanel2.add(tiempoLabel2);
		
		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.setBounds(349, 11, 118, 23);
		contentPanel.add(logOutButton);
		
		JButton backButton = new JButton("Volver");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		backButton.setBounds(10, 11, 118, 23);
		contentPanel.add(backButton);
		
		JLabel titleLabel = new JLabel("Retos");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}

}
