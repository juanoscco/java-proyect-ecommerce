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
import tienda.Tienda;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GenerarReportes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboReporte;
	private JButton btnCerrar;
	private JLabel lblNewLabel;
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
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboReporte = new JComboBox();
		cboReporte.addActionListener(this);
		cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		cboReporte.setBounds(97, 11, 228, 22);
		contentPanel.add(cboReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 15, 83, 14);
		contentPanel.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 414, 214);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
	}
	
	/*
	 * solucion a Generar Reportes
	 * */
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboReporte) {
			actionPerformedComboBox(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		//cerrar
		dispose();
	}
	protected void actionPerformedComboBox(ActionEvent e) {
		//Evento de filtrado
		GenerarReporte();
	}
	
	//Es el boton de procesar
	void GenerarReporte() {
		int reporte = 0;
		reporte = cboReporte.getSelectedIndex();
		
		switch (reporte) {
		case 0: VentasPorModelo(); break;
		case 1: VentasEnRelacionALaCantidadOptima(); break;
		case 2: PreciosEnRelacionAlPromedio(); break;
		default: General(); break;
		}
	}
	
	/*
	 * Calculos para sacar los resultados en orden
	 * */
	
	/*
	 * 1. filtro de ventas por modelo
	 * */
	void VentasPorModelo() {
		imprimir("=======================================");
		imprimir("VENTAS POR MODELO");
		
		imprimir("");
		
		//primera lavadora
		imprimir("Modelo :" + Tienda.modelo0);
		imprimir("Cantidad de ventas :" + Tienda.cantidadDeVentas0);
		imprimir("Cantidad de unidades vendidas  :" + Tienda.unidadesVendidas0);
		imprimir("Importe total vendido :" + Tienda.importeTotalVendido0);
		imprimir("Aporte a la cuota diaria :" + (Tienda.importeTotalVendido0 * 100)/Tienda.cuotaDiaria + "%");
		
		//segunda lavadora
		imprimir("");
		imprimir("Modelo :" + Tienda.modelo1);
		imprimir("Cantidad de ventas :" + Tienda.cantidadDeVentas1);
		imprimir("Cantidad de unidades vendidas  :" + Tienda.unidadesVendidas1);
		imprimir("Importe total vendido :" + Tienda.importeTotalVendido1);
		imprimir("Aporte a la cuota diaria :" + (Tienda.importeTotalVendido1 * 100)/Tienda.cuotaDiaria + "%");
		
		//tercera lavadora
		imprimir("");
		imprimir("Modelo :" + Tienda.modelo2);
		imprimir("Cantidad de ventas :" + Tienda.cantidadDeVentas2);
		imprimir("Cantidad de unidades vendidas  :" + Tienda.unidadesVendidas2);
		imprimir("Importe total vendido :" + Tienda.importeTotalVendido2);
		imprimir("Aporte a la cuota diaria :" + (Tienda.importeTotalVendido2 * 100)/Tienda.cuotaDiaria + "%");
		
		//cuarta lavadora
		imprimir("");
		imprimir("Modelo :" + Tienda.modelo3);
		imprimir("Cantidad de ventas :" + Tienda.cantidadDeVentas3);
		imprimir("Cantidad de unidades vendidas  :" + Tienda.unidadesVendidas3);
		imprimir("Importe total vendido :" + Tienda.importeTotalVendido3);
		imprimir("Aporte a la cuota diaria :" + (Tienda.importeTotalVendido3 * 100)/Tienda.cuotaDiaria + "%");
		
		//quinta lavadora
		imprimir("");
		imprimir("Modelo :" + Tienda.modelo4);
		imprimir("Cantidad de ventas :" + Tienda.cantidadDeVentas4);
		imprimir("Cantidad de unidades vendidas  :" + Tienda.unidadesVendidas4);
		imprimir("Importe total vendido :" + Tienda.importeTotalVendido4);
		imprimir("Aporte a la cuota diaria :" + (Tienda.importeTotalVendido4 * 100)/Tienda.cuotaDiaria + "%");
	}
	
	/*
	 * 2. Ventas en relacion a la optima
	 * */
	void VentasEnRelacionALaCantidadOptima() {
		String mensaje0 = "", mensaje1 = "", mensaje2 = "", mensaje3 = "", mensaje4 = "";
		
		//primera lavadora
		if(Tienda.unidadesVendidas0 == Tienda.cantidadOptima) mensaje0 = " (igual a la cantidad óptima)";
		else 
			if(Tienda.unidadesVendidas0 > Tienda.cantidadOptima) mensaje0 = "(" + (Tienda.unidadesVendidas0 - Tienda.cantidadOptima) + " mas que la cantidad optima)";
			else mensaje0 = "(" + (Tienda.cantidadOptima - Tienda.unidadesVendidas0) + " menos que cantidad óptima)";
		
		//segunda lavadora
		if(Tienda.unidadesVendidas1 == Tienda.cantidadOptima) mensaje1 = " (igual a la cantidad óptima)";
		else 
			if(Tienda.unidadesVendidas1 > Tienda.cantidadOptima) mensaje1 = "(" + (Tienda.unidadesVendidas1 - Tienda.cantidadOptima) + " mas que la cantidad optima)";
			else mensaje1 = "(" + (Tienda.cantidadOptima - Tienda.unidadesVendidas1) + " menos que cantidad óptima)";
	
		//tercera lavadora
		if(Tienda.unidadesVendidas2 == Tienda.cantidadOptima) mensaje2 = " (igual a la cantidad óptima)";
		else 
			if(Tienda.unidadesVendidas2 > Tienda.cantidadOptima) mensaje2 = "(" + (Tienda.unidadesVendidas2 - Tienda.cantidadOptima) + " mas que la cantidad optima)";
			else mensaje2 = "(" + (Tienda.cantidadOptima - Tienda.unidadesVendidas2) + " menos que cantidad óptima)";
	
		//cuarta lavadora
		if(Tienda.unidadesVendidas3 == Tienda.cantidadOptima) mensaje3 = " (igual a la cantidad óptima)";
		else 
			if(Tienda.unidadesVendidas3 > Tienda.cantidadOptima) mensaje3 = "(" + (Tienda.unidadesVendidas3 - Tienda.cantidadOptima) + " mas que la cantidad optima)";
			else mensaje3 = "(" + (Tienda.cantidadOptima - Tienda.unidadesVendidas3) + " menos que cantidad óptima)";
	
		//quinta lavadora
		if(Tienda.unidadesVendidas4 == Tienda.cantidadOptima) mensaje4 = " (igual a la cantidad óptima)";
		else 
			if(Tienda.unidadesVendidas4 > Tienda.cantidadOptima) mensaje4 = "(" + (Tienda.unidadesVendidas4 - Tienda.cantidadOptima) + " mas que la  cantidad optima)";
			else mensaje4 = "(" + (Tienda.cantidadOptima - Tienda.unidadesVendidas4) + " menos que cantidad óptima)";
	
		imprimir("=======================================");
		imprimir("VENTAS EN RELACION A LA VENTA OPTIMA");
		imprimir("");
		//imprimir primera lavadora
		imprimir("Modelo :" + Tienda.modelo0);
		imprimir("Cantidad de unidades vendidas :" + Tienda.unidadesVendidas0 + mensaje0);
		imprimir("");
		//imprimir segunda lavadora
		imprimir("Modelo :" + Tienda.modelo1);
		imprimir("Cantidad de unidades vendidas :" + Tienda.unidadesVendidas1 + mensaje1);
		imprimir("");
		//imprimir tercera lavadora
		imprimir("Modelo :" + Tienda.modelo2);
		imprimir("Cantidad de unidades vendidas :" + Tienda.unidadesVendidas2 + mensaje2);
		imprimir("");
		//imprimir cuarta lavadora
		imprimir("Modelo :" + Tienda.modelo3);
		imprimir("Cantidad de unidades vendidas :" + Tienda.unidadesVendidas3 + mensaje3);
		imprimir("");
		//imprimir quinta lavadora
		imprimir("Modelo :" + Tienda.modelo4);
		imprimir("Cantidad de unidades vendidas :" + Tienda.unidadesVendidas4 + mensaje4);
		imprimir("");
		//FIN
	}
	
	/*
	 * 3. Precios en relacion al precio promedio
	 * */
	void PreciosEnRelacionAlPromedio() {
		String mensaje0 = "", mensaje1 = "", mensaje2 = "", mensaje3 = "", mensaje4 = "";

		//para la primera lavadora
		if(Tienda.precio0 > ObteniendoPromedioDePrecio()) mensaje0 = " (Mayor al promedio)";
		else if(Tienda.precio0 == ObteniendoPromedioDePrecio()) mensaje0 = " (Igual al promedio)";
		else mensaje0 = " (Menor al promedio)";
		
		//para la segunda lavadora
		if(Tienda.precio1 > ObteniendoPromedioDePrecio()) mensaje1 = " (Mayor al promedio)";
		else if(Tienda.precio1 == ObteniendoPromedioDePrecio()) mensaje1 = " (Igual al promedio)";
		else mensaje1 = " (Menor al promedio)";
		
		
		//para la tercera lavadora
		if(Tienda.precio2 > ObteniendoPromedioDePrecio()) mensaje2 = " (Mayor al promedio)";
		else if(Tienda.precio2 == ObteniendoPromedioDePrecio()) mensaje2 = " (Igual al promedio)";
		else mensaje2 = " (Menor al promedio)";
		
		//para la cuarta lavadora
		if(Tienda.precio3 > ObteniendoPromedioDePrecio()) mensaje3 = " (Mayor al promedio)";
		else if(Tienda.precio3 == ObteniendoPromedioDePrecio()) mensaje3 = " (Igual al promedio)";
		else mensaje3 = " (Menor al promedio)";
		
		//para la quinta lavadora
		if(Tienda.precio4 > ObteniendoPromedioDePrecio()) mensaje4 = " (Mayor al promedio)";
		else if(Tienda.precio4 == ObteniendoPromedioDePrecio()) mensaje4 = " (Igual al promedio)";
		else mensaje4 = " (Menor al promedio)";
		
		//Presentacion
		imprimir("=======================================");
		imprimir("PRECIOS EN RELACIÓN AL PRECIO PROMEDIO");
		imprimir("");
		//imprimir primera lavadora
		imprimir("Modelo :" + Tienda.modelo0);
		imprimir("Precio :" + Tienda.precio0 + mensaje0 );
		imprimir("");

		//imprimir segunda lavadora
		imprimir("Modelo :" + Tienda.modelo1);
		imprimir("Precio :" + Tienda.precio1 + mensaje1 );
		imprimir("");

		//imprimir tercera lavadora
		imprimir("Modelo :" + Tienda.modelo2);
		imprimir("Precio :" + Tienda.precio2 + mensaje2 );
		imprimir("");
		//imprimir cuarta lavadora
		imprimir("Modelo :" + Tienda.modelo3);
		imprimir("Precio :" + Tienda.precio3 + mensaje3 );
		imprimir("");
		//imprimir quinta lavadora
		imprimir("Modelo :" + Tienda.modelo4);
		imprimir("Precio :" + Tienda.precio4 + mensaje4 );
		imprimir("");
		
	}
	
	/*
	 * 4. promedios, mayores y menores 
	 * */
	
	//Precio Mayor
	double ObteniendoPrecioMayor() {
		double mayor = Tienda.precio0;
		if(Tienda.precio1 > mayor) mayor = Tienda.precio1;
		if(Tienda.precio2 > mayor) mayor = Tienda.precio2;
		if(Tienda.precio3 > mayor) mayor = Tienda.precio3;
		if(Tienda.precio4 > mayor) mayor = Tienda.precio4;
		return mayor;
	}
	//Precio menor
	double ObteniendoPrecioMenor() {
		double menor = Tienda.precio0;
		if(Tienda.precio1 < menor) menor = Tienda.precio1;
		if(Tienda.precio2 < menor) menor = Tienda.precio2;
		if(Tienda.precio3 < menor) menor = Tienda.precio3;
		if(Tienda.precio4 < menor) menor = Tienda.precio4;
		return menor;
	}
	
	//Precio Promedio
	double ObteniendoPromedioDePrecio() {
		return (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4)/5;
	}
	
	//Ancho mayor
	double ObteniendoAnchoMayor() {
		double mayor = Tienda.ancho0;
		if(Tienda.ancho1 > mayor) mayor = Tienda.ancho1;
		if(Tienda.ancho2 > mayor) mayor = Tienda.ancho2;
		if(Tienda.ancho3 > mayor) mayor = Tienda.ancho3;
		if(Tienda.ancho4 > mayor) mayor = Tienda.ancho4;
		return mayor;
	}
	
	//Ancho menor
	double ObteniendoAnchoMenor() {
		double menor = Tienda.ancho0;
		if (Tienda.ancho1 < menor) menor = Tienda.ancho1;
		if (Tienda.ancho2 < menor) menor = Tienda.ancho2;
		if (Tienda.ancho3 < menor) menor = Tienda.ancho3;
		if (Tienda.ancho4 < menor) menor = Tienda.ancho4;
		return menor;
	}
	//Promedio del ancho
	double ObteniendoPromedioDeAncho() {
		return (Tienda.ancho0 + Tienda.ancho1 + Tienda.ancho2 + Tienda.ancho3 + Tienda.ancho4)/5;
	}
	

	void General() {
		imprimir("=======================================");
		imprimir("PROMEDIOS, MENORES Y MAYORES");
		imprimir("");
		imprimir("Precio promedio :" + ObteniendoPromedioDePrecio());
		imprimir("Precio Mayor :" + ObteniendoPrecioMayor());
		imprimir("Precio menor :" + ObteniendoPrecioMenor());
		imprimir("");
		imprimir("Ancho promedio :" + ObteniendoPromedioDeAncho());
		imprimir("Ancho menor :" + ObteniendoAnchoMenor());
		imprimir("Ancho mayor :" + ObteniendoAnchoMayor());
	}
	
	/*
	 * Fin de calculos
	 * */
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}
