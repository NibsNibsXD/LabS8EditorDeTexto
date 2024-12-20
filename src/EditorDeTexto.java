import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */


//LAB SEMANA 7 (LAB # 6)
//JORGE LUIS AGUIRRE SALAZAR 22341189 -  ING EN SISTEMAS COMPUTACIONALES / UNITEC SAN PEDRO SULA
//11/22/2024

public class EditorDeTexto extends JFrame {

    
    private JTextPane areaDeTexto;
    private JComboBox<String> comboFuentes;
    private JComboBox<Integer> comboTamanos;
    private JButton botonColor;
    private JButton botonNegrita;
    private JButton botonCursiva;
    private JButton botonGuardar;
    private JButton botonAbrir;
    private GestorArchivos gestorArchivos;
    private HistorialColores historialColores;
    
    
    
    public EditorDeTexto() {
        super("Editor de Texto");
        inicializarComponentes();
        gestorArchivos = new GestorArchivos(this, areaDeTexto);
    }

    private void inicializarComponentes() {
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        areaDeTexto = new JTextPane();
        JScrollPane scrollPaneTexto = new JScrollPane(areaDeTexto);

        
        JToolBar barraHerramientas = new JToolBar();

        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fuentes = ge.getAvailableFontFamilyNames();
        comboFuentes = new JComboBox<>(fuentes);
        comboFuentes.addActionListener(e -> cambiarFuente());

        
        
        
        Integer[] tamanos = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40};
        comboTamanos = new JComboBox<>(tamanos);
        comboTamanos.addActionListener(e -> cambiarTamano());

        
        botonColor = new JButton("Color");
        botonColor.addActionListener(e -> cambiarColor());

        
        botonNegrita = new JButton("Negrita");
        botonNegrita.addActionListener(e -> aplicarNegrita());
        botonCursiva = new JButton("Cursiva");
        botonCursiva.addActionListener(e -> aplicarCursiva());

        
        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(e -> guardarArchivo());
        botonAbrir = new JButton("Abrir");
        botonAbrir.addActionListener(e -> abrirArchivo());

        
        
        
      
        barraHerramientas.add(comboFuentes);
        barraHerramientas.add(comboTamanos);
        barraHerramientas.add(botonColor);
        barraHerramientas.add(botonNegrita);
        barraHerramientas.add(botonCursiva);
        barraHerramientas.add(botonGuardar);
        barraHerramientas.add(botonAbrir);

        
        historialColores = new HistorialColores(e -> colorSeleccionadoDelHistorial(e));

        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(barraHerramientas, BorderLayout.NORTH);
        panelPrincipal.add(scrollPaneTexto, BorderLayout.CENTER);
        panelPrincipal.add(historialColores, BorderLayout.WEST);

        
        setContentPane(panelPrincipal);
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditorDeTexto().setVisible(true);
        });
    }

    
    
    private void cambiarFuente() {
        String fuenteSeleccionada = (String) comboFuentes.getSelectedItem();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attr, fuenteSeleccionada);
        
        areaDeTexto.setCharacterAttributes(attr, false);
    }

    
    private void cambiarTamano() {
        int tamanoSeleccionado = (int) comboTamanos.getSelectedItem();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        
        StyleConstants.setFontSize(attr, tamanoSeleccionado);
        areaDeTexto.setCharacterAttributes(attr, false);
    }

    
    
    
    
    private void cambiarColor() {
        Color colorSeleccionado = JColorChooser.showDialog(this, "Seleccionar Color", Color.BLACK);
        
        if (colorSeleccionado != null) {
            SimpleAttributeSet attr = new SimpleAttributeSet();
            
            StyleConstants.setForeground(attr, colorSeleccionado);
            areaDeTexto.setCharacterAttributes(attr, false);

            // Agregar el color al historial
            historialColores.agregarColor(colorSeleccionado);
        }
    }

    
    
    
    private void colorSeleccionadoDelHistorial(ActionEvent e) {
        Color colorSeleccionado = (Color) e.getSource();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, colorSeleccionado);
        areaDeTexto.setCharacterAttributes(attr, false);
    }

    
    private void aplicarNegrita() {
        StyledDocument doc = areaDeTexto.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        
        boolean isBold = StyleConstants.isBold(areaDeTexto.getCharacterAttributes());
        StyleConstants.setBold(attr, !isBold);
        areaDeTexto.setCharacterAttributes(attr, false);
    }

    
    
    
    private void aplicarCursiva() {
        StyledDocument doc = areaDeTexto.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        boolean isItalic = StyleConstants.isItalic(areaDeTexto.getCharacterAttributes());
        StyleConstants.setItalic(attr, !isItalic);
        areaDeTexto.setCharacterAttributes(attr, false);
    }

    
    private void guardarArchivo() {
        gestorArchivos.guardarArchivo();
    }

    
    private void abrirArchivo() {
        gestorArchivos.abrirArchivo();
    }

    
    
}
