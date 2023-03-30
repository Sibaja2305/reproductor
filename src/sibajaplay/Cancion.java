package sibajaplay;

/**
 *
 * @author Kevin Sibaja Granados
 * @author Yordany Navarro Hernandez
 * @author Diego Herrera Lopez
 * @author Jonathan Alfaro Herrera
 */
public class Cancion {

    private String ruta;
    private String name;

    public Cancion(String ruta, String name) {
        this.ruta = ruta;
        this.name = name;
    }

    /**
     * Este es el constructor vacio de Cancion.
     */
    public Cancion() {
    }

    /**
     * @return the ruta Estos son los get y set de Cancion con sus respectivos
     * datos.
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
