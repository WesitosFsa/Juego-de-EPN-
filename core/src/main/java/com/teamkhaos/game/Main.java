package com.teamkhaos.game;

import com.badlogic.gdx.Game;
import com.teamkhaos.game.utils.Temporizador;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public Temporizador timer;
    @Override
    public void create() {
        Assets.load();
        timer = new Temporizador(1);
        setScreen(new MenuPrincipal(this));
    }

}
