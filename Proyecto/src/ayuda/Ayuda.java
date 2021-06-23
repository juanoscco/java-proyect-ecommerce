package ayuda;

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
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;

public class Ayuda extends JDialog implements ActionListener {
	private JLabel lblTitulo;
	private JLabel lblAutores;
	private JLabel lblYo;
	private JButton btnCerrar;
	private JSeparator separator;

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
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setBounds(100, 100, 450, 229);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Tienda 1.0");
		lblTitulo.setBounds(138, 11, 183, 62);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		getContentPane().add(lblTitulo);
		
		lblAutores = new JLabel("Autor");
		lblAutores.setBounds(184, 71, 74, 37);
		lblAutores.setFont(new Font("Arial", Font.BOLD, 15));
		getContentPane().add(lblAutores);
		
		lblYo = new JLabel("Juan Oscco Mori");
		lblYo.setBounds(171, 103, 87, 20);
		getContentPane().add(lblYo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(171, 134, 74, 23);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBounds(0, 69, 434, 7);
		getContentPane().add(separator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		// TODO Auto-generated method stub
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
