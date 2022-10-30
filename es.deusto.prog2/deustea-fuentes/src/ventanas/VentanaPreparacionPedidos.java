package ventanas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import deustea.*;

public class VentanaPreparacionPedidos extends JFrame {
	protected DefaultListModel<Pedido> modeloPreparacion;
	protected JList<Pedido> listaPreparacion;
	protected DefaultListModel<Pedido> modeloListo;
	protected JList<Pedido> listaListo;
	protected DefaultListModel<Pedido> modeloFinalizado;
	protected JList<Pedido> listaFinalizado;
	protected JButton botonPreparacionAListo;
	protected JButton botonListoAPreparacion;
	protected JButton botonListoAFinalizado;
	protected JButton botonFinalizadoAListo;
		
	public VentanaPreparacionPedidos(Deustea datos) {
		Container cp = this.getContentPane();
		cp.setLayout(new GridLayout(1, 3));
		
		JPanel preparacion = new JPanel(new BorderLayout());
		JPanel listo = new JPanel(new BorderLayout());
		JPanel finalizado = new JPanel(new BorderLayout());
		
		modeloPreparacion = new DefaultListModel<Pedido>();
		listaPreparacion = new JList(modeloPreparacion);
		listaPreparacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPreparacion = new JScrollPane(listaPreparacion);
		
		botonPreparacionAListo = new JButton(">>");
		
		JPanel PreparacionAListo = new JPanel();
		PreparacionAListo.add(botonPreparacionAListo);
		
		preparacion.add(new JLabel("En preparación..."), BorderLayout.NORTH);
		preparacion.add(scrollPreparacion, BorderLayout.CENTER);
		preparacion.add(PreparacionAListo, BorderLayout.SOUTH);
		
		modeloListo = new DefaultListModel<Pedido>();
		listaListo = new JList(modeloListo);
		listaListo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollListo = new JScrollPane(listaListo);
		
		botonListoAPreparacion = new JButton("<<");
		botonListoAFinalizado= new JButton(">>");
		
		JPanel listoAOtros = new JPanel();
		listoAOtros.add(botonListoAPreparacion);
		listoAOtros.add(botonListoAFinalizado);

		listo.add(new JLabel("Listos..."), BorderLayout.NORTH);
		listo.add(scrollListo, BorderLayout.CENTER);
		listo.add(listoAOtros, BorderLayout.SOUTH);
		
		modeloFinalizado = new DefaultListModel<Pedido>();
		listaFinalizado = new JList(modeloFinalizado);
		listaFinalizado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollFinalizado = new JScrollPane(listaFinalizado);
		
		botonFinalizadoAListo = new JButton("<<");
		
		// TAREA4: Listeners de los botones
		
		// TAREA5: Hilo en listener de botonPreparacionAListo
		
		JPanel finalizadoAListo = new JPanel();
		finalizadoAListo.add(botonFinalizadoAListo);

		finalizado.add(new JLabel("Finalizados..."), BorderLayout.NORTH);
		finalizado.add(scrollFinalizado, BorderLayout.CENTER);	
		finalizado.add(finalizadoAListo, BorderLayout.SOUTH);	
		
		cp.add(preparacion);
		cp.add(listo);
		cp.add(finalizado);
		
		botonPreparacionAListo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pedido cambiar = listaPreparacion.getSelectedValue();
				modeloPreparacion.removeElement(cambiar);
				modeloListo.addElement(cambiar);
				actualizarEstadoPedido(cambiar, listo);
			}
		});
		botonListoAPreparacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pedido cambiar = listaListo.getSelectedValue();
				modeloListo.removeElement(cambiar);
				modeloPreparacion.addElement(cambiar);
			}
		});
		botonListoAFinalizado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pedido cambiar = listaListo.getSelectedValue();
				modeloListo.removeElement(cambiar);
				modeloFinalizado.addElement(cambiar);
			}
		});
		botonFinalizadoAListo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Pedido cambiar = listaFinalizado.getSelectedValue();
				modeloFinalizado.removeElement(cambiar);
				modeloListo.addElement(cambiar);
			}
		});
		
		
		this.setTitle("Preparación de pedidos");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(false);
	}
	
	public void recargarModelos(Deustea datos) {
		// TAREA4: Recargar modelos
		for(Pedido pCambiar: Deustea.pedidos) {
			if(pCambiar.getEstado().equals(Estado.PREPARACION)) {
				modeloPreparacion.addElement(pCambiar);
			} else if (pCambiar.getEstado().equals(Estado.LISTO)){
				modeloListo.addElement(pCambiar);
			} else {
				modeloFinalizado.addElement(pCambiar);
			}
		}
		actualizarBotones();
	}

	public void actualizarBotones() {
		if (modeloPreparacion.isEmpty()) {
			botonPreparacionAListo.setEnabled(false);
		} else {
			botonPreparacionAListo.setEnabled(true);
		}
		
		if (modeloListo.isEmpty()) {
			botonListoAPreparacion.setEnabled(false);
			botonListoAFinalizado.setEnabled(false);
		} else {
			botonListoAPreparacion.setEnabled(true);
			botonListoAFinalizado.setEnabled(true);
		}
		
		if (modeloFinalizado.isEmpty()) {
			botonFinalizadoAListo.setEnabled(false);
		} else {
			botonFinalizadoAListo.setEnabled(true);
		}
	}
	
}
