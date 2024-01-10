import javax.swing.*;
import java.awt.*;

/**
 * La clase VentanaResultadoAtaque representa una ventana que muestra el resultado de un ataque.
 */
public class VentanaResultadoAtaque {
    private Monstruo monstruo; // Monstruo afectado por el ataque
    private int ataqueSeleccionado; // Número del ataque realizado

    /**
     * Constructor de la clase VentanaResultadoAtaque.
     *
     * @param monstruo          El Monstruo afectado por el ataque.
     * @param ataqueSeleccionado El número del ataque realizado.
     */
    public VentanaResultadoAtaque(Monstruo monstruo, int ataqueSeleccionado) {
        this.monstruo = monstruo;
        this.ataqueSeleccionado = ataqueSeleccionado;
    }

    /**
     * Método para mostrar la ventana de resultado de ataque.
     */
    public void mostrar() {
        // Crear el marco de la ventana de resultado
        JFrame ventanaResultado = new JFrame("Resultado del Ataque");

        // Crear un panel para agregar componentes
        JPanel panelResultado = new JPanel();

        // Crear etiqueta con el resultado del ataque
        JLabel etiquetaResultado = new JLabel("Ataque realizado: " + ataqueSeleccionado);
        JLabel etiquetaMensaje = new JLabel("Monstruo destruido y añadido a la mochila");

        // Agregar componentes al panel de resultado
        panelResultado.add(etiquetaResultado);
        panelResultado.add(etiquetaMensaje);

        // Configurar el marco de la ventana de resultado
        ventanaResultado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaResultado.setSize(300, 150);
        ventanaResultado.setLocationRelativeTo(null);
        ventanaResultado.add(panelResultado);
        ventanaResultado.setVisible(true);
    }
}
