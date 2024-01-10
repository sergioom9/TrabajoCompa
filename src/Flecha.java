/**
 * La clase Flecha representa una flecha en el contexto del juego. La flecha tiene una posición
 * (coordenadas x, y), un tamaño, y una dirección en la que apunta.
 */

import java.awt.*;

public class Flecha {

    private int x, y; // Posición de la flecha
    private int size; // Tamaño de la flecha
    private Direccion direccion; // Dirección en la que apunta la flecha

    /**
     * Crea una nueva instancia de la clase Flecha.
     *
     * @param x         La coordenada x de la posición inicial de la flecha.
     * @param y         La coordenada y de la posición inicial de la flecha.
     * @param size      El tamaño de la flecha.
     * @param direccion La dirección en la que apunta la flecha.
     */
    public Flecha(int x, int y, int size, Direccion direccion) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.direccion = direccion;
    }

    /**
     * Dibuja la flecha en la posición especificada.
     *
     * @param g El objeto Graphics utilizado para dibujar la flecha.
     */
    public void dibujar(Graphics g) {
        // Implementa la lógica para dibujar la flecha en la posición (x, y)
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);

        // Dibuja una flecha simple
        int[] xPoints, yPoints;

        switch (direccion) {
            case ARRIBA:
                xPoints = new int[]{x, x + size / 2, x + size};
                yPoints = new int[]{y + size, y, y + size};
                break;
            case ABAJO:
                xPoints = new int[]{x, x + size / 2, x + size};
                yPoints = new int[]{y, y + size, y};
                break;
            case IZQUIERDA:
                xPoints = new int[]{x + size, x, x + size};
                yPoints = new int[]{y, y + size / 2, y + size};
                break;
            case DERECHA:
                xPoints = new int[]{x, x + size, x};
                yPoints = new int[]{y, y + size / 2, y + size};
                break;
            default:
                xPoints = new int[]{};
                yPoints = new int[]{};
        }

        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * Verifica si el entrenador está en contacto con la flecha.
     *
     * @param entrenadorX      La coordenada x del entrenador.
     * @param entrenadorY      La coordenada y del entrenador.
     * @param entrenadorWidth  El ancho del entrenador.
     * @param entrenadorHeight La altura del entrenador.
     * @return true si el entrenador está en contacto con la flecha, false de lo contrario.
     */
    public boolean entrenadorEnContacto(int entrenadorX, int entrenadorY, int entrenadorWidth, int entrenadorHeight) {
        return entrenadorX < x + size &&
                entrenadorX + entrenadorWidth > x &&
                entrenadorY < y + size &&
                entrenadorY + entrenadorHeight > y;
    }

    /**
     * Obtiene la dirección en la que apunta la flecha.
     *
     * @return La dirección de la flecha.
     */
    public Direccion getDireccion() {
        return direccion;
    }
}
