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
 * @author Kevin Sibaja Granados
 * @author Yordany Navarro Hernandez
 * @author Diego Herrera Lopez
 * @author Jonathan Alfaro Herrera
 * 
 * Aquí se hace la declaración de algunas variables 
 */

public class ReproductorMusica implements Runnable {

    private String fileRute;

    private Thread thread;

    static BasicPlayer player = new BasicPlayer();
    static int indexSong;

    public ReproductorMusica(String rutaArchivo) {
        this.fileRute = rutaArchivo;

    }

    /**
     *
     * @param get
     * @throws FileNotFoundException
     * @throws JavaLayerException
     *
     * Este metodo es para dar inicio a la canción.
     */
    public void playMusic(Cancion get) throws FileNotFoundException, JavaLayerException {
        thread = new Thread(this);
        thread.start();

    }

    /**
     *
     * @throws BasicPlayerException
     *
     * Este metodo sirve para detener la canción que se esta reproduciendo en
     * ese momento.
     */
    public void stopMusic() throws BasicPlayerException {

        player.stop();
    }

    /**
     *
     * @throws BasicPlayerException
     *
     * Este metodo sirve para pausar la canción que se esta reproduciendo.
     */
    public void pauseMusic() throws BasicPlayerException {

        player.pause();

    }

    /**
     *
     * @throws JavaLayerException
     * @throws BasicPlayerException
     *
     * Este metodo sirve para reanudar la canción justamente donde se pauso la
     * música.
     */
    public void resumeMusic() throws JavaLayerException, BasicPlayerException {

        player.resume();

    }

    /**
     * Este metodo en hilo sirve para abrir y reproducir el archivo de audio
     * seleccionado.
     */
    public void run() {
        try {

            File rutaArhivo = new File(list.get(indexSong).getRuta());
            player.open(rutaArhivo);
            player.play();

        } catch (BasicPlayerException ex) {
            Logger.getLogger(ReproductorMusica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este metodo sirve para agregar canciones, las cuales se guardan en
     * "list".
     */
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

    /**
     *
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws BasicPlayerException
     *
     * Este metodo sirve para pasar a la siguiente canción que se encuentra en
     * la lista (list).
     */
    public void selectNextMusic() throws FileNotFoundException, JavaLayerException, BasicPlayerException {

        if (list != null && !list.isEmpty()) {
            if (indexSong < list.size() - 1) {
                indexSong++;
            } else {
                indexSong = 0;
            }
            player.stop();
            System.out.println(indexSong);
            playMusic(list.get(indexSong));
        }

    }

    /**
     *
     * @throws FileNotFoundException
     * @throws JavaLayerException
     * @throws BasicPlayerException
     *
     * Este metodo sirve para retroceder a la canción que se encuentra en la
     * lista (list).
     */
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

    /**
     *
     * @throws FileNotFoundException
     * @throws JavaLayerException
     *
     * Este metodo sirve para escoger una canción aleatoriamente dentro de la
     * lista (list).
     */
    public void SelectRandomMusic() throws FileNotFoundException, JavaLayerException {
        indexSong = (int) (Math.random() * list.size());
        playMusic(list.get(indexSong));
    }

}
