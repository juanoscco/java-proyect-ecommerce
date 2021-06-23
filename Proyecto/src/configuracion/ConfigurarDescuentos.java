package configuracion;

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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import tienda.Tienda;

public class ConfigurarDescuentos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField textUnoACincoUnidades;
	private JTextField textSeisADiezUnidades;
	private JTextField textOnceAQuinceUnidades;
	private JTextField textMasDeQuinceUnidades;
	private JLabel lbl;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

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
			ConfigurarDescuentos dialog = new ConfigurarDescuentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarDescuentos() {
		setTitle("Configurar Descuentos");
		setBounds(100, 100, 450, 175);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(322, 38, 89, 23);
		contentPanel.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(322, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		textUnoACincoUnidades = new JTextField("" + Tienda.porcentaje1);
		textUnoACincoUnidades.addActionListener(this);
		textUnoACincoUnidades.setBounds(126, 12, 86, 20);
		contentPanel.add(textUnoACincoUnidades);
		textUnoACincoUnidades.setColumns(10);
		
		textSeisADiezUnidades = new JTextField("" + Tienda.porcentaje2);
		textSeisADiezUnidades.setBounds(126, 43, 86, 20);
		contentPanel.add(textSeisADiezUnidades);
		textSeisADiezUnidades.setColumns(10);
		
		textOnceAQuinceUnidades = new JTextField("" + Tienda.porcentaje3);
		textOnceAQuinceUnidades.setBounds(126, 70, 86, 20);
		contentPanel.add(textOnceAQuinceUnidades);
		textOnceAQuinceUnidades.setColumns(10);
		
		textMasDeQuinceUnidades = new JTextField("" + Tienda.porcentaje4);
		textMasDeQuinceUnidades.setBounds(126, 101, 86, 20);
		contentPanel.add(textMasDeQuinceUnidades);
		textMasDeQuinceUnidades.setColumns(10);
		
		lbl = new JLabel("%");
		lbl.setBounds(222, 15, 46, 14);
		contentPanel.add(lbl);
		
		lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(222, 42, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setBounds(222, 73, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("%");
		lblNewLabel_3.setBounds(222, 104, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("1 a 5 unidades");
		lblNewLabel_4.setBounds(10, 15, 86, 14);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("6 a 10 unidades");
		lblNewLabel_5.setBounds(10, 42, 86, 14);
		contentPanel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("11 a 15 unidades");
		lblNewLabel_6.setBounds(10, 73, 86, 14);
		contentPanel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Mas de 15 unidades");
		lblNewLabel_7.setBounds(10, 104, 106, 14);
		contentPanel.add(lblNewLabel_7);
	}
	/*
	 * Solucion de la Configuracion de Descuentos
	 * */
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Activar Boton
		ConfigurarDescuentoDeMonto();
	}
	
	//Descuento de mas de 1 unidad
	double DescuentoUnoACincoUnidades() {
		return Double.parseDouble(textUnoACincoUnidades.getText());
	}
	//Descuento de mas de 6 unidades
	double DescuentoSeisADiezUnidades() {
		return Double.parseDouble(textSeisADiezUnidades.getText());
	}
	double DescuentoOnceAQuinceUnidades() {
		return Double.parseDouble(textOnceAQuinceUnidades.getText());
	}
	double DesuentoMasDeQuinceUnidades() {
		return Double.parseDouble(textMasDeQuinceUnidades.getText());
	}
	
	void ConfigurarDescuentoDeMonto() {
		double unoACincoUnidades, seisADiezUnidades, onceAQuinceUnidades, masDeQuinceUnidades;
		
		unoACincoUnidades = DescuentoUnoACincoUnidades();
		seisADiezUnidades = DescuentoSeisADiezUnidades();
		onceAQuinceUnidades = DescuentoOnceAQuinceUnidades();
		masDeQuinceUnidades  = DesuentoMasDeQuinceUnidades();
		
		if(unoACincoUnidades < 0) {
			JOptionPane.showMessageDialog(this, "Descuento mínimo debe ser mayor que 0");
			textUnoACincoUnidades.requestFocus();
		}
		else if(seisADiezUnidades < 0) {
			JOptionPane.showMessageDialog(this, "Descuento minimo debe de ser mayor que 0");
			textSeisADiezUnidades.requestFocus();
		}
		else if (onceAQuinceUnidades < 0) {
			JOptionPane.showMessageDialog(this, "Descuento minimo debe de ser mayor que 0");
			textOnceAQuinceUnidades.requestFocus();
		}
		else if(masDeQuinceUnidades < 0) {
			JOptionPane.showMessageDialog(this, "Descuento minimo debe de ser mayor que 0");
			textMasDeQuinceUnidades.requestFocus();
		}
		else {
			Tienda.porcentaje1 = unoACincoUnidades;
			Tienda.porcentaje2 = seisADiezUnidades;
			Tienda.porcentaje3 = onceAQuinceUnidades;
			Tienda.porcentaje4 = masDeQuinceUnidades;
			dispose();
		}
		
	}

}
