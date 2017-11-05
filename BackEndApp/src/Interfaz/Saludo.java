package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Saludo extends JFrame implements ActionListener{

	JButton butContinuar = new JButton("Continuar");
	public static final String CONTINUAR = "Continuar"; 
	
	public Saludo() {
		setSize(450, 800);
		setLayout(new BorderLayout());
		JLabel imagen = new JLabel("", SwingConstants.CENTER);
		ImageIcon icono = new ImageIcon( "Img/imagensaludo.jpg" );
		imagen.setIcon(icono);
		add(imagen, BorderLayout.CENTER);
		add(butContinuar, BorderLayout.SOUTH);
		
		butContinuar.addActionListener(this);
		butContinuar.setActionCommand(CONTINUAR);
		
		centrar();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		Icon icon = new ImageIcon(icono.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT));
	}
	
	private void centrar( ){
		
	    Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
	    int xEsquina = ( screen.width - getWidth( ) ) / 2;
	    int yEsquina = ( screen.height - getHeight( ) ) / 2;
	    setLocation( xEsquina, yEsquina );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONTINUAR)) {
			this.setVisible(false);
			Principal p = new Principal();
			p.setVisible(true);
		}
	}
	
}
