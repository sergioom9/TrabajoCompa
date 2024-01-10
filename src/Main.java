/**
 * El paquete Logica contiene las clases relacionadas con la lógica del juego.
 */

import javax.swing.SwingUtilities;

/**
 * La clase Main es la clase principal que contiene el método main para iniciar la aplicación del juego.
 */
public class Main {

    /**
     * El método main inicia la aplicación del juego creando una instancia de Mapa y mostrando su interfaz gráfica.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crea una instancia de Mapa
            Mapa mapa = new Mapa();

            // Muestra la interfaz gráfica del mapa
            mapa.getGui().mostrarInterfaz();
        });
    }
}


