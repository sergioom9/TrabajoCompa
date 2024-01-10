import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monstruo {


    private BufferedImage imagen;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private String nombre;
    private String mapaAparicion;

    private boolean mensajeMostrado = false;

    private int vidaMaxima = 100;
    private int vidaActual = vidaMaxima;
    private int vida = 100;
    private int ataque;



    public Monstruo(String hydroscuro, int i) {
    }

    public Monstruo(String defeatedMonstruo) {
    }

    public void cambiarMapa(String nuevoMapa) {
        if (mapaAparicion.equals(nuevoMapa)) {
            aparecer();
        } else {
            desaparecer();
        }
    }

    public Monstruo(String nombre, String imagenPath, int x, int y, int width, int height, String mapaAparicion) {
        this.nombre = nombre;
        this.mapaAparicion = mapaAparicion;

        this.vidaMaxima = 100; // Establecer la vida máxima al crear el monstruo
        this.vidaActual = this.vidaMaxima;

        try {
            this.imagen = ImageIO.read(new File(imagenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = false;
    }

    public void dibujar(Graphics g) {
        if (visible) {
            g.drawImage(imagen, x, y, width, height, null);
            dibujarBarraVida(g);
        }
    }

    public void aparecer() {
        visible = true;
    }

    public void desaparecer() {
        visible = false;
        mensajeMostrado = false;  // Reiniciar para el próximo encuentro
    }


    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, width, height);
    }

    public boolean colisionConEntrenador(int entrenadorX, int entrenadorY, int entrenadorWidth, int entrenadorHeight) {
        Rectangle monstruoBounds = getBoundingBox();
        Rectangle entrenadorBounds = new Rectangle(entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        return monstruoBounds.intersects(entrenadorBounds);
    }


    public boolean isVisible() {
        return visible;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    private void dibujarBarraVida(Graphics g) {
        int barraWidth = 50;  // Ancho original de la barra de vida
        int barraHeight = 5;  // Altura de la barra de vida
        int vidaPorcentaje = (int) Math.ceil((double) vidaActual / vidaMaxima * barraWidth);

        // Ajusta el tamaño de la barra de vida si se seleccionó el ataque 1 o 2
        int ataqueSeleccionado = 0;
        if (ataqueSeleccionado == 1 || ataqueSeleccionado == 2) {
            barraWidth /= 2;  // Reduce el ancho a la mitad
        }

        g.setColor(Color.RED);
        g.fillRect(x, y - 10, barraWidth, barraHeight);  // Barra de vida completa en rojo
        g.setColor(Color.GREEN);
        g.fillRect(x, y - 10, vidaPorcentaje, barraHeight);  // Barra de vida actual en verde
    }

    public void recibirDanio(int danio) {
        vidaActual -= danio;
        if (vidaActual <= 0) {
            desaparecer();
            JOptionPane.showMessageDialog(null, "¡Has derrotado a " + nombre + "!");
        }
    }

    public int getAtaque() {
        return ataque; // Reemplaza 'ataque' con el atributo real que almacena la potencia de ataque del monstruo
    }


    public void mostrarMensaje() {
        JOptionPane.showMessageDialog(null, "¡Te has encontrado con " + nombre + "!");
    }

    public String getNombre() {
        return nombre;
    }

    public void desaparecerYCapturar() {
        this.desaparecer();
        JOptionPane.showMessageDialog(null, "¡Has capturado a " + nombre + "!");
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int nuevaVida) {
        this.vida = nuevaVida;
    }

    // Método para establecer la visibilidad del monstruo
    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public void recibirAtaque(int cantidadDanio) {
        // Verifica que el monstruo esté vivo antes de recibir el ataque
        if (vida > 0) {
            // Reducir la vida a la mitad
            vida -= cantidadDanio / 2;

            // Asegurarse de que la vida no sea negativa
            if (vida < 0) {
                vida = 0;
            }
        }

    }
}