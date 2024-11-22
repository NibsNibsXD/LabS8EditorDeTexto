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
        

        
        Integer[] tamanos = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40};
        comboTamanos = new JComboBox<>(tamanos);
        

        
        botonColor = new JButton("Color");
        botonNegrita = new JButton("Negrita");
        botonCursiva = new JButton("Cursiva");

        // Botones de archivo
        botonGuardar = new JButton("Guardar");
        
        
        
        botonAbrir = new JButton("Abrir");
       

        
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
}