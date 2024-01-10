/**
 * El paquete Logica contiene las clases relacionadas con la lógica del juego.
 */

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * La clase MapaManager proporciona métodos para gestionar y personalizar la lógica del mapa en el juego.
 */
public class MapaManager {

    /**
     * Dibuja imágenes específicas en el mapa utilizando el objeto Graphics proporcionado.
     *
     * @param g                 El objeto Graphics utilizado para dibujar en el mapa.
     * @param backgroundImage  La imagen de fondo del mapa.
     */
    public void drawMapSpecificImages(Graphics g, BufferedImage backgroundImage) {
        // Puedes agregar lógica específica del mapa aquí

        // Lógica para dibujar imágenes específicas en el mapa
        g.drawImage(backgroundImage, 0, 0, null);
    }
}
