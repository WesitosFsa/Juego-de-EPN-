package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaArriba extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture background; // Nueva textura para la imagen
    public int Tiempo = 5;
    public Main game;
    public PantallaArriba(Main game) {
        super(game);
        this.game = game;  // Guardamos la instancia de Main para acceder al temporizador

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "ARRIBA");

        // Cargar la imagen desde la ruta especificada
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/arriba.png"));
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
    public void update(float delta) {
        game.timer.update(delta);  // Usamos el temporizador global

        // Verificar si el juego ha terminado
        if (game.timer.isGameOver()) {
            game.escenemusic.stop();
            game.escenemusic.dispose();
            game.setScreen(new Ganaste(game)); // Cambiar a la pantalla de Game Over
        }
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
        font.dispose();
        background.dispose(); // Liberar la memoria de la textura
    }
}
