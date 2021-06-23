package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tienda.Tienda;

public class ModificarLavadora extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JComboBox cboModelo;
	private JTextField textPrecio;
	private JTextField textAncho;
	private JTextField textAlto;
	private JTextField textFondo;
	private JTextField textCapacidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ModificarLavadora dialog = new ModificarLavadora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarLavadora() {
		setTitle("Modificar Lavadoras");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 29, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(335, 57, 89, 23);
		contentPanel.add(btnGrabar);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1", "WINIA WLA-195ECG", "LG TS1604NW"}));
		cboModelo.setBounds(107, 11, 167, 22);
		contentPanel.add(cboModelo);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(107, 44, 167, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		textAncho = new JTextField();
		textAncho.setBounds(107, 75, 167, 20);
		contentPanel.add(textAncho);
		textAncho.setColumns(10);
		
		textAlto = new JTextField();
		textAlto.setBounds(107, 106, 167, 20);
		contentPanel.add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setBounds(107, 137, 167, 20);
		contentPanel.add(textFondo);
		textFondo.setColumns(10);
		
		textCapacidad = new JTextField();
		textCapacidad.setBounds(107, 168, 167, 20);
		contentPanel.add(textCapacidad);
		textCapacidad.setColumns(10);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(23, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(23, 47, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho");
		lblNewLabel_2.setBounds(23, 78, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alto");
		lblNewLabel_3.setBounds(23, 109, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fondo");
		lblNewLabel_4.setBounds(23, 140, 56, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Capacidad");
		lblNewLabel_5.setBounds(23, 171, 74, 14);
		contentPanel.add(lblNewLabel_5);
	}
	
	/*
	 * Resolucion del problema
	 * */
	Tienda t = new Tienda();
	//Importar la consulta de lavadora
	ConsultarLavadora cl = new ConsultarLavadora();
	
	//Fin de la importacion
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	
	/*
	 * Mostrar Resultado
	 * */
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		///Mostrar en la pantalla
		BuscarModelo();
	}
	//Busqueda del Modelo
	int LeerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	void BuscarModelo() {
		int marca;
		double precio, fondo, ancho, alto, capacidad;
		
		marca = LeerModelo();
		precio = cl.BuscarPrecio(marca);
		fondo = cl.BuscarFondo(marca);
		ancho = cl.BuscarAncho(marca);
		alto = cl.BuscarAlto(marca);
		capacidad = cl.BuscarCapacidad(marca);
		
		Imprimir(precio, fondo, ancho, alto, capacidad);
		
	}
	
	
	void Imprimir(double precio, double fondo, double ancho, double alto, double capacidad) {
		textAlto.setText("" + alto);
		textAncho.setText("" + ancho);
		textCapacidad.setText("" + capacidad);
		textFondo.setText("" + fondo);
		textPrecio.setText("" + precio);
	}
	//Fin de mostrar resultado
	
	
	/*
	 * Boton Grabar
	 * */
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		//Boton de grabacion:
		ModificarLavadora();
	}
	//Leer alto
	double LeerAlto() {
		return Double.parseDouble(textAlto.getText());
	}
	//Leer precio
	double LeerPrecio() {
		return Double.parseDouble(textPrecio.getText());
	}
	//Leer fondo
	double LeerFondo() {
		return Double.parseDouble(textFondo.getText());
	}
	// Leer ancho
	double LeerAncho() {
		return Double.parseDouble(textAncho.getText());
	}
	// Leer capacidad
	double LeerCapacidad() {
		return Double.parseDouble(textCapacidad.getText());
	}
	
	//Modificar Lavadora
	void ModificarLavadora() {
		int marca;
		double precio, alto, fondo, ancho, capacidad;
		
		marca = LeerModelo();
		precio = LeerPrecio();
		ancho = LeerAncho();
		alto = LeerAlto();
		fondo = LeerFondo();
		capacidad = LeerCapacidad();
		
		ModificarPrecio(marca, precio);
		ModificarAncho(marca, ancho);
		ModificarAlto(marca, alto);
		ModificarFondo(marca, fondo);
		ModificarCapacidad(marca, capacidad);
		
	}
	
	double ModificarPrecio(int marca, double precio) {
		switch (marca) {
		case 0: return t.precio0 = precio;
		case 1: return t.precio1 = precio;
		case 2: return t.precio2 = precio;
		case 3: return t.precio3 = precio;
		case 4: return t.precio4 = precio;
		default: return 0;
		}
	}
	double ModificarAlto(int marca, double alto) {
		switch (marca) {
		case 0: return t.alto0 = alto;
		case 1: return t.alto1 = alto;
		case 2: return t.alto2 = alto;
		case 3: return t.alto3 = alto;
		case 4: return t.alto4 = alto;
		default: return 0;
		}
	}
	double ModificarFondo(int marca, double fondo) {
		switch (marca) {
		case 0: return t.fondo0 = fondo;
		case 1: return t.fondo1 = fondo;
		case 2: return t.fondo2 = fondo;
		case 3: return t.fondo3 = fondo;
		case 4: return t.fondo4 = fondo;
		default: return 0;
		}
	}
	
	double ModificarAncho(int marca, double ancho) {
		switch (marca) {
		case 0: return t.ancho0 = ancho;
		case 1: return t.ancho1 = ancho;
		case 2: return t.ancho2 = ancho;
		case 3: return t.ancho3 = ancho;
		case 4: return t.ancho4 = ancho;
		default: return 0;
		}
	}
	
	double ModificarCapacidad(int marca, double capacidad) {
		switch (marca) {
		case 0: return t.capacidad0 = capacidad;
		case 1: return t.capacidad1 = capacidad;
		case 2: return t.capacidad2 = capacidad;
		case 3: return t.capacidad3 = capacidad;
		case 4: return t.capacidad4 = capacidad;
		default: return 0;
		}
	}
	
}
