package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.UsuarioDAO;
import Domain.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class PrimeraVentana extends JFrame {

	private JPanel LayoutManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeraVentana frame = new PrimeraVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeraVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		LayoutManager = new JPanel();
		LayoutManager.setBackground(Color.WHITE);
		LayoutManager.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LayoutManager);
		LayoutManager.setLayout(null);
		
		JButton btnC = new JButton("Crear");
		btnC.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cuando se hace clic en el bot�n "Crear", crea y muestra la segunda ventana
            	VentanaCrear ventanaCrear = new VentanaCrear();
                ventanaCrear.setVisible(true);
            }
        });
        btnC.setBounds(156, 90, 89, 23);
        LayoutManager.add(btnC);
		
		JButton btnR = new JButton("Buscar");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			VentanaBuscar ventanaBuscar = new VentanaBuscar();	
			ventanaBuscar.setVisible(true);
			}
		});
		btnR.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnR.setBounds(156, 124, 89, 23);
		LayoutManager.add(btnR);
		

		JButton btnU = new JButton("Modificar");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaModificar ventanaModificar = new VentanaModificar();
				ventanaModificar.setVisible(true);
			}
		});
		btnU.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnU.setBounds(156, 158, 89, 23);
		LayoutManager.add(btnU);
		
		
		
		
		JButton btnD = new JButton("Eliminar");
		btnD.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnD.setBounds(156, 192, 89, 23);
		LayoutManager.add(btnD);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 436, 57);
		LayoutManager.add(panel);
	}
}
