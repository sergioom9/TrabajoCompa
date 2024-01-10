/**
 * La clase AtaqueHandler proporciona métodos para manejar la ejecución de un ataque en el juego.
 * Puede personalizar la lógica de ataque según los requisitos específicos del juego.
 */

public class AtaqueHandler {

    /**
     * Simula la ejecución de un ataque en el juego.
     *
     * @param entrenador El objeto Entrenador que realiza el ataque.
     * @param mochila    La Mochila del Entrenador que se utiliza para almacenar el Monstruo derrotado.
     */
    public static void ejecutarAtaque(Entrenador entrenador, Mochila mochila) {
        // Simula la lógica del ataque
        // Puede personalizar esta lógica según los requisitos del juego
        System.out.println("Ataque mortal. Monstruo destruido y añadido a la mochila");

        // Se asume que hay un objeto Monstruo que representa al Monstruo derrotado
        Monstruo monstruo;
        monstruo = new Monstruo("Monstruo Derrotado");

        // Agrega el Monstruo derrotado a la mochila
        mochila.agregarMonstruo(monstruo);

        // Mueve al entrenador de vuelta al mapa principal
        entrenador.setLocation(mochila.MAPA_PRINCIPAL);
    }
}
