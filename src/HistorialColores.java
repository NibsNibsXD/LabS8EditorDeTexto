import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */


public class HistorialColores extends JPanel {

    private ArrayList<Color> coloresUsados;
    private JPanel panelColores;
    private ActionListener listenerColorSeleccionado;
    
    

    public HistorialColores(ActionListener listenerColorSeleccionado) {
        this.listenerColorSeleccionado = listenerColorSeleccionado;
        coloresUsados = new ArrayList<>();
        inicializarComponentes();
    }
    
    

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        JLabel etiqueta = new JLabel("Colores usados:");
        add(etiqueta, BorderLayout.NORTH);

        
        panelColores = new JPanel();
        panelColores.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JScrollPane(panelColores), BorderLayout.CENTER);
    }

    
    
    public void agregarColor(Color color) {
        if (!coloresUsados.contains(color)) {
            coloresUsados.add(color);
            JButton botonColor = crearBotonColor(color);
            panelColores.add(botonColor);
            panelColores.revalidate();
            panelColores.repaint();
        }
    }

    
    
    private JButton crearBotonColor(Color color) {
        JButton boton = new JButton();
        boton.setBackground(color);
        boton.setPreferredSize(new Dimension(30, 30));
        boton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        boton.addActionListener(e -> {
            ActionEvent eventoColor = new ActionEvent(color, ActionEvent.ACTION_PERFORMED, "ColorSeleccionado");
            listenerColorSeleccionado.actionPerformed(eventoColor);
        });
        return boton;
    }
}
