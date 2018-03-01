/*
Copyright (C) 2016-2018  Juan Antonio Auñón Ochando

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details:

http://www.gnu.org/licenses/gpl.html

Note: some of the screenshots contained in this software may show content owned by EducaPoker, and may be under their own licenses.
This GPL license applies to the code, the software and all the images that aren't property of EducaPoker.
 */


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Rangos {

	private JFrame frmRangosDiplomado;
	private ButtonGroup Grupo3bet = new ButtonGroup();
	private ButtonGroup Grupo4bet = new ButtonGroup();
	private String nombrebtn3b = "3bet", nombrebtn3bo = "3bet o", nombrebtn4b = "4bet", nombrebtn4bo = "4bet o";
	JLabel espacio = new JLabel("");
	ArrayList<JRadioButton> buttons3b = new ArrayList();
	ArrayList<JRadioButton> buttons4b = new ArrayList();
	ArrayList<JButton> botonesTramos = new ArrayList();
	
	//Variable para almacenar el texto del último Jbutton que se haya pulsado, para que no se pierda al pulsar otro botón
	String btn3b4b = new String();
	String btnRango3b = new String();
	String btnRango4b = new String();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Para obtener una GUI con un aspecto más cómodo en Windows
		for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Windows".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
            } catch (Exception ex) {
            }
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rangos window = new Rangos();
					window.frmRangosDiplomado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rangos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRangosDiplomado = new JFrame("Rangos Diplomado 6.1");
		frmRangosDiplomado.setMinimumSize(new Dimension(1280, 720));
		frmRangosDiplomado.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmRangosDiplomado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRangosDiplomado.getContentPane().setLayout(new GridBagLayout());
		
		//Icono para la aplicación
		ImageIcon iconoApp = new ImageIcon(Rangos.class.getResource("icono.PNG"));
		Image iconoAppImg = iconoApp.getImage();
		frmRangosDiplomado.setIconImage(iconoAppImg);
		
		//Componentes (unos pocos los he declarado fuera de initialize() para poder acceder a ellos desde métodos y funciones de la clase Rangos
		JButton btn3bet = new JButton(nombrebtn3b);
		JButton btn3beto = new JButton(nombrebtn3bo);
		JButton btn4bet = new JButton(nombrebtn4b);
		JButton btn4beto = new JButton(nombrebtn4bo);
		JButton btnOR = new JButton("OR - ROL");
		JButton btnCall = new JButton("Calls All-In");
		JButton btnPostIni = new JButton("Postflop Ini");
		JButton btnPostNoIni1 = new JButton("Post Sin Dos");
		JButton btnPostNoIni2 = new JButton("Post Sin Tres");
		JButton boton1 = new JButton("01.");
		JButton boton2 = new JButton("02.");
		JButton boton3 = new JButton("03.");
		JButton boton4 = new JButton("04.");
		JButton boton5 = new JButton("05.");
		JButton boton6 = new JButton("06.");
		JButton boton7 = new JButton("07.");
		JButton boton8 = new JButton("08.");
		JButton boton9 = new JButton("09.");
		JButton boton10 = new JButton("10.");
		JRadioButton radio3betx2x0 = new JRadioButton("D 2x - F 0.5-1x");
		JRadioButton radio3betx2x1 = new JRadioButton("D 2x - F 1.5-2x");
		JRadioButton radio3betx2x2 = new JRadioButton("D 2x - F 2.5-3x");
		JRadioButton radio3betx3x0 = new JRadioButton("D 3x - F 0.5-1x");
		JRadioButton radio3betx3x1 = new JRadioButton("D 3x - F 1.5-2x");
		JRadioButton radio3betx3x2 = new JRadioButton("D 3x - F 2.5-3x");
		JRadioButton radio3betx4x0 = new JRadioButton("D 4x - F 0.5-1x");
		JRadioButton radio3betx4x1 = new JRadioButton("D 4x - F 1.5-2x");
		JRadioButton radio3betx4x2 = new JRadioButton("D 4x - F 2.5-3x");
		JRadioButton radio3betx5x0 = new JRadioButton("D 5x - F 0.5-1x");
		JRadioButton radio3betx5x1 = new JRadioButton("D 5x - F 1.5-2x");
		JRadioButton radio3betx5x2 = new JRadioButton("D 5x - F 2.5-3x");
		JRadioButton radio4betx1x0 = new JRadioButton("D 1x - F 0.5-1x");
		JRadioButton radio4betx1x2 = new JRadioButton("D 1x - F 2-3x");
		JRadioButton radio4betx2x0 = new JRadioButton("D 2x - F 0.5-1x");
		JRadioButton radio4betx2x2 = new JRadioButton("D 2x - F 2-3x");
		JRadioButton radio4betx3x0 = new JRadioButton("D 3x - F 0.5-1x");
		JRadioButton radio4betx3x2 = new JRadioButton("D 3x - F 2-3x");
		JRadioButton radio4betx4x0 = new JRadioButton("D 4x - F 0.5-1x");
		JRadioButton radio4betx4x2 = new JRadioButton("D 4x - F 2-3x");
		JRadioButton radio4betx5x0 = new JRadioButton("D 5x - F 0.5-1x");
		JRadioButton radio4betx5x2 = new JRadioButton("D 5x - F 2-3x");
		
		buttons3b.add(radio3betx2x0);
		buttons3b.add(radio3betx2x1);
		buttons3b.add(radio3betx2x2);
		buttons3b.add(radio3betx3x0);
		buttons3b.add(radio3betx3x1);
		buttons3b.add(radio3betx3x2);
		buttons3b.add(radio3betx4x0);
		buttons3b.add(radio3betx4x1);
		buttons3b.add(radio3betx4x2);
		buttons3b.add(radio3betx5x0);
		buttons3b.add(radio3betx5x1);
		buttons3b.add(radio3betx5x2);
		buttons4b.add(radio4betx1x0);
		buttons4b.add(radio4betx1x2);
		buttons4b.add(radio4betx2x0);
		buttons4b.add(radio4betx2x2);
		buttons4b.add(radio4betx3x0);
		buttons4b.add(radio4betx3x2);
		buttons4b.add(radio4betx4x0);
		buttons4b.add(radio4betx4x2);
		buttons4b.add(radio4betx5x0);
		buttons4b.add(radio4betx5x2);
		botonesTramos.add(boton1);
		botonesTramos.add(boton2);
		botonesTramos.add(boton3);
		botonesTramos.add(boton4);
		botonesTramos.add(boton5);
		botonesTramos.add(boton6);
		botonesTramos.add(boton7);
		botonesTramos.add(boton8);
		botonesTramos.add(boton9);
		botonesTramos.add(boton10);
		
		//Listeners para los botones del panel superior
		btn3bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetearBotones();
				btn3b4b = btn3bet.getText();
				accionBoton3bet();
			}
		});
		btn3beto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetearBotones();
				btn3b4b = btn3beto.getText();
				accionBoton3bet();
			}
		});
		btn4bet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetearBotones();
				btn3b4b = btn4bet.getText();
				accionBoton4bet();
			}
		});
		btn4beto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent i) {
				resetearBotones();
				btn3b4b = btn4beto.getText();
				accionBoton4bet();
			}
		});
		btnOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				accionRestoBotones();
				btn3b4b = "/varios/OR-ROL.png";
				dibujarRango(btn3b4b);
			}
		});
		btnCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				accionRestoBotones();
				btn3b4b = "/varios/CallAllIn.png";
				dibujarRango(btn3b4b);
			}
		});
		btnPostIni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				accionRestoBotones();
				btn3b4b = "/varios/PostflopIni.png";
				dibujarRango(btn3b4b);
			}
		});
		btnPostNoIni1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				accionRestoBotones();
				btn3b4b = "/varios/PostflopNoIni1.png";
				dibujarRango(btn3b4b);
			}
		});
		btnPostNoIni2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				accionRestoBotones();
				btn3b4b = "/varios/PostflopNoIni2.png";
				dibujarRango(btn3b4b);
			}
		});
		//Listener común para todos los botones de los tramos y otro para los radiobuttons (se asignan en un for más abajo)
		ActionListener listenerBotonesTramos = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionBotonesTramos((JButton)e.getSource());
			}
		};
		ActionListener listenerRadioButtons = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dibujarRango(obtenerRuta());
			}
		};
		
		//Parte de los layouts de la interfaz gráfica
		
		//Layout interno del panel superior (primera fila de botones)
		//Tiene su propio layout para que los botones se alineen así: 3b - 3bo <ESPACIO> 5 botones <ESPACIO> 4bo - 4b  independientemente de la cuadrícula principal
		JPanel pSuperior = new JPanel();
		pSuperior.setLayout(new BoxLayout(pSuperior, BoxLayout.LINE_AXIS));
		pSuperior.add(btn3bet);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btn3beto);
		pSuperior.add(Box.createHorizontalGlue());
		pSuperior.add(btnOR);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btnCall);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btnPostIni);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btnPostNoIni1);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btnPostNoIni2);
		pSuperior.add(Box.createHorizontalGlue());
		pSuperior.add(btn4beto);
		pSuperior.add(Box.createRigidArea(new Dimension(5,0)));
		pSuperior.add(btn4bet);
		btn3bet.setPreferredSize(new Dimension(100, 20));
		btn3beto.setPreferredSize(new Dimension(100, 20));
		btn4bet.setPreferredSize(new Dimension(100, 20));
		btn4beto.setPreferredSize(new Dimension(100, 20));
		btnOR.setPreferredSize(new Dimension(100, 20));
		btnCall.setPreferredSize(new Dimension(100, 20));
		btnPostIni.setPreferredSize(new Dimension(100, 20));
		btnPostNoIni1.setPreferredSize(new Dimension(100, 20));
		btnPostNoIni2.setPreferredSize(new Dimension(100, 20));
		
		//Espacios en blanco alrededor de los botones de más abajo
		Insets iFull = new Insets(5, 10, 5, 10);
		Insets iIzq = new Insets(5, 10, 5, 5);
		Insets iDer = new Insets(5, 5, 5, 10);
		Insets iCen = new Insets(5, 5, 5, 5);
		
		//Colocación del panel superior en el layout principal
		GridBagConstraints cSuperior = new GridBagConstraints();
		cSuperior.gridx = 0;
		cSuperior.gridy = 0;
		cSuperior.gridwidth = 10;
		cSuperior.fill = GridBagConstraints.HORIZONTAL;
		cSuperior.insets = iFull;
		cSuperior.weightx = 1;
		frmRangosDiplomado.getContentPane().add(pSuperior, cSuperior);
		
		//Colocación del separador (por estética), que tiene sus propios insets
		JSeparator separator = new JSeparator();
		cSuperior.insets = new Insets(0, 10, 0, 10);
		cSuperior.gridy = 1;
		frmRangosDiplomado.getContentPane().add(separator, cSuperior);
		
		//Colocación de los botones de tramos directamente en el layout principal
		GridBagConstraints cTramos = new GridBagConstraints();
		cTramos.gridy = 2;
		cTramos.fill = GridBagConstraints.HORIZONTAL;
		cTramos.weightx = 1;
		for (int cont = 0; cont < botonesTramos.size(); cont++)
		{
			cTramos.gridx = cont;
			//El primer y el último botón tienen insets propios, más anchos en la parte que toca al margen de la ventana
			if (cont == 0) cTramos.insets = iIzq;
			else if (cont == (botonesTramos.size() - 1)) cTramos.insets = iDer;
			else cTramos.insets = iCen;
			frmRangosDiplomado.getContentPane().add(botonesTramos.get(cont), cTramos);
			//Sin el SetPreferredSize y el SetMinimumSize, los anchos de los botones no se quedan fijos sino que van adaptándose al botón seleccionado
			botonesTramos.get(cont).setPreferredSize(new Dimension(Short.MAX_VALUE, 25));
			botonesTramos.get(cont).setMinimumSize(botonesTramos.get(cont).getPreferredSize());
			botonesTramos.get(cont).addActionListener(listenerBotonesTramos);
		}
		
		//Creación y colocación del panel de radiobuttons de 3bet en el layout principal
		JPanel panel3b = new JPanel();
		panel3b.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c3b = new GridBagConstraints();
		c3b.gridx = 0;
		c3b.gridy = 3;
		c3b.gridwidth = 5;
		c3b.fill = GridBagConstraints.HORIZONTAL;
		c3b.insets = iIzq;
		c3b.weightx = 1;
		frmRangosDiplomado.getContentPane().add(panel3b, c3b);
		//Layout interno del panel de radiobuttons de 3bet
		panel3b.setLayout(new GridBagLayout());
		GridBagConstraints c3br = new GridBagConstraints();
		c3br.weightx = 1;
		c3br.anchor = GridBagConstraints.LINE_START;
		for (int cont = 0; cont < buttons3b.size(); cont++)
		{
			int x = cont / 3;
			int y = cont - (x * 3);
			c3br.gridx = x;
			c3br.gridy = y;
			panel3b.add(buttons3b.get(cont), c3br);
			//Aprovecho este bucle de la parte gráfica para añadir los radiobuttons al ButtonGroup, deshabilitarlos por defecto y añadir el listener
			Grupo3bet.add(buttons3b.get(cont));
			buttons3b.get(cont).setEnabled(false);
			buttons3b.get(cont).addActionListener(listenerRadioButtons);
		}
		
		//Creación y colocación del panel de radiobuttons de 4bet en el layout principal
		JPanel panel4b = new JPanel();
		panel4b.setBorder(new LineBorder(Color.LIGHT_GRAY));
		GridBagConstraints c4b = new GridBagConstraints();
		c4b.gridx = 5;
		c4b.gridy = 3;
		c4b.gridwidth = 5;
		c4b.fill = GridBagConstraints.BOTH;
		c4b.insets = iDer;
		c4b.weightx = 1;
		frmRangosDiplomado.getContentPane().add(panel4b, c4b);
		//Layout interno del panel de radiobuttons de 4bet (reutiliza c3br)
		panel4b.setLayout(new GridBagLayout());
		c3br.weighty = 1;
		for (int cont = 0; cont < buttons4b.size(); cont++)
		{
			int x = cont / 2;
			int y = cont - (x * 2);
			c3br.gridx = x;
			c3br.gridy = y;
			panel4b.add(buttons4b.get(cont), c3br);
			//Lo mismo que en el bucle for anterior
			Grupo4bet.add(buttons4b.get(cont));
			buttons4b.get(cont).setEnabled(false);
			buttons4b.get(cont).addActionListener(listenerRadioButtons);
		}
		
		//Colocación del espacio donde irá la imagen en el layout principal
		GridBagConstraints cespacio = new GridBagConstraints();
		cespacio.gridx = 0;
		cespacio.gridy = 4;
		cespacio.gridwidth = 10;
		cespacio.fill = GridBagConstraints.BOTH;
		cespacio.insets = iFull;
		cespacio.weightx = 1;
		cespacio.weighty = 1;
		frmRangosDiplomado.getContentPane().add(espacio, cespacio);
		
		espacio.setHorizontalAlignment(SwingConstants.CENTER);
		espacio.setVerticalAlignment(SwingConstants.TOP);
		
		//Código para reajustar la imagen al redimensionar la ventana
		frmRangosDiplomado.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				dibujarRango(obtenerRuta());
			}
		});
		
	}
	
	private void accionBoton3bet() {
		for (int cont = 0; cont < buttons3b.size(); cont++)
		{
			buttons3b.get(cont).setEnabled(true);
		}
		for (int cont = 0; cont < buttons4b.size(); cont++)
		{
			buttons4b.get(cont).setEnabled(false);
		}
		for (int cont = 0; cont < botonesTramos.size(); cont++)
		{
			botonesTramos.get(cont).setEnabled(true);
		}
		botonesTramos.get(0).setText("01. 0-8");
		botonesTramos.get(1).setText("02. 8-12");
		botonesTramos.get(2).setText("03. 12-17 (EP)");
		botonesTramos.get(3).setText("04. 17-24 (MP)");
		botonesTramos.get(4).setText("05. 24-33 (CO)");
		botonesTramos.get(5).setText("06. 33-43 (BTN)");
		botonesTramos.get(6).setText("07. 43-55 (SB)");
		botonesTramos.get(7).setText("08. 55-67");
		botonesTramos.get(8).setText("09. 67-80");
		botonesTramos.get(9).setText("10. 80-100");
		cursivaBotonTramo();
		dibujarRango(obtenerRuta());
	}
	
	private void accionBoton4bet() {
		for (int cont = 0; cont < buttons3b.size(); cont++)
		{
			buttons3b.get(cont).setEnabled(false);
		}
		for (int cont = 0; cont < buttons4b.size(); cont++)
		{
			buttons4b.get(cont).setEnabled(true);
		}
		for (int cont = 0; cont < botonesTramos.size(); cont++)
		{
			botonesTramos.get(cont).setEnabled(true);
		}
		botonesTramos.get(0).setText("01. 0-7");
		botonesTramos.get(1).setText("02. 8-9 (Default)");
		botonesTramos.get(2).setText("03. 10-11 (BTN)");
		botonesTramos.get(3).setText("04. 12-14 (SB)");
		botonesTramos.get(4).setText("05. 15-17");
		botonesTramos.get(5).setText("06. 18-21");
		botonesTramos.get(6).setText("07. 22-25");
		botonesTramos.get(7).setText("08. 26-30");
		botonesTramos.get(8).setText("09. 31-35");
		botonesTramos.get(9).setText("10. +35");
		cursivaBotonTramo();
		dibujarRango(obtenerRuta());
	}
	
	private void accionBotonesTramos(JButton boton) {
		if (btn3b4b.equals(nombrebtn3b) || btn3b4b.equals(nombrebtn3bo)) btnRango3b = boton.getText();
		else if (btn3b4b.equals(nombrebtn4b) || btn3b4b.equals(nombrebtn4bo)) btnRango4b = boton.getText();
		resetearBotones();
		cursivaBotonTramo();
		dibujarRango(obtenerRuta());
	}
	
	private void accionRestoBotones() {
		for (int cont = 0; cont < buttons3b.size(); cont++)
		{
			buttons3b.get(cont).setEnabled(false);
		}
		for (int cont = 0; cont < buttons4b.size(); cont++)
		{
			buttons4b.get(cont).setEnabled(false);
		}
		resetearBotones();
		for (int cont = 0; cont < botonesTramos.size(); cont++)
		{
			botonesTramos.get(cont).setEnabled(false);
		}
	}
	
	private void dibujarRango(String ruta)
	{
		try {
			ImageIcon iconoTemporal = new ImageIcon(Rangos.class.getResource(ruta));
			//Código para evitar que la imagen sobresalga por arriba/abajo o por los lados, calculando previamente la proporción
			float propImagen = (float)iconoTemporal.getIconWidth() / (float)iconoTemporal.getIconHeight();
			float propEspacio = (float)espacio.getWidth() / (float)espacio.getHeight();
			Image imagen;
			if (propImagen <= propEspacio)
				imagen = iconoTemporal.getImage().getScaledInstance(-1, espacio.getHeight(), Image.SCALE_SMOOTH);
			else imagen = iconoTemporal.getImage().getScaledInstance(espacio.getWidth(), -1, Image.SCALE_SMOOTH);
			ImageIcon icono = new ImageIcon(imagen);
			espacio.setIcon(icono);
		} catch (NullPointerException err) {
			//Si la ruta no existe, o no hay ninguna imagen en dicha ruta, se deja sin imagen
			espacio.setIcon(null);
		}
	}
	
	private String obtenerRuta() {
		String cadena = new String(), btnRango = new String();
		//grupoBotones sirve para poder detectar el RadioButton seleccionado usando un único bucle que sirva tanto para el 3b como para el 4b
		ArrayList<JRadioButton> grupoBotones;
		if (btn3b4b.equals(nombrebtn3b) || btn3b4b.equals(nombrebtn3bo)) 
		{
			grupoBotones = buttons3b;
			btnRango = btnRango3b;
		}
		else if (btn3b4b.equals(nombrebtn4b) || btn3b4b.equals(nombrebtn4bo))
		{
			grupoBotones = buttons4b;
			btnRango = btnRango4b;
		}
		else return btn3b4b;
		for (int cont = 0; cont < grupoBotones.size(); cont++)
		{
			if (grupoBotones.get(cont).isSelected() == true)
			{
				cadena = grupoBotones.get(cont).getText();
				break;
			}
		}
		cadena = "/" + btn3b4b + "/" + btnRango + "/" + cadena + ".png";
		return cadena;
	}
	
	private void resetearBotones() {
		for (int cont = 0; cont < botonesTramos.size(); cont++)
		{
			botonesTramos.get(cont).setFont(new Font("Tahoma", Font.PLAIN, 11));
		}
	}
	
	private void cursivaBotonTramo() {
		String numeroBoton;
		try {
			//La función substring genera una excepción si la cadena está vacía, de ahí el try
			//Uso substring para poder seleccionar el botón según el número por el que empieza su nombre (01. 02. etc.)
			if (btn3b4b.equals(nombrebtn3b) || btn3b4b.equals(nombrebtn3bo)) numeroBoton = btnRango3b.substring(0, 2);
			else if (btn3b4b.equals(nombrebtn4b) || btn3b4b.equals(nombrebtn4bo)) numeroBoton = btnRango4b.substring(0, 2);
			else return; //Este return es útil cuando pulsemos uno de los botones centrales del panel superior, que no ponen nada en cursiva
			for (int cont = 0; cont < botonesTramos.size(); cont++)
			{
				if (numeroBoton.equals(botonesTramos.get(cont).getText().substring(0, 2)))
				{
					botonesTramos.get(cont).setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
					break;
				}
			}
		} catch (StringIndexOutOfBoundsException err) {
			return; //Para que no se ponga nada en cursiva cuando btnRangoxb.substring esté vacío
		}
	}
	
}
