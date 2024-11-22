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

public class EditorDeTexto extends JFrame {

    private JTextPane areaDeTexto;
    private JComboBox<String> comboFuentes;
    private JComboBox<Integer> comboTamanos;
    private JButton botonColor;
    private JButton botonNegrita;
    private JButton botonCursiva;
    private JButton botonGuardar;
    private JButton botonAbrir;

    public EditorDeTexto() {
        super("Editor de Texto");
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        areaDeTexto = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(areaDeTexto);

        
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

        
        
        
        setLayout(new BorderLayout());
        add(barraHerramientas, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EditorDeTexto().setVisible(true);
        });
    }
    
    private void cambiarFuente() {
        //fuente
    }

   
    private void cambiarTamano() {
        int tamanoSeleccionado = (int) comboTamanos.getSelectedItem();
        StyledDocument doc = areaDeTexto.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setFontSize(attr, tamanoSeleccionado);
        areaDeTexto.setCharacterAttributes(attr, false);
    }
   
    private void cambiarColor() {
        //el color con el if
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

    // Método para guardar el archivo
    private void guardarArchivo() {
        //pendiente hacer clase para el archivo
    }

    // Método para abrir un archivo
    private void abrirArchivo() {
        //igual ene sta
    }

    

}
