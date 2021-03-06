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
import es.deusto.ingenieria.sd.strava.server.data.dto.RetoDTO;

public class BuscarRetosWindow {

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

		JPanel retoListPanel = new JPanel();
		retoListPanel.setBackground(Color.WHITE);
		retoListPanel.setBounds(10, 11, 437, 305);
		variablesPanel.add(retoListPanel);
		retoListPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 106, 272, 174);
		retoListPanel.add(scrollPane);


		DefaultListModel<String> retosNombres = new DefaultListModel();
		List<RetoDTO> retos = MainProgram.getInstance().getRetoController().getRetos();

		JList retosList = new JList();
		
		String [] opciones = {"Todos los retos", "Retos activos", "Retos no aceptados"};
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(opciones));
		retosList.setModel(retosNombres);
		for (RetoDTO reto : retos) {
			retosNombres.addElement(reto.getNombre());
		}
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox comboBox = (JComboBox) e.getSource();
				
				Object selected = comboBox.getSelectedItem();
				retosNombres.removeAllElements();
				if (selected.toString().equals("Todos los retos")) {
					for (RetoDTO reto : retos) {
						retosNombres.addElement(reto.getNombre());
					}
				}else if (selected.toString().equals("Retos activos")) {
					for (RetoDTO reto : retos) {
						if (reto.getPorcentaje() != 0){
							retosNombres.addElement(reto.getNombre());
						}
					}
				}else {
					for (RetoDTO reto : retos) {
						if (reto.getPorcentaje() == 0){
							retosNombres.addElement(reto.getNombre());
						}
					}
				}
				
			}
		});

		retosList.setModel(retosNombres);
		comboBox.setBounds(26, 54, 119, 22);
		retoListPanel.add(comboBox);
		JButton searchBarButton = new JButton("Buscar");
		searchBarButton.addActionListener(e->{
			final String searchText = searchBarText.getText().toLowerCase();
			 retosNombres.removeAllElements();
			 for (RetoDTO reto: retos) {
				 if (reto.getNombre().contains(searchText)) {
					 retosNombres.addElement(reto.getNombre());
				 }
			 }
			 if (searchText.isEmpty() || searchText.isBlank()) {
				 retosNombres.removeAllElements();
				 for (RetoDTO reto: retos) {
					 retosNombres.addElement(reto.getNombre());
				 }
			 }
		});
		
		
		retosList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						frame.setVisible(false);
						//select reto
						String selectedRetoName = retosList.getSelectedValue().toString();
						for (RetoDTO reto: retos) {
							if (reto.getNombre() == selectedRetoName){
								System.out.println(reto.toString());
								
								RetoWindow.NewScreen(reto);
							}
						}


					}
				});

			}
		});
		scrollPane.setViewportView(retosList);

		JPanel searchBarPanel = new JPanel();
		searchBarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchBarPanel.setBounds(26, 11, 302, 30);
		retoListPanel.add(searchBarPanel);
		searchBarPanel.setLayout(null);

		searchBarText = new JTextField();
		searchBarText.setText("buscar reto...");
		searchBarText.setToolTipText("");
		searchBarText.setBounds(0, 0, 204, 30);
		searchBarPanel.add(searchBarText);
		searchBarText.setColumns(10);


//		searchBarButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				searchBarText.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyReleased(KeyEvent e) {
//					    JTextField textField = (JTextField) e.getSource();
//		                //obtiene contenido del textfield
//		                String text = textField.getText();
//		                if (text.trim().length() > 0) {
//		                    //nuevo Model temporal
//		                    DefaultListModel<String> tmp = new DefaultListModel();
//		                    for (int i = 0; i < retosNombres.getSize(); i++) {//recorre Model original
//		                        //si encuentra coincidencias agrega a model temporal
//		                        if (retosNombres.getElementAt(i).toLowerCase().contains(text.toLowerCase())) {
//		                            tmp.addElement(retosNombres.getElementAt(i));
//		                        }
//		                    }
//		                    //agrega nuevo modelo a JList
//		                    retosList.setModel(tmp);
//		                } else {//si esta vacio muestra el Model original
//		                	retosList.setModel(retosNombres);
//		                }
//		            }
//				});
//			}
//		});
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

		JLabel titleLabel = new JLabel("Retos");
		titleLabel.setForeground(Color.DARK_GRAY);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(161, 15, 162, 19);
		contentPanel.add(titleLabel);
	}
}
