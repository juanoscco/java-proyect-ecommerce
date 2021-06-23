package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.accessibility.AccessibleContext;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tienda.Tienda;

public class ListarLavadoras extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnListar;

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
			ListarLavadoras dialog = new ListarLavadoras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarLavadoras() {
		setTitle("Listar Lavadoras");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 200);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(104, 227, 89, 23);
		contentPanel.add(btnCerrar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(207, 227, 89, 23);
		contentPanel.add(btnListar);
	}
	
	/*
	 * Impresion de resultados
	 * */	
	Tienda t = new Tienda();
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		ListarLavadoras();
	}
	
	void ListarLavadoras() {
		txtS.setText("LISTADO DE LAVADORAS" + "\n");
		imprimir("Modelo		:" + t.modelo0);
		imprimir("Precio		:"+ t.precio0);
		imprimir("Profundidad 	:"+ t.fondo0);
		imprimir("Ancho		:"+ t.ancho0);
		imprimir("Alto		:"+ t.alto0);
		imprimir("Capacidad	:"+ t.capacidad0);
		imprimir("");
		imprimir("Modelo		:" + t.modelo1);
		imprimir("Precio		:"+ t.precio1);
		imprimir("Profundidad 	:"+ t.fondo1);
		imprimir("Ancho		:"+ t.ancho1);
		imprimir("Alto		:"+ t.alto1);
		imprimir("Capacidad	:"+ t.capacidad1);
		imprimir("");
		imprimir("Modelo		:" + t.modelo2);
		imprimir("Precio		:"+ t.precio2);
		imprimir("Profundidad 	:"+ t.fondo2);
		imprimir("Ancho		:"+ t.ancho2);
		imprimir("Alto		:"+ t.alto2);
		imprimir("Capacidad	:"+ t.capacidad2);
		imprimir("");
		imprimir("Modelo		:" + t.modelo3);
		imprimir("Precio		:"+ t.precio3);
		imprimir("Profundidad 	:"+ t.fondo3);
		imprimir("Ancho		:"+ t.ancho3);
		imprimir("Alto		:"+ t.alto3);
		imprimir("Capacidad	:"+ t.capacidad3);
		imprimir("");
		imprimir("Modelo		:" + t.modelo4);
		imprimir("Precio		:"+ t.precio4);
		imprimir("Profundidad 	:"+ t.fondo4);
		imprimir("Ancho		:"+ t.ancho4);
		imprimir("Alto		:"+ t.alto4);
		imprimir("Capacidad	:"+ t.capacidad4);
	}
	
	void imprimir(String s) {
		txtS.append("\n" + s);
	}
	
	
	
}
