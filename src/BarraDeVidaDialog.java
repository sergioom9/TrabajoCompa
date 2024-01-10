
/**
 * La clase BarraDeVidaDialog representa un cuadro de diálogo que muestra la barra de vida de un Monstruo.
 * Este cuadro de diálogo incluye el nombre del Monstruo, una barra de progreso que representa la vida actual del Monstruo
 * y un botón para cerrar el cuadro de diálogo.
 */

import javax.swing.*;
import java.awt.*;

public class BarraDeVidaDialog extends JDialog {

    /**
     * Crea un nuevo BarraDeVidaDialog.
     *
     * @param parent   El JFrame padre al que se asocia el cuadro de diálogo.
     * @param monstruo El Monstruo cuya barra de vida se muestra en el cuadro de diálogo.
     */
    public BarraDeVidaDialog(JFrame parent, Monstruo monstruo) {
        super(parent, "Barra de Vida", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(200, 100);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout());

        // Etiqueta que muestra el nombre del Monstruo
        JLabel label = new JLabel("Vida de " + monstruo.getNombre());
        panel.add(label, BorderLayout.NORTH);

        // Barra de progreso que representa la vida actual del Monstruo
        JProgressBar progressBar = new JProgressBar(0, monstruo.getVidaMaxima());
        progressBar.setValue(monstruo.getVidaActual());
        progressBar.setStringPainted(true);
        panel.add(progressBar, BorderLayout.CENTER);

        // Botón para cerrar el cuadro de diálogo
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(e -> dispose());
        panel.add(cerrarButton, BorderLayout.SOUTH);

        setContentPane(panel);
    }
}

