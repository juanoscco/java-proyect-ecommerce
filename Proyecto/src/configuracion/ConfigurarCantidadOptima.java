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

import tienda.Tienda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarCantidadOptima extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField textCantidadOptimaDeUnidadesVendidas;
	private JLabel lblNewLabel;

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
			ConfigurarCantidadOptima dialog = new ConfigurarCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCantidadOptima() {
		setTitle("Listar Lavadoras");
		setBounds(100, 100, 450, 113);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(319, 40, 89, 23);
		contentPanel.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(319, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		textCantidadOptimaDeUnidadesVendidas = new JTextField("" + Tienda.cantidadOptima);
		textCantidadOptimaDeUnidadesVendidas.setBounds(223, 12, 45, 20);
		contentPanel.add(textCantidadOptimaDeUnidadesVendidas);
		textCantidadOptimaDeUnidadesVendidas.setColumns(10);
		
		lblNewLabel = new JLabel("Cantidad optima de unidades vendidas");
		lblNewLabel.setBounds(10, 15, 203, 14);
		contentPanel.add(lblNewLabel);
	}
	
	/*
	 * Solucion cantidad optima
	 * */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Boton
		ConfigurarCantidadOptima();
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	int ConfigurarCantidad() {
		return Integer.parseInt(textCantidadOptimaDeUnidadesVendidas.getText());
	}
	
	
	void ConfigurarCantidadOptima() {
		int cantidad;
		
		cantidad = ConfigurarCantidad();
		
		if (cantidad < 0) {
			JOptionPane.showMessageDialog(this, "No se puede poner un numero menor a 0.");
		}
		else {
			Tienda.cantidadOptima = cantidad;
			dispose();
		}
	}
}
