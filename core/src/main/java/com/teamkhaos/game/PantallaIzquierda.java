package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.teamkhaos.game.utils.Temporizador;

public class PantallaIzquierda extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture backgorund; // Nueva textura para la imagen

    public PantallaIzquierda(Main game) {
        super(game);

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "IZQUIERDA");

        // Cargar la imagen desde la ruta especificada
        backgorund = new Texture(Gdx.files.internal("IMGgame/boxmapping/izquierda.png"));
    }

    @Override
    public void draw(float delta) {
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Dibujar el fondo y el temporizador
        spriteBatch.begin();
        spriteBatch.draw(backgorund, 0, 0, screen_width, screen_height);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {

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
        backgorund.dispose(); // Liberar la memoria de la textura
    }
}
