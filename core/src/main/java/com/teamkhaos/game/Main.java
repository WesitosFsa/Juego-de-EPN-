package com.teamkhaos.game;

import com.badlogic.gdx.Game;

public class Main extends Game {

    @Override
    public void create() {
        MenuPrincipal menuPrincipal = new MenuPrincipal(this);
        PantallaJuego pantallaJuego = new PantallaJuego(this);
        PantallaArriba pantallaArriba = new PantallaArriba(this);
        PantallaAbajo pantallaAbajo = new PantallaAbajo(this);
        PantallaIzquierda pantallaIzquierda = new PantallaIzquierda(this);
        PantallaDerecha pantallaDerecha = new PantallaDerecha(this);

        // Configurar conexiones entre pantallas
        pantallaJuego.setPantallaAdyacente("arriba", pantallaArriba);
        pantallaJuego.setPantallaAdyacente("abajo", pantallaAbajo);
        pantallaJuego.setPantallaAdyacente("izquierda", pantallaIzquierda);
        pantallaJuego.setPantallaAdyacente("derecha", pantallaDerecha);

        pantallaArriba.setPantallaAdyacente("abajo", pantallaJuego);
        pantallaAbajo.setPantallaAdyacente("arriba", pantallaJuego);
        pantallaIzquierda.setPantallaAdyacente("derecha", pantallaJuego);
        pantallaDerecha.setPantallaAdyacente("izquierda", pantallaJuego);

        // Establece la pantalla inicial
        setScreen(menuPrincipal);
    }
}
