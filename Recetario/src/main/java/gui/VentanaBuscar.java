package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.UsuarioDAO;
import Domain.Receta;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaBuscar extends JFrame {

	private JPanel LayoutManager;
	private final JProgressBar progressBar = new JProgressBar();
	private JTable tableDatos;
	private JTextField tFBusqueda;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscar frame = new VentanaBuscar();
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
	public VentanaBuscar() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 476);
		LayoutManager = new JPanel();
		LayoutManager.setBackground(Color.WHITE);
		LayoutManager.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LayoutManager);
		LayoutManager.setLayout(null);
		
		
		JButton btnAbrir= new JButton("Abrir");
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD,15));
		btnAbrir.setBounds(154,394,109,23);
		LayoutManager.add(btnAbrir);
		
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
		}});
		
		JButton btnAtras = new JButton("Atras");
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAtras.setBounds(271, 394, 109, 23);
        LayoutManager.add(btnAtras);

        // Manejar el evento del boton "Atras"
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos de la interfaz
            	
            	PrimeraVentana primeraVentana= new PrimeraVentana();
            	primeraVentana.setVisible(true);
            }
        });
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(0, 0, 516, 57);
        LayoutManager.add(panel);
        
        JLabel lblNuevaReceta = new JLabel("RECETA");
        panel.add(lblNuevaReceta);
        lblNuevaReceta.setForeground(new Color(0, 0, 0));
        lblNuevaReceta.setBackground(new Color(192, 192, 192));
        lblNuevaReceta.setFont(new Font("Tahoma", Font.BOLD, 17));
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(36, 168, 470, 202);
        LayoutManager.add(scrollPane);
        
        tableDatos = new JTable();
        scrollPane.setViewportView(tableDatos);
        tableDatos.setFont(new Font("Tahoma", Font.PLAIN, 13));
        tableDatos.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Nombre", "Ingrediente principal", "Id "
        	}
        ));
        tableDatos.getColumnModel().getColumn(0).setPreferredWidth(89);
        tableDatos.getColumnModel().getColumn(1).setPreferredWidth(118);
        tableDatos.getColumnModel().getColumn(2).setPreferredWidth(47);
        
        JLabel lblBuscarPor = new JLabel("Buscar por: ");
        lblBuscarPor.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblBuscarPor.setBounds(36, 114, 81, 14);
        LayoutManager.add(lblBuscarPor);
        
        JComboBox cBFiltro = new JComboBox();
        cBFiltro.setModel(new DefaultComboBoxModel(new String[] {"Nombre ", "Ingrediente Principal", "Id"}));
        cBFiltro.setBounds(112, 111, 95, 22);
        LayoutManager.add(cBFiltro);
        
        tFBusqueda = new JTextField();
        tFBusqueda.setBounds(242, 112, 184, 20);
        LayoutManager.add(tFBusqueda);
        tFBusqueda.setColumns(10);
        
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(427, 111, 89, 23);
        LayoutManager.add(btnBuscar);
           
	}
}
