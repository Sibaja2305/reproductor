/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sibajaplay;

/**
 *
 * @author Hp EliteBook
 */
public class Cancion {
     private String ruta;
     private String name;

    public Cancion(String ruta, String name) {
        this.ruta = ruta;
        this.name = name;
    }

    public Cancion() {
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cancion{" + "ruta=" + ruta + ", name=" + name + '}';
    }
     
     
}
