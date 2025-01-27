
package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamkhaos.game.utils.Temporizador;

public class PantallaJuego extends Screens {
    private Texture background;
    private SpriteBatch batch;
    public Temporizador timer;
    public int Tiempo = 5;
    public Main game;
    private Music escenemusic; // Para la música de fondo

    public PantallaJuego(Main game) {
        super(game);
        this.game = game;  // Guardamos la instancia de Main para acceder al temporizador
        escenemusic = Gdx.audio.newMusic(Gdx.files.internal("audio/audio_escenas.mp3"));

        // Configurar la música de fondo
        escenemusic.setLooping(true); // La música de fondo se repetirá en bucle
        escenemusic.setVolume(0.4f);  // Ajustar el volumen (0.0f a 1.0f)

        // Reproducir música de fondo
        escenemusic.play();
        // Cargar el fondo de pantalla del juego
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/centro.png"));


    }
//intentar guardar en variable para que no se pierda if pantalla 2 guarde tiepo  en a

    @Override
    public void update(float delta) {
        game.timer.update(delta);  // Usamos el temporizador global

        // Verificar si el juego ha terminado
        if (game.timer.isGameOver()) {
            escenemusic.stop();
            game.setScreen(new Ganaste(game)); // Cambiar a la pantalla de Game Over
        }
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Dibujar el fondo y el temporizador
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, screen_width, screen_height);
        game.timer.draw(spriteBatch);  // Dibujar el temporizador global
        spriteBatch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        batch.dispose();
        timer.dispose();
        escenemusic.stop();  // Detener la música
        escenemusic.dispose();  // Liberar el recurso de la música
    }
}
