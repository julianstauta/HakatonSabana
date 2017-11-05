package Interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JMenu implements ActionListener {

	private JMenuItem meitEst;
	private JMenuItem meitRed;
	public final static String ESTADISTICA = "Estadistica";
	public final static String REDIMIR = "Redimir puntos";
	public final static String PRINCIPAL = "Principal";

	private Principal principal;
	private Estadisticas principal1;
	private RedimePuntos principal2;

	public Menu(Principal ventana) {
		super("Opciones");

		principal = ventana;

		meitEst = new JMenuItem(ESTADISTICA);
		meitRed = new JMenuItem(REDIMIR);

		meitEst.addActionListener(this);
		meitRed.addActionListener(this);

		meitEst.setActionCommand(ESTADISTICA);
		meitRed.setActionCommand(REDIMIR);

		add(meitEst);
		add(meitRed);
	}
	public Menu(Estadisticas ventana) {
		super("Opciones");

		principal1 = ventana;

		meitEst = new JMenuItem(PRINCIPAL);
		meitRed = new JMenuItem(REDIMIR);

		meitEst.addActionListener(this);
		meitRed.addActionListener(this);

		meitEst.setActionCommand(PRINCIPAL);
		meitRed.setActionCommand(REDIMIR);

		add(meitEst);
		add(meitRed);
	}
	public Menu(RedimePuntos ventana) {
		super("Opciones");

		principal2 = ventana;

		meitEst = new JMenuItem(ESTADISTICA);
		meitRed = new JMenuItem(PRINCIPAL);

		meitEst.addActionListener(this);
		meitRed.addActionListener(this);

		meitEst.setActionCommand(ESTADISTICA);
		meitRed.setActionCommand(PRINCIPAL);

		add(meitEst);
		add(meitRed);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(ESTADISTICA)) {
			if (principal!=null) {
				principal.AbrirEstadisticas();
			} else {
				principal2.AbrirEstadisticas();
			}
		} else if (comando.equals(REDIMIR)) {
			if (principal!=null) {
				principal.AbrirRedimir();
			} else {
				principal1.AbrirRedimir();
			}
			
			
		} else if (comando.equals(PRINCIPAL)) {
			if (principal1!=null) {
				principal1.AbrirPrincipal(); 
			} else {
				principal2.AbrirPrincipal();
			}
		}

	}
}
