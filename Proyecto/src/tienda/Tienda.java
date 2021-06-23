package tienda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ayuda.Ayuda;
import configuracion.ConfigurarCantidadOptima;
import configuracion.ConfigurarCuotaDiaria;
import configuracion.ConfigurarDescuentos;
import configuracion.ConfigurarObsequios;
import mantenimiento.ConsultarLavadora;
import mantenimiento.ListarLavadoras;
import mantenimiento.ModificarLavadora;
import ventas.GenerarReportes;
import ventas.Vender;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Tienda extends JFrame implements ActionListener {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
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
	public Tienda() {
		setTitle("Mi Tienda de Lavadoras 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 384);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setHorizontalAlignment(SwingConstants.RIGHT);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarLavadora = new JMenuItem("Consultar Lavadora");
		mntmConsultarLavadora.addActionListener(this);
		mnMantenimiento.add(mntmConsultarLavadora);
		
		mntmMdificarLavadora = new JMenuItem("Modificar Lavadora");
		mntmMdificarLavadora.addActionListener(this);
		mnMantenimiento.add(mntmMdificarLavadora);
		
		mntmListarLavadoras = new JMenuItem("Listar Lavadoras");
		mntmListarLavadoras.addActionListener(this);
		mnMantenimiento.add(mntmListarLavadoras);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracion = new JMenu("Configuracion");
		menuBar.add(mnConfiguracion);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar Cantidad Optima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracion.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcerca = new JMenuItem("Acerca de Tienda");
		mntmAcerca.addActionListener(this);
		mnAyuda.add(mntmAcerca);
		getContentPane().setLayout(null);
	}
	/*
	 * Datos de lavadora
	 * */
	// Datos mínimos de la primera lavadora
	public static String modelo0 = "WHIRLPOOL WWI16BSBLA";
	public static double precio0 = 999.0;
	public static double fondo0 = 67.0;
	public static double ancho0 = 64.0;
	public static double alto0 = 105.0;
	public static double capacidad0 = 16;
	// Datos mínimos de la segunda lavadora
	public static String modelo1 = "SAMSUNG WA17T6260BW";
	public static double precio1 = 1199.0;
	public static double ancho1 = 63.0;
	public static double alto1 = 108.0;
	public static double fondo1 = 69.0;
	public static double capacidad1 = 17;
	// Datos mínimos de la tercera lavadora
	public static String modelo2 = "MABE LMA72200WDBB1";
	public static double precio2 = 1599.0;
	public static double ancho2 = 68.0;
	public static double alto2 = 109.0;
	public static double fondo2 = 68.0;
	public static double capacidad2 = 22;
	// Datos mínimos de la cuarta lavadora
	public static String modelo3 = "WINIA WLA-195ECG";
	public static double precio3 = 899.0;
	public static double ancho3 = 52.5;
	public static double alto3 = 85.5;
	public static double fondo3 = 53.5;
	public static double capacidad3 = 6.5;
	// Datos mínimos de la quinta lavadora
	public static String modelo4 = "LG TS1604NW";
	public static double precio4 = 1099.0;
	public static double ancho4 = 63.2;
	public static double alto4 = 102.0;
	public static double fondo4 = 67;
	public static double capacidad4 = 17;
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	// Obsequios
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	// Cantidad óptima de unidades vendidas
	public static int cantidadOptima = 10;
	// Cuota diaria
	public static double cuotaDiaria = 30000;
	//Fin de los datos del problema planteado
	
	/*
	 * Variables
	 * */
	//Ventana de Vender
	public static int numeroDeVenta = 0;
	public static double ventasAcumuladas = 0;

	//Cantidad de ventas realizadas
	public static int cantidadDeVentas0 = 0;
	public static int cantidadDeVentas1 = 0;
	public static int cantidadDeVentas2 = 0;
	public static int cantidadDeVentas3 = 0;
	public static int cantidadDeVentas4 = 0;
	
	//Cantidad de unidades vendidas
	public static int unidadesVendidas0 = 0;
	public static int unidadesVendidas1 = 0;
	public static int unidadesVendidas2 = 0;
	public static int unidadesVendidas3 = 0;
	public static int unidadesVendidas4 = 0;
	
	//Importe total vendidos
	public static double importeTotalVendido0 = 0;
	public static double importeTotalVendido1 = 0;
	public static double importeTotalVendido2 = 0;
	public static double importeTotalVendido3 = 0;
	public static double importeTotalVendido4 = 0;
	
	/*
	 * 
	 * Fin de los datos
	 * 
	 * */
	
	/*
	 * Datos del Programa
	 * */
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultarLavadora;
	private JMenuItem mntmMdificarLavadora;
	private JMenuItem mntmListarLavadoras;
	private JMenuItem mntmGenerarReportes;
	private JMenuItem mntmVender;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmAcerca;
	
	/*
	 * Ventanas
	 * */

	public void actionPerformed(ActionEvent e) {
		//Salir
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmNewMenuItem(e);
		}
		//Acerca de tienda
		if (e.getSource() == mntmAcerca) {
			actionPerformedMntmAcerca(e);
		}
		//Ventas
		if (e.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		//Configuracion
		if (e.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(e);
		}
		if (e.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(e);
		}
		if (e.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(e);
		}
		if (e.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(e);
		}
		//Mantenimiento
		if (e.getSource() == mntmListarLavadoras) {
			actionPerformedMntmListarLavadoras(e);
		}
		if (e.getSource() == mntmMdificarLavadora) {
			actionPerformedMntmMdificarLavadora(e);
		}
		if (e.getSource() == mntmConsultarLavadora) {
			actionPerformedMntmConsultarLavadora(e);
		}
	}
	//Mantenimiento
	protected void actionPerformedMntmConsultarLavadora(ActionEvent e) {
		ConsultarLavadora cl = new ConsultarLavadora();
		cl.setVisible(true);
	}
	protected void actionPerformedMntmMdificarLavadora(ActionEvent e) {
		ModificarLavadora ml = new ModificarLavadora();
		ml.setVisible(true);
	}
	protected void actionPerformedMntmListarLavadoras(ActionEvent e) {
		ListarLavadoras ll = new ListarLavadoras();
		ll.setVisible(true);
	}
	
	//Configuracion
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent e) {
		ConfigurarDescuentos cd = new ConfigurarDescuentos();
		cd.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent e) {
		ConfigurarObsequios co = new ConfigurarObsequios();
		co.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent e) {
		ConfigurarCantidadOptima cco = new ConfigurarCantidadOptima();
		cco.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent e) {
		ConfigurarCuotaDiaria ccd = new ConfigurarCuotaDiaria();
		ccd.setVisible(true);
	}
	
	//Ventas
	protected void actionPerformedMntmVender(ActionEvent e) {
		Vender v = new Vender();
		v.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent e) {
		GenerarReportes gr = new GenerarReportes();
		gr.setVisible(true);
	}
	//Acerca de tienda
	protected void actionPerformedMntmAcerca(ActionEvent e) {
		Ayuda A = new Ayuda();
		A.setVisible(true);
	}
	
	//Salir
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		int mensaje;
		
		mensaje = JOptionPane.showConfirmDialog(null, "¿Seguro desea salir?", 
												"Mensaje importante!", JOptionPane.YES_NO_OPTION);
		if(mensaje == 0) System.exit(0);
	}
}
