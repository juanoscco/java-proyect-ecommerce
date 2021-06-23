package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tienda.Tienda;

public class ConsultarLavadora extends JDialog implements ActionListener {
	private JButton btnCerrar;
	private JTextField textAncho;
	private JTextField textPrecio;
	private JComboBox cboModelo;
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
			ConsultarLavadora dialog = new ConsultarLavadora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarLavadora() {
		setTitle("Consultar Lavadora");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(314, 25, 89, 23);
		getContentPane().add(btnCerrar);
		
		textAncho = new JTextField();
		textAncho.setEditable(false);
		textAncho.setBounds(102, 88, 190, 20);
		getContentPane().add(textAncho);
		textAncho.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setBounds(102, 57, 190, 20);
		getContentPane().add(textPrecio);
		textPrecio.setColumns(10);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1", "WINIA WLA-195ECG", "LG TS1604NW"}));
		cboModelo.setBounds(102, 25, 190, 22);
		getContentPane().add(cboModelo);
		
		textAlto = new JTextField();
		textAlto.setEditable(false);
		textAlto.setBounds(102, 119, 190, 20);
		getContentPane().add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setEditable(false);
		textFondo.setBounds(102, 150, 190, 20);
		getContentPane().add(textFondo);
		textFondo.setColumns(10);
		
		textCapacidad = new JTextField();
		textCapacidad.setEditable(false);
		textCapacidad.setBounds(102, 181, 190, 20);
		getContentPane().add(textCapacidad);
		textCapacidad.setColumns(10);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(21, 29, 46, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(21, 60, 58, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho (cm)");
		lblNewLabel_2.setBounds(21, 91, 71, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alto (cm)");
		lblNewLabel_3.setBounds(21, 122, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fondo (cm)");
		lblNewLabel_4.setBounds(21, 153, 71, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Capacidad");
		lblNewLabel_5.setBounds(21, 184, 71, 14);
		getContentPane().add(lblNewLabel_5);
	}
	
	//Para seleccionar los productos
	
	
	//Trayendo tienda
	Tienda t = new Tienda();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		BuscarPorModelo();
	}
	
	/*
	 * Imprimir los Resultados
	 * */
	
	int LeerModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	//Encontrar el precio
	public double BuscarPrecio(int marca) {
		switch (marca) {
		case 0: return t.precio0;
		case 1: return t.precio1;
		case 2: return t.precio2;
		case 3: return t.precio3;
		case 4: return t.precio4;
		default: return 0;
		}
	}
	
	//Encontrar el fondo
	double BuscarFondo(int marca) {
		switch (marca) {
		case 0: return t.fondo0;
		case 1: return t.fondo1;
		case 2: return t.fondo2;
		case 3: return t.fondo3;
		case 4: return t.fondo4;
		default: return 0;
		}
	}
	
	
	//Encontrar el ancho
	double BuscarAncho(int marca) {
		switch (marca) {
		case 0: return t.ancho0;
		case 1: return t.ancho1;
		case 2: return t.ancho2;
		case 3: return t.ancho3;
		case 4: return t.ancho4;
		default:return 0;
		}
	}
	
	//Encontrar el alto
	double BuscarAlto(int marca) {
		switch (marca) {
		case 0: return t.alto0;
		case 1: return t.alto1;
		case 2: return t.alto2;
		case 3: return t.alto3;
		case 4: return t.alto4;
		default: return 0;
		}
	}
	//Encontrar la capadidad
	double BuscarCapacidad(int marca) {
		switch (marca) {
		case 0: return t.capacidad0;
		case 1: return t.capacidad1;
		case 2: return t.capacidad2;
		case 3: return t.capacidad3;
		case 4: return t.capacidad4;
		default: return 0;
		}
	}
	
	// Imprimir todo
	void BuscarPorModelo() {
		int marca;
		double precio, fondo, ancho, alto, capacidad;
		
		marca = LeerModelo();
		precio = BuscarPrecio(marca);
		fondo = BuscarFondo(marca);
		ancho = BuscarAncho(marca);
		alto = BuscarAlto(marca);
		capacidad = BuscarCapacidad(marca);
		
		imprimir(precio, fondo, ancho, alto, capacidad);
	}
	
	//Textuar
	void imprimir(double precio, double fondo, double ancho, double alto, double capacidad) {
		textAlto.setText("" + alto);
		textAncho.setText("" + ancho);
		textCapacidad.setText("" + capacidad);
		textFondo.setText("" + fondo);
		textPrecio.setText("" + precio);
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
