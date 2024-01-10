import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La clase VentanaBienvenida representa una ventana de bienvenida para el juego MystiMonsters.
 */
public class VentanaBienvenida extends JDialog {

    private JTextArea mensajeBienvenida; // Área de texto para el mensaje de bienvenida.

    /**
     * Constructor de la clase VentanaBienvenida.
     *
     * @param parent El JFrame padre al que está asociada la ventana.
     */
    public VentanaBienvenida(JFrame parent) {
        super(parent, "Bienvenida", true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(parent);

        // Configuración del mensaje de bienvenida
        this.mensajeBienvenida = new JTextArea("¡Bienvenido al juego MystiMonsters and go!\n"
                + "Estás en el mapa principal. Tu misión es capturar a todos los mystiMonsters posibles para acabar el juego.\n"
                + "Te presento al entrenador. Con él podrás capturar mystiMonsters y moverte por los distintos mapas.\n "
                + "También tendrás acceso a la mochila pulsando la letra 'C'. Podrás visualizar su contenido en el que aparecerán los mystiMonsters capturados.");
        this.mensajeBienvenida.setEditable(false);
        this.mensajeBienvenida.setLineWrap(true);
        this.mensajeBienvenida.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(mensajeBienvenida);

        // Configuración del diseño de la ventana
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Configuración del listener de teclado
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar keyTyped para este caso
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    dispose(); // Cerrar la ventana al presionar Enter
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar keyReleased para este caso
            }
        });

        // Configuración del botón de cerrar
        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana al hacer clic en el botón
            }
        });

        // Configuración del panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cerrarButton);

        // Agregar el panel de botones a la parte inferior de la ventana
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
}
