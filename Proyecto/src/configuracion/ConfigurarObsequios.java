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

public class ConfigurarObsequios extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField textUnaUnidad;
	private JTextField textDosACincoUnidades;
	private JTextField textSeisAMasUnidades;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

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
			ConfigurarObsequios dialog = new ConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarObsequios() {
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 450, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(305, 34, 89, 23);
		contentPanel.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(305, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		textUnaUnidad = new JTextField("" + Tienda.obsequio1);
		textUnaUnidad.setBounds(159, 12, 86, 20);
		contentPanel.add(textUnaUnidad);
		textUnaUnidad.setColumns(10);
		
		textDosACincoUnidades = new JTextField("" + Tienda.obsequio2);
		textDosACincoUnidades.setBounds(159, 40, 86, 20);
		contentPanel.add(textDosACincoUnidades);
		textDosACincoUnidades.setColumns(10);
		
		textSeisAMasUnidades = new JTextField("" + Tienda.obsequio3);
		textSeisAMasUnidades.setBounds(159, 68, 86, 20);
		contentPanel.add(textSeisAMasUnidades);
		textSeisAMasUnidades.setColumns(10);
		
		lblNewLabel = new JLabel("1 unidad");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("2 a 5 unidades");
		lblNewLabel_1.setBounds(10, 43, 70, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("6 a mas unidades");
		lblNewLabel_2.setBounds(10, 71, 89, 14);
		contentPanel.add(lblNewLabel_2);
	}
	/*
	 * Solucion a configurar obsequios
	 * */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		//Precionar Boton
		ConfiguracionDeObsequiosEnTienda();
	}
	//Tomando el texto de las casillas
	String ConfiguracionDeUnaUnidad() {
		return textUnaUnidad.getText();
	}
	
	String ConfiguracionDeDosACincoUnidades() {
		return textDosACincoUnidades.getText();
	}
	
	String ConfiguracionDeSeisAMasUnidades() {
		return textSeisAMasUnidades.getText();
	}
	
	void ConfiguracionDeObsequiosEnTienda() {
		String unaUnidad, dosACincoUnidades, seisAMasUnidades;
		
		unaUnidad = ConfiguracionDeUnaUnidad();
		dosACincoUnidades = ConfiguracionDeDosACincoUnidades();
		seisAMasUnidades = ConfiguracionDeSeisAMasUnidades();
		
		if (unaUnidad.length() == 0) {
			JOptionPane.showMessageDialog(this, "El obsequio no puede estar vacío");
		}
		else if (dosACincoUnidades.length() == 0) {
			JOptionPane.showMessageDialog(this, "El obsequio no puede estar vacío");
		}
		else if (seisAMasUnidades.length() == 0) {
			JOptionPane.showMessageDialog(this, "El obsequio no puede estar vacío");
		}
		else {
			Tienda.obsequio1 = unaUnidad;
			Tienda.obsequio2 = dosACincoUnidades;
			Tienda.obsequio3 = seisAMasUnidades;
			dispose();
		}
		
	}
	
}
