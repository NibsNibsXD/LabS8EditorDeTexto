import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */

public class GestorArchivos {

    private JFrame framePadre;
    private JTextPane areaDeTexto;

    
    public GestorArchivos(JFrame framePadre, JTextPane areaDeTexto) {
        this.framePadre = framePadre;
        this.areaDeTexto = areaDeTexto;
    }

    
    
    
    public void guardarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showSaveDialog(framePadre);
        
        
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (FileOutputStream fos = new FileOutputStream(archivo)) {
                RTFEditorKit kit = new RTFEditorKit();
                kit.write(fos, areaDeTexto.getDocument(), 0, areaDeTexto.getDocument().getLength());
                JOptionPane.showMessageDialog(framePadre, "Archivo guardado exitosamente.");
                
                
            } catch (IOException | BadLocationException ex) {
                JOptionPane.showMessageDialog(framePadre, "Error al guardar el archivo: " + ex.getMessage());
            }
        }
    }

    
    public void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showOpenDialog(framePadre);
        
        
        if (opcion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(archivo)) {
                RTFEditorKit kit = new RTFEditorKit();
                StyledDocument doc = (StyledDocument) kit.createDefaultDocument();
                kit.read(fis, doc, 0);
                
                areaDeTexto.setDocument(doc);
                JOptionPane.showMessageDialog(framePadre, "Archivo abierto exitosamente.");
            } catch (IOException | BadLocationException ex) {
                JOptionPane.showMessageDialog(framePadre, "Error al abrir el archivo: " + ex.getMessage());
            }
        }
    }
}