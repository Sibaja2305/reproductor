/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sibajaplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import static sibajaplay.main.br;
import static sibajaplay.main.list;

/**
 *
 * @author Hp EliteBook
 */
public class ReproductorMusica implements Runnable {

    private String rutaArchivo;
    private Player player;
    private Thread thread;
    private boolean enPausa;
    private int posicion = 1;

    public ReproductorMusica(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.enPausa = false;
    }

    public void reproducir() throws FileNotFoundException, JavaLayerException {
        thread = new Thread(this);
        thread.start();
// FileInputStream archivoMusica = new FileInputStream("C:\\Users\\yorda\\OneDrive\\Documentos\\Canciones sibajasPlay\\RagnBone Man  Human Official Video.mp3");
//            player = new Player(archivoMusica);
//            player.play();
    }

    public void detener() {
        if (player != null) {
            player.close();
        }
    }

    public void pausar() {
        posicion = player.getPosition();
        player.close();
        System.out.println(player.getPosition());
        enPausa = true;

    }

    public void reanudar() throws JavaLayerException {
        player.play(posicion);
        enPausa = false;

    }

    public void run() {
        try {
            System.out.println("Cual es el nombre de la cancion a reproducir");
            String nameSong = br.readLine();
            for (Cancion cancion : list) {
                if (cancion.getName().equals(nameSong)) {
                    FileInputStream archivoMusica = new FileInputStream(cancion.getRuta());
                    player = new Player(archivoMusica);
                }

            }

            player.play();

        } catch (Exception e) {
            System.out.println("Error al reproducir el archivo de música: " + e.getMessage());

        }
    }

    public void añadeCanciones() {
        System.out.println("entro");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de audio", "mp3", "wav"));
        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File[] archivosSeleccionados = fileChooser.getSelectedFiles();
            for (File archivo : archivosSeleccionados) {
                String nombre = archivo.getName();
                String ruta = archivo.getAbsolutePath();
                Cancion cancion = new Cancion(ruta, nombre);
                System.out.println(cancion.toString());
                list.add(cancion);
            }
        }

    }
}
