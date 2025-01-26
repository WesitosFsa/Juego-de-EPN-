package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends Screens {
    private Texture gameOverImage;
    private SpriteBatch batch;

    public GameOver(Main game) {
        super(game);
        hideButtons(true); // Ocultar los botones al cargar la pantalla de Game Over
        gameOverImage = new Texture(Gdx.files.internal("IMGgame/boxmapping/meme.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void draw(float delta) {
        batch.begin();
        batch.draw(gameOverImage, 0, 0, screen_width, screen_height);
        batch.end();
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
