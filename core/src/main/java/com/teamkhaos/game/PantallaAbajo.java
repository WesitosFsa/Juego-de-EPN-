package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaAbajo extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture background; // Nueva textura para la imagen

    public PantallaAbajo(Main game) {
        super(game);

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "ABAJO");

        // Cargar la imagen desde la ruta especificada
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/abajo.png"));
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);
        // Dibujar el fondo y el temporizador
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, screen_width, screen_height);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        // No es necesaria lógica adicional aquí
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
