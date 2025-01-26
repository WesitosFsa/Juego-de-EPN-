package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaDerecha extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture background; // Nueva textura para la imagen
    public int Tiempo = 5;
    public Main game;
    public PantallaDerecha(Main game) {
        super(game);
        this.game = game;  // Guardamos la instancia de Main para acceder al temporizador

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "DERECHA");

        // Cargar la imagen desde la ruta especificada
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/derecha.png"));
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
            game.setScreen(new GameOver(game)); // Cambiar a la pantalla de Game Over
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
