import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * La clase VentanaMochila representa una ventana que muestra los elementos en la mochila del jugador.
 */
public class VentanaMochila extends JDialog {
    private Mochila mochila; // Referencia a la mochila del jugador

    /**
     * Constructor de la clase VentanaMochila.
     *
     * @param parent  El JFrame padre al que está asociada la ventana.
     * @param mochila La mochila del jugador que se va a mostrar.
     */
    public VentanaMochila(JFrame parent, Mochila mochila) {
        super(parent, "Mochila", true);
        this.mochila = mochila;
        this.setSize(300, 150);
        this.setLocationRelativeTo(parent);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dibujarElementosMochila(g);
            }
        };

        this.getContentPane().add(panel, BorderLayout.CENTER);

        // Agregar etiqueta para "Elementos de la mochila"
        JLabel etiquetaMochila = new JLabel("Elementos de la mochila: ");
        panel.add(etiquetaMochila);

        // Mostrar los nombres de los MystiMonsters en la mochila
        List<String> nombresMystiMonsters = mochila.obtenerNombresMonstruos();
        for (String nombre : nombresMystiMonsters) {
            JLabel etiquetaMonstruo = new JLabel(nombre);
            panel.add(etiquetaMonstruo);
        }
    }

    /**
     * Método privado para dibujar los elementos de la mochila.
     *
     * @param g El objeto Graphics utilizado para dibujar.
     */
    private void dibujarElementosMochila(Graphics g) {
        int mochilaX = this.getWidth() - mochila.getMochilaImage().getWidth();
        int mochilaY = 0;
        g.drawImage(mochila.getMochilaImage(), mochilaX, mochilaY, this);

        // Aquí puedes agregar lógica para dibujar elementos específicos de la mochila si los tienes
    }
}
