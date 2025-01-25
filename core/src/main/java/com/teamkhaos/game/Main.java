package com.teamkhaos.game;

import com.badlogic.gdx.Game;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {

    @Override
    public void create() {
        Assets.load();

        setScreen(new MenuPrincipal(this));
    }

}
