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

public class ConfigurarCuotaDiaria extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextField textCuotaDiariaEsperada;
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
			ConfigurarCuotaDiaria dialog = new ConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfigurarCuotaDiaria() {
		setTitle("Configurar Cuota Diaria");
		setBounds(100, 100, 450, 108);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 35, 89, 23);
		contentPanel.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(335, 11, 89, 23);
		contentPanel.add(btnAceptar);
		
		textCuotaDiariaEsperada = new JTextField("" + Tienda.cuotaDiaria);
		textCuotaDiariaEsperada.setBounds(190, 12, 86, 20);
		contentPanel.add(textCuotaDiariaEsperada);
		textCuotaDiariaEsperada.setColumns(10);
		
		lblNewLabel = new JLabel("Cuota diaria esperada (S/.)");
		lblNewLabel.setBounds(21, 15, 144, 14);
		contentPanel.add(lblNewLabel);
	}
	/*
	 * Solución a la configuración de cuota diaria
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
		ConfigurarCuotaDiariaDeTienda();
	}
	
	double LeerCuotaDiaria() {
		return Double.parseDouble(textCuotaDiariaEsperada.getText());
	}
	
	void ConfigurarCuotaDiariaDeTienda() {
		double cuota;
		
		cuota = LeerCuotaDiaria();
		
		if (cuota <0) {
			JOptionPane.showMessageDialog(this, "El monto tiene que ser minimo a 0");
		}
		else {
			Tienda.cuotaDiaria = cuota;
			dispose();
		}
	}
	
}
