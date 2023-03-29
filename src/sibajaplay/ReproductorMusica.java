/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sibajaplay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Hp EliteBook
 */
public class ReproductorMusica implements Runnable {
    private String rutaArchivo;
    private Player player;
    private Thread thread;
    private boolean enPausa;
   private int posicion=0;

    public ReproductorMusica(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        this.enPausa = false;
    }

    public void reproducir() throws FileNotFoundException, JavaLayerException {
//        thread = new Thread(this);
//        thread.start();
 FileInputStream archivoMusica = new FileInputStream("C:\\Users\\Hp EliteBook\\OneDrive\\Documentos\\canciones\\Hit the Road Jack.mp3");
            player = new Player(archivoMusica);
            player.play();
    }

    public void detener() {
        if (player != null) {
            player.close();
        }
    }

    public void pausar() {
        posicion=player.getPosition();
        player.close();
       
    }

    public void reanudar() throws JavaLayerException {
        player.play(posicion);
        
    }

    public void run() {
        try {
            
            FileInputStream archivoMusica = new FileInputStream(rutaArchivo);
            player = new Player(archivoMusica);
            System.out.println(player.getPosition());
            while (player != null && !enPausa) {
                if (!player.play(1)) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al reproducir el archivo de música: " + e.getMessage());

    
        }
    }
}
