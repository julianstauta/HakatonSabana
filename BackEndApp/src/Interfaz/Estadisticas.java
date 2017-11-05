package Interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Estadisticas extends JFrame{

	private JLabel imagen = new JLabel("", SwingConstants.CENTER);
	private JLabel labAlpinaId = new JLabel("AlpinaID", SwingConstants.CENTER);
	private JLabel labPuntaje = new JLabel("Puntaje: ", SwingConstants.CENTER);
	private JLabel labGrafica = new JLabel("",SwingConstants.CENTER);
	private JButton butEscanear = new JButton("Escanear");
	private JButton butVer = new JButton("Ver ID");
	private JList<String> listaRecomendados = new JList<>();
	private Menu mBar = new Menu(this);
	private Principal principal;
	private RedimePuntos redime;
	private JLabel labMensaje = new JLabel("Tu trayectoria con nosotros", SwingConstants.CENTER);
	
	public Estadisticas(Principal ventana){
		super ("Estadisticas");
		principal = ventana;
		this.setSize(450, 800);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		JPanel aux = new JPanel();
		aux.setLayout(new BorderLayout());
		ImageIcon icono = new ImageIcon( "Img/logo.png" );
		Icon icon = new ImageIcon(icono.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT));
		imagen.setIcon(icon);
		JMenuBar m = new JMenuBar();
		m.add(mBar);
		setJMenuBar(m);
		
		labAlpinaId.setFont(new Font("Arial", 1, 30));
		labPuntaje.setFont(new Font("Arial", 0, 28));
		labMensaje.setFont(new Font("Arial", 0, 20));
		actualizarPuntaje();
		aux.add(imagen, BorderLayout.NORTH);
		aux.add(labAlpinaId, BorderLayout.CENTER);
		aux.add(labPuntaje, BorderLayout.SOUTH);
		add(aux, BorderLayout.NORTH);
		add(labMensaje, BorderLayout.CENTER);
		Icon ic = new ImageIcon( "Img/graficas.jpg" );
		labGrafica.setIcon(ic);
		add(labGrafica, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centrar();
	}
	
	public void AbrirPrincipal() {
		this.setVisible(false);
		principal.setVisible(true);
	}
	
	public void AbrirRedimir() {
		redime = new RedimePuntos(principal);
		setVisible(false);
		redime.setVisible(true);
	}
	
	public void actualizarPuntaje() {
		labPuntaje.setText("Puntaje: "+principal.usuarioActual.getPuntos());
	}
	
	private void centrar( ){
		 
	    Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
	    int xEsquina = ( screen.width - getWidth( ) ) / 2;
	    int yEsquina = ( screen.height - getHeight( ) ) / 2;
	    setLocation( xEsquina, yEsquina );
	}
	
}
