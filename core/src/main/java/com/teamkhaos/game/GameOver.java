package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends Screens {
    private Texture gameOverImage;
    private SpriteBatch batch;
    // test de comit en la pantalla game over
    public GameOver(Main game) {
        super(game);
        hideButtons(true); // Ocultar los botones al cargar la pantalla de Game Over
        gameOverImage = new Texture(Gdx.files.internal("IMGgame/smiledog_gif_by_themask02-d73b63p.gif"));
        batch = new SpriteBatch();
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Dibujar el fondo y el temporizador
        spriteBatch.begin();
        spriteBatch.draw(gameOverImage, 0, 0, screen_width, screen_height);
        game.timer.draw(spriteBatch);  // Dibujar el temporizador global
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        // No se necesita actualizar nada por ahora
    }

    @Override
    public void show() {
        // Código adicional si se necesita al mostrar la pantalla
    }

    @Override
    public void pause() {
        // Código adicional si se necesita al pausar la pantalla
    }

    @Override
    public void resume() {
        // Código adicional si se necesita al reanudar la pantalla
    }

    @Override
    public void hide() {
        // Código adicional si se necesita al ocultar la pantalla
    }

    @Override
    public void dispose() {
        gameOverImage.dispose();
        batch.dispose();
    }
}
