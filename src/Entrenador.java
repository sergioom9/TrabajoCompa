/**
 * La clase Entrenador representa al personaje principal del juego que puede moverse en un mapa,
 * interactuar con monstruos y utilizar habilidades especiales.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Entrenador extends JPanel {

    /**
     * Punto que representa la ubicación inicial del Entrenador en el mapa principal.
     */
    public static final Point MAPA_PRINCIPAL = new Point(0, 0);

    private BufferedImage entrenadorImage; // Imagen del entrenador
    private int x, y; // Posición del entrenador en el mapa
    private Mapa mapa; // Referencia al mapa del juego
    private Mochila mochila; // Mochila del entrenador para almacenar objetos y monstruos

    private Monstruo monstruoActual; // Monstruo actualmente enfrentado por el entrenador

    private int vidaMaxima; // Vida máxima del entrenador
    private int vidaActual; // Vida actual del entrenador

    /**
     * Crea una nueva instancia de la clase Entrenador.
     *
     * @param mapa El mapa en el que se encuentra el entrenador.
     */
    public Entrenador(Mapa mapa) {
        this.mapa = mapa;
        this.mochila = new Mochila();

        vidaMaxima = 100; // Puedes ajustar este valor según sea necesario
        vidaActual = vidaMaxima;

        // Carga la imagen del entrenador desde el archivo
        try {
            entrenadorImage = ImageIO.read(new File("Imagenes/entrenador.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 100;
        y = 100;

        // Configuración del panel
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // No es necesario implementar keyTyped para este caso
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'c' || e.getKeyChar() == 'C') {
                    mostrarMochila();
                } else {
                    moverEntrenador(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // No es necesario implementar keyReleased para este caso
            }
        });

        // Configuración del temporizador para repintar el panel
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        }, 0, 16);
    }

    // Resto de la implementación omitida para brevedad...



    private void moverEntrenador(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int speed = 5;

        if (keyCode == KeyEvent.VK_LEFT) {
            x -= speed;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            x += speed;
        } else if (keyCode == KeyEvent.VK_UP) {
            y -= speed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            y += speed;
        }

        repaint();
        mapa.actualizarMapa(x, y, entrenadorImage.getWidth(), entrenadorImage.getHeight());
    }

    private void mostrarMochila() {
        VentanaMochila ventanaMochila = new VentanaMochila((JFrame) SwingUtilities.getWindowAncestor(this), mochila);
        ventanaMochila.setVisible(true);
    }

    private void atacarLanzallamas() {
        if (monstruoActual != null && monstruoActual.isVisible()) {
            monstruoActual.recibirDanio(monstruoActual.getVidaMaxima() / 2);
            JOptionPane.showMessageDialog(null, "¡Has usado Ataque Lanzallamas!\n" +
                    "¡" + monstruoActual.getNombre() + " ha recibido daño!");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mapa.getBackgroundImage(), 0, 0, this); // Dibuja el fondo del mapa
        g.drawImage(entrenadorImage, x, y, this);

        dibujarBarraDeVida(g);
    }

    public void recibirDanio(int danio) {
        vidaActual -= danio;
        if (vidaActual <= 0) {
            // Realizar acciones si la vida llega a cero (por ejemplo, reiniciar juego)
        }
        repaint(); // Actualizar la barra de vida al recibir daño
    }


    private void dibujarBarraDeVida(Graphics g) {
        int barraWidth = 100;
        int barraHeight = 10;

        g.setColor(Color.RED);
        g.fillRect(x, y - 15, barraWidth, barraHeight);  // Barra de vida completa en rojo
        g.setColor(Color.GREEN);
        int vidaPorcentaje = (int) Math.ceil((double) vidaActual / vidaMaxima * barraWidth);
        g.fillRect(x, y - 15, vidaPorcentaje, barraHeight);  // Barra de vida actual en verde
    }

    public Mochila getMochila() {
        return mochila;
    }
}
