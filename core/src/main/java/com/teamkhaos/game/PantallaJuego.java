
package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamkhaos.game.utils.Temporizador;

public class PantallaJuego extends Screens {
    private Texture background;
    private SpriteBatch batch;
    public Temporizador timer;
    public int Tiempo = 5;

    public PantallaJuego(Main game) {
        super(game);

        // Cargar el fondo de pantalla del juego
        background = new Texture(Gdx.files.internal("android/assets/IMGgame/boxmapping/centro.png"));


        // Inicializar el temporizador (5 minutos de duración)
        timer = new Temporizador(1);
    }


    @Override
    public void update(float delta) {
        timer.update(delta); // Actualizar el temporizador

        // Verificar si el juego ha terminado
        if (timer.isGameOver()) {
            game.setScreen(new GameOver(game)); // Cambiar a la pantalla de Game Over
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
        timer.draw(spriteBatch); // Asegúrate de que timer se dibuje aquí
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
    }
}
