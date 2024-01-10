import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private BufferedImage backgroundImage;
    private MapaManager mapaManager;
    private MystiMonsterGUI gui;
    private List<Flecha> flechas;
    private String mapaActual;
    private int margin;
    private int arrowSize;

    private Monstruo monstruo;

    private Monstruo monstruoFuego;
    private Monstruo monstruoRoca;
    private Monstruo monstruoHidro;
    private List<Monstruo> monstruos;
    private Mochila mochila;
    private Entrenador entrenador;
    private int ataqueSeleccionado;
    public Mapa() {
        this.mapaManager = new MapaManager();
        this.gui = new MystiMonsterGUI(this);
        monstruos = new ArrayList<>();
        mochila = new Mochila();
        monstruos.add(new Monstruo("Hydroscuro", 100));
        cargarImagenes();
        flechas = new ArrayList<>();
        cargarFlechas();
        this.mapaActual = "Imagenes/mapa2.png";  // Establecer el mapa inicial
        monstruo = new Monstruo("Floraflame", "Imagenes/floraflame.png", 400, 300, 50, 50, "Imagenes/agua.png");
        monstruoFuego = new Monstruo("Igniverno", "Imagenes/igniverno.png", 200, 400, 50, 50, "Imagenes/fuego.png");
        monstruoRoca = new Monstruo("Rocluminis", "Imagenes/rocluminis.png", 400, 300, 50, 50, "Imagenes/maparoca.png");
        monstruoHidro = new Monstruo("Hidroscuro", "Imagenes/hidroscuro.png", 400, 300, 50, 50, "Imagenes/hidro.png");
    }

    private void cargarImagenes() {
        try {
            backgroundImage = ImageIO.read(new File("Imagenes/mapa2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) backgroundImage.getGraphics();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // Grosor de las flechas

        int arrowSize = 15;
        int margin = 70;

        // Flecha hacia arriba
        g2d.drawLine(backgroundImage.getWidth() / 2, margin, backgroundImage.getWidth() / 2, margin + arrowSize);
        g2d.drawLine(backgroundImage.getWidth() / 2, margin, backgroundImage.getWidth() / 2 - arrowSize / 2, margin + arrowSize);
        g2d.drawLine(backgroundImage.getWidth() / 2, margin, backgroundImage.getWidth() / 2 + arrowSize / 2, margin + arrowSize);

        // Flecha hacia abajo
       /* g2d.drawLine(backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin, backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin - arrowSize);
        g2d.drawLine(backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin, backgroundImage.getWidth() / 2 - arrowSize / 2, backgroundImage.getHeight() - margin - arrowSize);
        g2d.drawLine(backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin, backgroundImage.getWidth() / 2 + arrowSize / 2, backgroundImage.getHeight() - margin - arrowSize);*/

        // Flecha hacia la izquierda
        g2d.drawLine(margin, backgroundImage.getHeight() / 2, margin + arrowSize, backgroundImage.getHeight() / 2);
        g2d.drawLine(margin, backgroundImage.getHeight() / 2, margin + arrowSize, backgroundImage.getHeight() / 2 - arrowSize / 2);
        g2d.drawLine(margin, backgroundImage.getHeight() / 2, margin + arrowSize, backgroundImage.getHeight() / 2 + arrowSize / 2);

        // Flecha hacia la derecha
        g2d.drawLine(backgroundImage.getWidth() - margin, backgroundImage.getHeight() / 2, backgroundImage.getWidth() - margin - arrowSize, backgroundImage.getHeight() / 2);
        g2d.drawLine(backgroundImage.getWidth() - margin, backgroundImage.getHeight() / 2, backgroundImage.getWidth() - margin - arrowSize, backgroundImage.getHeight() / 2 - arrowSize / 2);
        g2d.drawLine(backgroundImage.getWidth() - margin, backgroundImage.getHeight() / 2, backgroundImage.getWidth() - margin - arrowSize, backgroundImage.getHeight() / 2 + arrowSize / 2);

        g2d.dispose();
    }

    private void cargarFlechas() {
        int arrowSize = 15;
        int margin = 70;

        // Flechas iniciales
        flechas.add(new Flecha(backgroundImage.getWidth() / 2, margin, arrowSize, Direccion.ARRIBA));
        flechas.add(new Flecha(backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin, arrowSize, Direccion.ABAJO));
        flechas.add(new Flecha(margin, backgroundImage.getHeight() / 2, arrowSize, Direccion.IZQUIERDA));
        flechas.add(new Flecha(backgroundImage.getWidth() - margin, backgroundImage.getHeight() / 2, arrowSize, Direccion.DERECHA));

    }

    public void actualizarMapa(int entrenadorX, int entrenadorY, int entrenadorWidth, int entrenadorHeight) {
        List<Flecha> flechasAEliminar = new ArrayList<>();

        for (Flecha flecha : flechas) {
            if (flecha.entrenadorEnContacto(entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight)) {
                switch (flecha.getDireccion()) {
                   /* case ABAJO:
                        if (mapaActual.equals("Imagenes/mapa2.png")) {
                            cargarNuevoMapa("Imagenes/agua.png");
                            monstruo.cambiarMapa("Imagenes/agua.png");
                            monstruo.cambiarMapa("Imagenes/agua.png");
                            mapaActual = "Imagenes/agua.png";
                        } else if (mapaActual.equals("Imagenes/agua.png")) {
                            cargarNuevoMapa("Imagenes/mapa2.png");
                            monstruo.cambiarMapa("Imagenes/mapa2.png");
                            monstruo.cambiarMapa("Imagenes/mapa2.png");
                            mapaActual = "Imagenes/mapa2.png";
                        }
                        break;*/
                    case IZQUIERDA:
                        if (mapaActual.equals("Imagenes/mapa2.png")) {
                            cargarNuevoMapa("Imagenes/maparoca.png");
                            monstruo.cambiarMapa("Imagenes/maparoca.png");
                            monstruoRoca.cambiarMapa("Imagenes/maparoca.png");
                            mapaActual = "Imagenes/maparoca.png";
                        } else if (mapaActual.equals("Imagenes/maparoca.png")) {
                            cargarNuevoMapa("Imagenes/mapa2.png");
                            monstruo.cambiarMapa("Imagenes/mapa2.png");
                            monstruoRoca.cambiarMapa("Imagenes/mapa2.png");
                            mapaActual = "Imagenes/mapa2.png";
                        }
                        break;
                    case ARRIBA:
                        if (mapaActual.equals("Imagenes/mapa2.png")) {
                            cargarNuevoMapa("Imagenes/hidro.png");
                            monstruo.cambiarMapa("Imagenes/hidro.png");
                            monstruoHidro.cambiarMapa("Imagenes/hidro.png");
                            mapaActual = "Imagenes/hidro.png";
                        } else if (mapaActual.equals("Imagenes/hidro.png")) {
                            cargarNuevoMapa("Imagenes/mapa2.png");
                            monstruo.cambiarMapa("Imagenes/mapa2.png");
                            monstruoHidro.cambiarMapa("Imagenes/mapa2.png");
                            mapaActual = "Imagenes/mapa2.png";
                        }
                        break;
                    case DERECHA:
                        if (mapaActual.equals("Imagenes/mapa2.png")) {
                            cargarNuevoMapa("Imagenes/fuego.png");
                            monstruo.cambiarMapa("Imagenes/fuego.png");
                            monstruoFuego.cambiarMapa("Imagenes/fuego.png");
                            mapaActual = "Imagenes/fuego.png";
                        } else if (mapaActual.equals("Imagenes/fuego.png")) {
                            cargarNuevoMapa("Imagenes/mapa2.png");
                            monstruo.cambiarMapa("Imagenes/mapa2.png");
                            monstruoFuego.cambiarMapa("Imagenes/mapa2.png");
                            mapaActual = "Imagenes/mapa2.png";
                        }
                        break;
                }
            }
        }

        // Verificar colision solo para el monstruo del mapa actual
        if (mapaActual.equals("Imagenes/mapa2.png")) {
            verificarColision(monstruo, entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        } else if (mapaActual.equals("Imagenes/agua.png")) {
            verificarColision(monstruo, entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        } else if (mapaActual.equals("Imagenes/maparoca.png")) {
            verificarColision(monstruoRoca, entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        } else if (mapaActual.equals("Imagenes/hidro.png")) {
            verificarColision(monstruoHidro, entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        } else if (mapaActual.equals("Imagenes/fuego.png")) {
            verificarColision(monstruoFuego, entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight);
        }

        // Eliminar las flechas marcadas para eliminación
        monstruo.dibujar((Graphics2D) backgroundImage.getGraphics());
        monstruoFuego.dibujar((Graphics2D) backgroundImage.getGraphics());
        monstruoRoca.dibujar((Graphics2D) backgroundImage.getGraphics());
        monstruoHidro.dibujar((Graphics2D) backgroundImage.getGraphics());
        flechas.removeAll(flechasAEliminar);
        flechas.add(new Flecha(backgroundImage.getWidth() / 2, backgroundImage.getHeight() - margin, arrowSize, Direccion.ABAJO));
    }


    private void verificarColisionConMonstruos(int entrenadorX, int entrenadorY, int entrenadorAncho, int entrenadorAlto) {
        for (Monstruo monstruo : monstruos) {
            verificarColision(monstruo, entrenadorX, entrenadorY, entrenadorAncho, entrenadorAlto);
        }
    }
    private void verificarColision(Monstruo monstruo, int entrenadorX, int entrenadorY, int entrenadorWidth, int entrenadorHeight) {
        if (monstruo.isVisible() && monstruo.colisionConEntrenador(entrenadorX, entrenadorY, entrenadorWidth, entrenadorHeight)) {
            mostrarMensajeMonstruo(monstruo);
            // Crear una instancia de VentanaAtaque y mostrarla
            VentanaAtaque ventanaAtaque = new VentanaAtaque();

            ventanaAtaque.mostrar();
        }
    }

    private void mostrarMensajeMonstruo(Monstruo monstruo) {
        monstruo.mostrarMensaje();
    }


    void cargarNuevoMapa(String rutaImagen) {
        try {
            backgroundImage = ImageIO.read(new File(rutaImagen));
            monstruo.cambiarMapa(rutaImagen);
            monstruoFuego.cambiarMapa(rutaImagen);
            monstruoRoca.cambiarMapa(rutaImagen);
            monstruoHidro.cambiarMapa(rutaImagen);

            // Agrega las siguientes líneas para dibujar los monstruos en la nueva ubicación del mapa
            Graphics2D g2d = (Graphics2D) backgroundImage.getGraphics();
            monstruo.dibujar(g2d);
            monstruoFuego.dibujar(g2d);
            monstruoRoca.dibujar(g2d);
            monstruoHidro.dibujar(g2d);
            g2d.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public MapaManager getMapaManager() {
        return mapaManager;
    }

    public MystiMonsterGUI getGui() {
        return gui;
    }
    public List<Monstruo> getMonstruos() {
        return monstruos;
    }
    private void mostrarVentanaAtaque(Monstruo monstruo) {
        // Lógica para mostrar la ventana de ataque y permitir al jugador seleccionar un ataque
        VentanaAtaque ventanaAtaque = new VentanaAtaque();

        ventanaAtaque.mostrar();

        // Después de que el jugador selecciona un ataque, puedes procesar la elección
        procesarAtaqueSeleccionado(ventanaAtaque.getAtaqueSeleccionado(), monstruo);
    }

    private void procesarAtaqueSeleccionado(int ataqueSeleccionado, Monstruo monstruo) {
        int vidaMonstruo = monstruo.getVida();
        int danoAtaque = 50; // Dano fijo por ahora, puedes ajustar según tus necesidades

        // Reducir la vida a la mitad si se selecciona el ataque 1 o el ataque 2
        if (ataqueSeleccionado == 1 || ataqueSeleccionado == 2) {
            vidaMonstruo -= danoAtaque ;
        } else {
            vidaMonstruo -= danoAtaque;
        }

        // Restar puntos de vida al monstruo
        monstruo.setVida(vidaMonstruo);

        // Verificar si el monstruo ha sido derrotado
        if (vidaMonstruo <= 0) {
            // Monstruo derrotado, mostrar mensaje y agregar a la mochila
            System.out.println("¡Monstruo derrotado!");
            mochila.agregarMonstruoCapturado(monstruo.getNombre());

            // Ocultar el monstruo del mapa
            monstruo.setVisible(false);

            // Mostrar mensaje de monstruo capturado
            mostrarMensajeMonstruoCapturado(monstruo.getNombre());
        }
    }


    private void mostrarMensajeMonstruoCapturado(String nombreMonstruo) {
        // Lógica para mostrar el mensaje de monstruo capturado en la interfaz gráfica
        System.out.println("¡" + nombreMonstruo + " capturado! Se ha añadido a tu mochila.");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mapa mapa = new Mapa();
            mapa.gui.mostrarInterfaz();
        });
    }
}