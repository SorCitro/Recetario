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

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class VentanaCrear extends JFrame {

	private JPanel LayoutManager;
    private JTextField tFNombreReceta;
    private JTextArea tAIngredientes;
    private JTextArea tADescripcion;
    private JTextArea tAIngredientePrincipal;
	private final JProgressBar progressBar = new JProgressBar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCrear frame = new VentanaCrear();
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
	public VentanaCrear() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 476);
		LayoutManager = new JPanel();
		LayoutManager.setBackground(Color.WHITE);
		LayoutManager.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LayoutManager);
		LayoutManager.setLayout(null);
		
		JLabel lblNom = new JLabel("Nombre de la receta:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBackground(Color.WHITE);
		lblNom.setBounds(33, 68, 151, 25);
		LayoutManager.add(lblNom);
		
		JLabel lblNuevaReceta = new JLabel("NUEVA RECETA");
		lblNuevaReceta.setForeground(new Color(0, 0, 0));
		lblNuevaReceta.setBackground(new Color(192, 192, 192));
		lblNuevaReceta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNuevaReceta.setBounds(152, 11, 141, 25);
		LayoutManager.add(lblNuevaReceta);
		
		tFNombreReceta = new JTextField();
		tFNombreReceta.setBorder(new LineBorder(new Color(171, 173, 179)));
		tFNombreReceta.setBounds(179, 70, 243, 22);
		LayoutManager.add(tFNombreReceta);
		
		JLabel lblIngredientes = new JLabel("Ingredientes:");
		lblIngredientes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIngredientes.setBackground(Color.WHITE);
		lblIngredientes.setBounds(33, 114, 151, 25);
		LayoutManager.add(lblIngredientes);
		
		tAIngredientes = new JTextArea();
		tAIngredientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		tAIngredientes.setBounds(179, 116, 243, 22);
		LayoutManager.add(tAIngredientes);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcion.setBackground(Color.WHITE);
		lblDescripcion.setBounds(33, 203, 151, 25);
		LayoutManager.add(lblDescripcion);
		
		JButton btnGuardarReceta = new JButton("Guardar");
        btnGuardarReceta.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnGuardarReceta.setBounds(179, 405, 109, 23);
        LayoutManager.add(btnGuardarReceta);

        // Manejar el evento del bot�n "Guardar"
        btnGuardarReceta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos de la interfaz
            
                String nombreReceta = tFNombreReceta.getText();
                String ingredientes = tAIngredientes.getText();
                String descripcion = tADescripcion.getText();
                String ingredientePrincipal = tAIngredientePrincipal.getText();

                // Crear una instancia de Receta con los datos ingresados
                Receta nuevaReceta = new Receta( descripcion, descripcion, descripcion, ingredientePrincipal);
                nuevaReceta.setNombre(nombreReceta);
                nuevaReceta.setIngredientes(ingredientes);
                nuevaReceta.setDescripcion(descripcion);
                nuevaReceta.setIngredientePrincipal(ingredientePrincipal);
                
                // Llamar al metodo para insertar la receta en la base de datos
                UsuarioDAO usuarioDAO = new UsuarioDAO(null);
                int registrosInsertados = usuarioDAO.insertarReceta(nuevaReceta);

                if (registrosInsertados > 0) {
                    // La receta se insert� correctamente en la base de datos
                    System.out.println("Receta guardada con Exito.");
                    // Puedes mostrar un mensaje de �xito o realizar alguna acci�n adicional
                } else {
                    // Ocurre un error al insertar la receta
                    System.out.println("Error al guardar la receta.");
                    // Puedes mostrar un mensaje de error o realizar alguna acci�n de manejo de errores
                }
            }
        });
                
		tADescripcion = new JTextArea();
		tADescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		tADescripcion.setBounds(179, 175, 243, 153);
		LayoutManager.add(tADescripcion);
		
		JScrollPane scrollPane = new JScrollPane(tADescripcion);
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(179, 204, 243, 153);
        LayoutManager.add(scrollPane);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setBounds(0, 0, 460, 57);
        LayoutManager.add(panel);
        
        JButton btnAtras = new JButton("X");
        btnAtras.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        	}
        });
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAtras.setBounds(417, 406, 43, 33);
        LayoutManager.add(btnAtras);
        progressBar.setBounds(0, 406, 95, 41);
        LayoutManager.add(progressBar);
        
        JLabel lblIngredientePrincipal = new JLabel("Ingrediente principal:");
        lblIngredientePrincipal.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblIngredientePrincipal.setBackground(Color.WHITE);
        lblIngredientePrincipal.setBounds(33, 162, 151, 25);
        LayoutManager.add(lblIngredientePrincipal);
        
        tAIngredientePrincipal = new JTextArea();
        tAIngredientePrincipal.setBorder(new LineBorder(new Color(0, 0, 0)));
        tAIngredientePrincipal.setBounds(179, 162, 243, 22);
        LayoutManager.add(tAIngredientePrincipal);
		
	
	}
}
