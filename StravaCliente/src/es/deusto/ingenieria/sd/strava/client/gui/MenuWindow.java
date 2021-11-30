package es.deusto.ingenieria.sd.strava.client.gui;

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
import javax.swing.border.BevelBorder;

public class MenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("Button.shadow"));
		contentPanel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		buttonsPanel.setBounds(126, 75, 206, 154);
		contentPanel.add(buttonsPanel);
		buttonsPanel.setLayout(null);

		JButton crearEntrenamientoButton = new JButton("Crear Entrenamiento");
		crearEntrenamientoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		crearEntrenamientoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						CrearEntrenamientoWindow cew = new CrearEntrenamientoWindow();
						CrearEntrenamientoWindow.NewScreen();

					}
				});
			}
		});
		crearEntrenamientoButton.setBounds(10, 11, 170, 23);
		buttonsPanel.add(crearEntrenamientoButton);

		JButton crearRetoButton = new JButton("Crear Reto");
		crearRetoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						CrearRetoWindow crw = new CrearRetoWindow();
						CrearRetoWindow.NewScreen();

					}
				});
			}
		});
		crearRetoButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		crearRetoButton.setBounds(10, 45, 170, 23);
		buttonsPanel.add(crearRetoButton);

		JButton buscarRetosButton = new JButton("Buscar Reto");
		buscarRetosButton.addActionListener(new ActionListener() {
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
		buscarRetosButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		buscarRetosButton.setBounds(10, 79, 170, 23);
		buttonsPanel.add(buscarRetosButton);

		JButton buscarEntrenamientosButton = new JButton("Buscar entrenamiento");
		buscarEntrenamientosButton.addActionListener(new ActionListener() {
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
		buscarEntrenamientosButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		buscarEntrenamientosButton.setBounds(10, 113, 170, 23);
		buttonsPanel.add(buscarEntrenamientosButton);

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

		JButton logOutButton = new JButton("Cerrar sesi\u00F3n");
		logOutButton.setBounds(296, 0, 118, 23);
		titlePanel.add(logOutButton);
		logOutButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		logOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						//logOut
						frame.setVisible(false);
						InitializationWindow iw = new InitializationWindow();
						InitializationWindow.NewScreen();

					}
				});

			}
		});
	}
}
