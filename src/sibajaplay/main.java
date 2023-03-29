/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sibajaplay;

/**
 *
 * @author Hp EliteBook
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
public class main {

    /**
     * @param args the command line arguments
     */
    
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws  IOException, JavaLayerException {
       
        Reproductor();
         
        
    }
     public static void Reproductor() throws IOException, JavaLayerException {
          String rutaArchivo ="C:\\Users\\Hp EliteBook\\OneDrive\\Documentos\\canciones\\Hit the Road Jack.mp3";
        ReproductorMusica reproductor =new ReproductorMusica (rutaArchivo);
        
        LinkedList generada = new LinkedList();
        

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
            
            int opcion =Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    reproductor.reproducir();
                    
                    break;
                case 2:
                    reproductor.pausar();
                    
                    break;
                case 3:
                   
                    reproductor.detener();
                    break;
                case 4:
                    reproductor.reanudar();
                   
                    break;
                case 5:
                   
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
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
