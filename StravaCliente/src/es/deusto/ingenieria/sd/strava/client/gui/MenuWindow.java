package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class MenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuWindow window = new MenuWindow();
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
	public MenuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("Button.shadow"));
		contentPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(47, 66, 206, 152);
		contentPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		JButton crearEntrenamientoButton = new JButton("Crear Entrenamiento");
		crearEntrenamientoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		crearEntrenamientoButton.setBounds(10, 11, 170, 23);
		buttonsPanel.add(crearEntrenamientoButton);
		
		JButton crearRetoButton = new JButton("Crear Reto");
		crearRetoButton.setBounds(10, 45, 170, 23);
		buttonsPanel.add(crearRetoButton);
		
		JButton buscarEntrenamientosButton = new JButton("Buscar Entrenamiento");
		buscarEntrenamientosButton.setBounds(10, 79, 170, 23);
		buttonsPanel.add(buscarEntrenamientosButton);
		
		JButton BuscarRetosButton = new JButton("Buscar Reto");
		BuscarRetosButton.setBounds(10, 113, 170, 23);
		buttonsPanel.add(BuscarRetosButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(287, 150, 137, 85);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.setBounds(10, 11, 118, 23);
		panel.add(logOutButton);
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton miCuentaButton = new JButton("Mi cuenta");
		miCuentaButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		miCuentaButton.setBounds(10, 45, 118, 23);
		panel.add(miCuentaButton);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(10, 11, 414, 34);
		contentPanel.add(titlePanel);
		titlePanel.setLayout(null);
		
		JLabel titleLabel = new JLabel("STRAVA");
		titleLabel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		titleLabel.setBounds(0, 0, 414, 34);
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(UIManager.getColor("CheckBox.focus"));
		titleLabel.setBackground(UIManager.getColor("CheckBox.light"));
		titleLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
