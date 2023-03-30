package sibajaplay;

/**
 * @author Kevin Sibaja Granados
 * @author Yordany Navarro Hernandez
 * @author Diego Herrera Lopez
 * @author Jonathan Alfaro Herrera
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Kevin Sibaja Granados
 * @author Yordany Navarro Hernandez
 * @author Diego Herrera Lopez
 * @author Jonathan Alfaro Herrera
 *
 * Esta clase contiene algunos metodos para la ejecucion del programa y tambien
 * se ejecuta la "PaginaPrincipal" que es la interfaz del reproductor.
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static LinkedList<Cancion> list = new LinkedList();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Cancion cancion;

    /**
     *
     * @param args
     * @throws IOException
     * @throws JavaLayerException
     * @throws BasicPlayerException Aquí se ejecuta la "PaginaPrincipal" que es
     * la interfaz del reproductor.
     */
    public static void main(String[] args) throws IOException, JavaLayerException, BasicPlayerException {

        //Reproductor();
        PaginaPrincipal v = new PaginaPrincipal();
        v.setVisible(true);
        v.setLocationRelativeTo(null);

    }

    /**
     *
     * @throws IOException
     * @throws JavaLayerException
     * @throws BasicPlayerException
     * Aquí se declra la "rutaArchivo" la cual es donde se guardaran las rutas de 
     * las canciones seleccionadas. 
     * Y también muestra un menu, este menu no se esta usando ya que se implemento 
     * una interfaz la cual ejecuta los metodos.
     */
    public static void Reproductor() throws IOException, JavaLayerException, BasicPlayerException {
        String rutaArchivo = "";
        ReproductorMusica reproductor = new ReproductorMusica(rutaArchivo);

        boolean salir = false;

        while (!salir) {
            System.out.println("-------- Menú de Reproductor de Música --------");
            System.out.println("1. reproducir");
            System.out.println("2. pausar");
            System.out.println("3. detener");
            System.out.println("4. Reanudar");
            System.out.println("5. sigueinte ");
            System.out.println("6. anterior");
            System.out.println("7. añadir a la lista");
            System.out.println("8. aleatorio");
            System.out.println("9. Salir");
            System.out.print("Ingrese el número de opción que desea: ");

            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    reproductor.playMusic(cancion);

                    break;
                case 2:
                    reproductor.pauseMusic();

                    break;
                case 3:

                    reproductor.stopMusic();
                    break;
                case 4:
                    reproductor.resumeMusic();

                    break;
                case 5:

                    break;
                case 6:
                    break;
                case 7:
                    reproductor.addMusic();
                    for (Cancion cancion : list) {
                        System.out.println(cancion.toString());
                    }
                    break;
                case 8:
                    break;
                case 9:
                    reproductor.stopMusic();
                    salir = true;

                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

            System.out.println(); // Salto de línea para separar las opciones
        }

        System.out.println("Gracias por usar el Reproductor de Música.");
    }

}
