package es.deusto.ingenieria.sd.strava.client.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.deusto.ingenieria.sd.strava.client.MainProgram;
import es.deusto.ingenieria.sd.strava.server.data.dto.EntrenamientoDTO;
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

public class BuscarEntrenamientosWindow {

	private JFrame frame;
	private JTextField searchBarText;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BuscarEntrenamientosWindow window = new BuscarEntrenamientosWindow();
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
	public BuscarEntrenamientosWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 482, 418);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.setBackground(SystemColor.controlShadow);
		contentPanel.setBounds(0, 0, 477, 391);
		frame.getContentPane().add(contentPanel);

		JPanel variablesPanel = new JPanel();
		variablesPanel.setLayout(null);
		variablesPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		variablesPanel.setBounds(10, 45, 457, 327);
		contentPanel.add(variablesPanel);

		JPanel entrenamientoListPanel = new JPanel();
		entrenamientoListPanel.setBackground(Color.WHITE);
		entrenamientoListPanel.setBounds(10, 11, 437, 305);
		variablesPanel.add(entrenamientoListPanel);
		entrenamientoListPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 106, 272, 174);
		entrenamientoListPanel.add(scrollPane);


		DefaultListModel<String> entrenamientosNombres = new DefaultListModel();
		List<EntrenamientoDTO> entrenamientos = MainProgram.getInstance().getEntrenamientoController().getEntrenamientos();
		JList entrenamientosList = new JList();
		entrenamientosList.setModel(entrenamientosNombres);
		for (EntrenamientoDTO entrenamiento : entrenamientos) {
			entrenamientosNombres.addElement(entrenamiento.getTitulo());
		}
		
		
		

		scrollPane.setViewportView(entrenamientosList);

		JPanel searchBarPanel = new JPanel();
		searchBarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchBarPanel.setBounds(26, 11, 302, 30);
		entrenamientoListPanel.add(searchBarPanel);
		searchBarPanel.setLayout(null);

		searchBarText = new JTextField();
		searchBarText.setText("buscar entrenamiento...");
		searchBarText.setToolTipText("");
		searchBarText.setBounds(0, 0, 204, 30);
		searchBarPanel.add(searchBarText);
		searchBarText.setColumns(10);

		JButton searchBarButton = new JButton("Buscar");
		searchBarButton.addActionListener(e->{
			final String searchText = searchBarText.getText().toLowerCase();
			 entrenamientosNombres.removeAllElements();
			 for (EntrenamientoDTO entrenamiento: entrenamientos) {
				 if (entrenamiento.getTitulo().contains(searchText)) {
					 entrenamientosNombres.addElement(entrenamiento.getTitulo());
				 }
			 }
			 if (searchText.isEmpty() || searchText.isBlank()) {
				 entrenamientosNombres.removeAllElements();
				 for (EntrenamientoDTO entrenamiento: entrenamientos) {
					 entrenamientosNombres.addElement(entrenamiento.getTitulo());
				 }
			 }
		});
		searchBarButton.setBounds(207, 4, 89, 23);
		searchBarPanel.add(searchBarButton);



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
		logOutButton.setBounds(349, 11, 118, 23);
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
		backButton.setBounds(10, 11, 118, 23);
		contentPanel.add(backButton);
		entrenamientosList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						String selectedEntrenamientoName = entrenamientosList.getSelectedValue().toString();
						for (EntrenamientoDTO entrenamiento: entrenamientos) {
							if (entrenamiento.getTitulo() == selectedEntrenamientoName) {
								EntrenamientoWindow.NewScreen(entrenamiento);
							}
						}
					}
				});


			}
		});

		JLabel titleLabel = new JLabel("Entrenamientos");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}
