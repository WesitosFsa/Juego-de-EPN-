package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends Screens {
    private Texture gameOverImage;
    private SpriteBatch batch;
    private float timer; // Temporizador para cambiar de pantalla después de 4 segundos
    private Main game;

    public GameOver(Main game) {
        super(game);
        this.game = game;
        hideButtons(true); // Ocultar los botones al cargar la pantalla de Game Over
        gameOverImage = new Texture(Gdx.files.internal("IMGgame/perdiste.gif"));
        batch = new SpriteBatch();
        timer = 0; // Iniciamos el temporizador en 0
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Dibujar el fondo y el temporizador
        spriteBatch.begin();
        spriteBatch.draw(gameOverImage, 0, 0, screen_width, screen_height);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        // Actualizar el temporizador
        timer += delta; // Incrementamos el temporizador con el paso del tiempo

        // Si han pasado 4 segundos, cambiamos a la pantalla MenuPrincipal
        if (timer >= 6) {
            game.setScreen(new MenuPrincipal(game)); // Cambiar a la pantalla de menú
        }
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
