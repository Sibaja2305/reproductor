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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import static sibajaplay.main.br;
import static sibajaplay.main.list;

/**
 *
 * @author Kevin Sibaja Granados
 * @author Yordany Navarro Hernandez
 * @author Diego Herrera Lopez
 * @author Jonathan Alfaro Herrera
 */
public class ReproductorMusica implements Runnable {

    private String fileRute;

    private Thread thread;

    static BasicPlayer player = new BasicPlayer();
    static int indexSong;

    public ReproductorMusica(String rutaArchivo) {
        this.fileRute = rutaArchivo;

    }

    public void playMusic(Cancion get) throws FileNotFoundException, JavaLayerException {
        thread = new Thread(this);
        thread.start();

    }

    public void stopMusic() throws BasicPlayerException {

        player.stop();
    }

    public void pauseMusic() throws BasicPlayerException {

        player.pause();

    }

    public void resumeMusic() throws JavaLayerException, BasicPlayerException {

        player.resume();

    }

    public void run() {
        try {

            File rutaArhivo = new File(list.get(indexSong).getRuta());
            player.open(rutaArhivo);
            player.play();
            indexSong = list.indexOf(fileRute);

        } catch (BasicPlayerException ex) {
            Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void addMusic() {
        
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

                list.add(cancion);
            }
        }
        for (Cancion cancion : list) {
            System.out.println(cancion.toString());

        }

    }

    public void selectNextMusic() throws FileNotFoundException, JavaLayerException, BasicPlayerException {

        if (list != null && !list.isEmpty()) {
            if (indexSong < list.size() -1) {
                indexSong++;
            } else {
                indexSong = 0;
            }
            player.stop();
            System.out.println(indexSong);
            playMusic(list.get(indexSong));
        }

    }

    public void selectPreviousMusic() throws FileNotFoundException, JavaLayerException, BasicPlayerException {
        if (list != null && !list.isEmpty()) {
            if (indexSong > 0) {
                indexSong--;
            } else {
                indexSong = list.size() - 1;
            }
            player.stop();
            System.out.println(indexSong);
            playMusic(list.get(indexSong));
        }
    }

    public void SelectRandomMusic() throws FileNotFoundException, JavaLayerException {
        indexSong = (int) (Math.random() * list.size());
        playMusic(list.get(indexSong));
    }

}
