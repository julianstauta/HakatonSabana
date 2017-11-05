package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import mundo.*;

public class Principal extends JFrame implements ActionListener{

	public static final String ESCANEAR = "Escanear";
	public static final String VERID = "VER ID";
	
	private JLabel imagen = new JLabel("", SwingConstants.CENTER);
	private JLabel labAlpinaId = new JLabel("Alpina ID", SwingConstants.CENTER);
	private JLabel labPuntaje = new JLabel("Puntaje: ", SwingConstants.CENTER);
	private JLabel labMensaje = new JLabel("Productos pensados para tí:");
	private JButton butEscanear = new JButton("Escanear");
	private JButton butVer = new JButton("Ver ID");
	private JList<String> listaRecomendados = new JList<>();
	private Menu mBar = new Menu(this);
	private Estadisticas ventanaEstadisticas;
	private RedimePuntos red;
	private JMenuBar m;
	private App app;
	public Usuario usuarioActual;
	private Component entrenadores;
	
	public Principal() {
		this.setSize(450, 800);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		JPanel aux = new JPanel();
		aux.setLayout(new BorderLayout());
		ImageIcon icono = new ImageIcon( "Img/logo.png" );
		Icon icon = new ImageIcon(icono.getImage().getScaledInstance(200, 140, Image.SCALE_DEFAULT));
		imagen.setIcon(icon);
		app = new App();
		usuarioActual = new Usuario("26", "mama01@gmail.com", "Mama");
		labAlpinaId.setFont(new Font("Arial", 1, 30));
		labPuntaje.setFont(new Font("Arial", 0, 30));
		butEscanear.setFont(new Font("Arial", 0, 28));
		butVer.setFont(new Font("Arial", 0, 28));
		butEscanear.addActionListener(this);
		butVer.addActionListener(this);
		butEscanear.setActionCommand(ESCANEAR);
		butVer.setActionCommand(VERID);
		
		llenarLista();
		
		listaRecomendados.setBackground(Color.WHITE);
		m = new JMenuBar();
		m.add(mBar);
		setJMenuBar(m);
		aux.add(imagen, BorderLayout.NORTH);
		aux.add(labAlpinaId, BorderLayout.CENTER);
		aux.add(labPuntaje, BorderLayout.SOUTH);
		add(aux, BorderLayout.NORTH);
		JPanel aux2 = new JPanel();
		aux2.add(butEscanear);
		aux2.add(butVer);
		JPanel aux3 = new JPanel();
		labMensaje.setFont(new Font("Arial", 0, 20));
		aux3.add(labMensaje);
		JPanel aux4 = new JPanel();
		aux4.setLayout(new BorderLayout());
		aux4.add(aux2, BorderLayout.NORTH);
		aux4.add(aux3, BorderLayout.CENTER);
		add(aux4, BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane( );
	    scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		scroll.setPreferredSize(new Dimension(300, 400));
	    scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
	    scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
	    scroll.getViewport( ).add( listaRecomendados );
		add(scroll, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centrar();
	}
	
	public void AbrirEstadisticas() {
		this.setVisible(false);
		ventanaEstadisticas  = new Estadisticas(this);
		ventanaEstadisticas.setVisible(true);
	}
	
	public void AbrirRedimir() {
		this.setVisible(false);
		red = new RedimePuntos(this);
		red.setVisible(true);
	}
	
	private void centrar( ){
		 
	    Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
	    int xEsquina = ( screen.width - getWidth( ) ) / 2;
	    int yEsquina = ( screen.height - getHeight( ) ) / 2;
	    setLocation( xEsquina, yEsquina );
	}
	
	public static void main(String[] args) {
		Saludo s = new Saludo();
		s.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(ESCANEAR)) {
			usuarioActual.setPuntos(usuarioActual.getPuntos()+1);
			labPuntaje.setText("Puntaje: "+usuarioActual.getPuntos());
			JOptionPane.showMessageDialog(this, "Se ha leido exitosamente el codigo del producto!!!");
			
		} else {
			Panel_img img = new Panel_img("IMG/barcode.gif");
			img.setVisible(true);
		}
	}
	
	
	public void llenarLista() {
		labPuntaje.setText("Puntaje: "+usuarioActual.getPuntos());
		ArrayList<Producto> recomendados = app.generarRecomendaciones(usuarioActual.getIdUsuario());
		String[] data = new String[recomendados.size()];
		for (int i = 0; i < recomendados.size(); i++) {
			data[i] = recomendados.get(i).getNombre();
		}
		listaRecomendados.setListData(data);
		listaRecomendados.setSelectedIndex(0);
	}
	
}
