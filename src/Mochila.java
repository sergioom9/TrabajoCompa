/**
 * El paquete Logica contiene las clases relacionadas con la lógica del juego.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Mochila representa el inventario del entrenador que almacena monstruos capturados durante el juego.
 */
public class Mochila {

    /**
     * Punto que representa la ubicación principal de la mochila en el mapa.
     */
    public static final Point MAPA_PRINCIPAL = new Point(0, 0);

    private BufferedImage mochilaImage; // Imagen de la mochila
    private List<String> monstruosCapturados; // Lista de nombres de monstruos capturados

    /**
     * Crea una nueva instancia de la clase Mochila.
     */
    public Mochila() {
        cargarImagen();
        monstruosCapturados = new ArrayList<>();
    }

    private void cargarImagen() {
        try {
            mochilaImage = ImageIO.read(new File("Imagenes/mochila.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene la imagen de la mochila.
     *
     * @return La imagen de la mochila.
     */
    public BufferedImage getMochilaImage() {
        return mochilaImage;
    }

    /**
     * Método de ejemplo que no tiene un propósito claro. Puedes ajustarlo según las necesidades del juego.
     *
     * @return Siempre devuelve null.
     */
    public String getComponent() {
        return null;
    }

    /**
     * Agrega el nombre de un monstruo capturado a la lista de monstruos capturados en la mochila.
     *
     * @param nombreMonstruo El nombre del monstruo capturado.
     */
    public void agregarMonstruoCapturado(String nombreMonstruo) {
        monstruosCapturados.add(nombreMonstruo);
        System.out.println("Monstruo capturado: " + nombreMonstruo);
    }

    /**
     * Obtiene la lista de nombres de monstruos capturados.
     *
     * @return La lista de nombres de monstruos capturados.
     */
    public List<String> getMonstruosCapturados() {
        return monstruosCapturados;
    }

    /**
     * Método de ejemplo sin implementación real. Agrega la lógica necesaria para agregar un Monstruo a la mochila.
     *
     * @param monstruo El Monstruo a agregar a la mochila.
     */
    public void agregarMonstruo(Monstruo monstruo) {
        // Agrega la lógica para agregar el Monstruo a la mochila
    }

    /**
     * Obtiene una lista de nombres de monstruos. Este método no tiene una implementación válida y devuelve una lista vacía.
     *
     * @return Una lista de nombres de monstruos.
     */
    public List<String> obtenerNombresMonstruos() {
        List<String> nombresMonstruos = new ArrayList<>();
        Monstruo[] monstruos = new Monstruo[0];
        for (Monstruo monstruo : monstruos) {
            nombresMonstruos.add(monstruo.getNombre());
        }
        return nombresMonstruos;
    }
}
