package com.teamkhaos.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.teamkhaos.game.utils.Temporizador;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    public Temporizador timer;
    public static Music escenemusic; // Ahora es una variable global estática    @Override
    public void create() {
        escenemusic = Gdx.audio.newMusic(Gdx.files.internal("audio/audio_escenas.mp3"));
        // Configurar la música de fondo
        escenemusic.setLooping(true); // La música de fondo se repetirá en bucle
        escenemusic.setVolume(0.4f);  // Ajustar el volumen (0.0f a 1.0f)

        Assets.load();
        timer = new Temporizador(1);
        setScreen(new MenuPrincipal(this));
    }

}
