package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import tienda.Tienda;
import mantenimiento.ConsultarLavadora;
import mantenimiento.ModificarLavadora;

public class Vender extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JButton btnVender;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox cboModelo;
	private JTextField textPrecio;
	private JTextField textCantidad;
	private JTextArea txtS;
	private JScrollPane scrollPane;

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
			Vender dialog = new Vender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vender() {
		setTitle("Vender");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(314, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(314, 34, 89, 23);
		contentPanel.add(btnVender);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(22, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(22, 38, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(22, 63, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"WHIRLPOOL WWI16BSBLA", "SAMSUNG WA17T6260BW", "MABE LMA72200WDBB1", "WINIA WLA-195ECG", "LG TS1604NW"}));
		cboModelo.setBounds(99, 11, 189, 22);
		contentPanel.add(cboModelo);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setBounds(99, 35, 189, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(99, 60, 189, 20);
		contentPanel.add(textCantidad);
		textCantidad.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 88, 381, 162);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	/*
	 * Solucion a vender
	 * */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
	}
	protected void actionPerformedBtnVender(ActionEvent e) {
		//boton procesar
		VenderProducto();
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedComboBox(ActionEvent e) {
		MostrarPrecio();
	}
	
	//Formato Decimal
	DecimalFormat df = new DecimalFormat("0.00");
	
	/*
	 * Combo box de Precio del modelo
	 * */
	ConsultarLavadora cl = new ConsultarLavadora();
	
	//Leer Modelo
	int LeerModelo() {
		return cboModelo.getSelectedIndex();
	}
	//Leer Precio
	double LeerPrecio() {
		return Double.parseDouble(textPrecio.getText());
	}
	//Leer Cantidad
	int LeerCantidad() {
		return Integer.parseInt(textCantidad.getText());
	}
	/*
	 * Mostrar el precio
	 * */
	void MostrarPrecio() {
		int marca;
		double precio;
		marca = LeerModelo();
		precio = cl.BuscarPrecio(marca);
		textPrecio.setText("" + precio);
	}
	
	//Boton vender
	void VenderProducto() {
		int marca, cantidad;
		double importeDescuento, importePago, importeCompra, precio;
		String obsequio, modelo;
		
		marca = LeerModelo();
		precio = LeerPrecio();
		cantidad = LeerCantidad();
		modelo = EncontrarModelo(marca);
		importeCompra = CalcularELImporteDeCompra(precio, cantidad);
		importeDescuento = CalculoDeImporteDescuento(cantidad, importeCompra);
		importePago = CalcularElImporteDePago(importeCompra, importeDescuento);
		obsequio = AsignarObsequio(cantidad);
		MostrarResultados(modelo, precio, cantidad, importeCompra, importeDescuento, importeCompra, obsequio);
		
		CajaDeDialogo(importePago);
		switch (marca) {
		case 0:
			Tienda.cantidadDeVentas0++;
			Tienda.unidadesVendidas0+=cantidad;
			Tienda.importeTotalVendido0+=importePago;
			break;
		case 1:
			Tienda.cantidadDeVentas1++;
			Tienda.unidadesVendidas1+=cantidad;
			Tienda.importeTotalVendido1+=importePago;
			break;
		case 2:
			Tienda.cantidadDeVentas2++;
			Tienda.unidadesVendidas2+=cantidad;
			Tienda.importeTotalVendido2+=importePago;
			break;
		case 3:
			Tienda.cantidadDeVentas3++;
			Tienda.unidadesVendidas3+=cantidad;
			Tienda.importeTotalVendido3+=importePago;
			break;
		default:
			Tienda.cantidadDeVentas4++;
			Tienda.unidadesVendidas4+=cantidad;
			Tienda.importeTotalVendido4+=importePago;
			break;
		}
		
	}
	/*
	 * Operaciones
	 * */
	//Encontrar marca
	String EncontrarModelo(int marca) {
		switch (marca) {
		case 0: return Tienda.modelo0;
		case 1: return Tienda.modelo1;
		case 2: return Tienda.modelo2;
		case 3: return Tienda.modelo3;
		default: return Tienda.modelo4;
		}
	}
	//Calcular el importe de compra
	double CalcularELImporteDeCompra(double precio, int cantidad){
		return precio * cantidad;
	}
	//Asignando un obsequio
	String AsignarObsequio(int cantidad) {
		if (cantidad == 1) return Tienda.obsequio1;
		else if (cantidad >= 2 && cantidad <= 5) return Tienda.obsequio2;
		else return Tienda.obsequio3;
	}

	//Calcular el importe de Descuento
	double CalculoDeImporteDescuento(int cantidad, double importeCompra) {
		if (cantidad >= 1 && cantidad <= 5) return (importeCompra * Tienda.porcentaje1)/100;
		else if (cantidad >= 6 && cantidad <= 10) return (importeCompra * Tienda.porcentaje2)/100;
		else if (cantidad >= 11 && cantidad <= 15) return (importeCompra * Tienda.porcentaje3)/100;
		else return (importeCompra * Tienda.porcentaje4)/100;
	}
	
	//Calcular el importe a pagar
	double CalcularElImporteDePago(double importeCompra, double importeDescuento) {
		return importeCompra - importeDescuento;
	}
	
	/*
	 * Fin de operaciones
	 * */
	
	//Mostrar Resultados
	void MostrarResultados( String modelo, double precio, int cantidad, double importeCompra, double importeDescuento, double importPago, String obsequio) {
		imprimir("=================================");
		imprimir("Modelo			:" + modelo);
		imprimir("Precio			:" + precio);
		imprimir("Cantidad		:" + cantidad);
		imprimir("Importe de compra	:" + df.format(importeCompra));
		imprimir("Importe de descuento	:"+ df.format(importeDescuento));
		imprimir("Importe a pagar		:" + df.format(importPago));
		imprimir("Obsequio		:"  + obsequio);
		imprimir("=================================");
	}
	
	
	//Anuncio
	void CajaDeDialogo(double importePago) {
		Tienda.ventasAcumuladas+= importePago;
		double porcentajeCuotaDiaria = 0;
		porcentajeCuotaDiaria = (Tienda.ventasAcumuladas*100)/Tienda.cuotaDiaria;
		Tienda.numeroDeVenta++;
		if(Tienda.numeroDeVenta % 5 == 0) {
			JOptionPane.showMessageDialog(null, "Nr. " + Tienda.numeroDeVenta + "\n" 
																+ "Importe total general acumulado: S/." + df.format(Tienda.ventasAcumuladas)
																+ "\n" + "Porcentaje de cuota diaria: " + df.format(porcentajeCuotaDiaria) 
																+ "%");
		}
	}
	
	void imprimir(String s) {
		txtS.append (s + "\n");
	}
}
