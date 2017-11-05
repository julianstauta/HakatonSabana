package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Panel_img extends JFrame{

	public Panel_img(String ruta) {
		
		JLabel imagen = new JLabel("", SwingConstants.CENTER);
		ImageIcon icono = new ImageIcon( ruta );
		imagen.setIcon(icono);
		add(imagen);
		pack();
		centrar();
	}
	
	private void centrar( ){
		 
	    Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
	    int xEsquina = ( screen.width - getWidth( ) ) / 2;
	    int yEsquina = ( screen.height - getHeight( ) ) / 2;
	    setLocation( xEsquina, yEsquina );
	}
	
}
