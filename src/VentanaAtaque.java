import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La clase VentanaAtaque representa una ventana de selección de ataques para el juego MystiMonsters.
 */
public class VentanaAtaque {

    private int ataqueSeleccionado; // Almacena el ataque seleccionado por el jugador.
    private ActionListener onAtaqueSeleccionadoListener; // Listener para manejar eventos de selección de ataque.

    /**
     * Constructor de la clase VentanaAtaque.
     */
    public VentanaAtaque() {
    }

    /**
     * Muestra la ventana de selección de ataques.
     */
    public void mostrar() {
        // Crear el marco de la ventana
        JFrame ventana = new JFrame("Ventana de Ataque");

        // Crear un panel para agregar componentes
        JPanel panel = new JPanel();

        // Crear etiqueta y botones
        JLabel etiqueta = new JLabel("Selecciona un ataque:");
        JButton ataque1 = new JButton("Ataque 1");
        JButton ataque2 = new JButton("Ataque 2");

        // Agregar componentes al panel
        panel.add(etiqueta);
        panel.add(ataque1);
        panel.add(ataque2);

        // Agregar acción al botón de Ataque 1
        ataque1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueSeleccionado = 1;  // Marcar que se ha seleccionado el Ataque 1
                System.out.println("Ataque 1 seleccionado");
                notificarSeleccion();

                mostrarResultadoAtaque();
                ventana.dispose();  // Cerrar la ventana de ataque después de seleccionar
            }
        });

        // Agregar acción al botón de Ataque 2
        ataque2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ataqueSeleccionado = 2;  // Marcar que se ha seleccionado el Ataque 2
                System.out.println("Ataque 2 seleccionado");
                notificarSeleccion();
                mostrarResultadoAtaque();
                ventana.dispose();  // Cerrar la ventana de ataque después de seleccionar
            }
        });

        // Configurar el marco de la ventana
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setSize(300, 150);
        ventana.setLocationRelativeTo(null);
        ventana.add(panel);
        ventana.setVisible(true);
    }

    /**
     * Establece el listener para manejar eventos de selección de ataque.
     *
     * @param listener El ActionListener que manejará los eventos de selección de ataque.
     */
    public void setOnAtaqueSeleccionadoListener(ActionListener listener) {
        this.onAtaqueSeleccionadoListener = listener;
    }

    /**
     * Notifica a los listeners que se ha seleccionado un ataque.
     */
    private void notificarSeleccion() {
        if (onAtaqueSeleccionadoListener != null) {
            onAtaqueSeleccionadoListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }

    /**
     * Muestra la ventana de resultado de ataque.
     */
    private void mostrarResultadoAtaque() {
        // Crear la ventana de resultado de ataque
        Monstruo monstruo = null; // Reemplazar con el objeto Monstruo real
        VentanaResultadoAtaque resultadoAtaque = new VentanaResultadoAtaque(monstruo, ataqueSeleccionado);
        resultadoAtaque.mostrar();
    }

    /**
     * Obtiene el ataque seleccionado por el jugador.
     *
     * @return El número del ataque seleccionado (1 o 2).
     */
    public int getAtaqueSeleccionado() {
        return ataqueSeleccionado;
    }
}
