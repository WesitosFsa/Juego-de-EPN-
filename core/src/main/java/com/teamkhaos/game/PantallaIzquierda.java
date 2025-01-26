package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaIzquierda extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture image; // Nueva textura para la imagen

    public PantallaIzquierda(Main game) {
        super(game);

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "IZQUIERDA");

        // Cargar la imagen desde la ruta especificada
        image = new Texture(Gdx.files.internal("IMGgame/boxmapping/izquierda.png"));
    }

    @Override
    public void draw(float delta) {
        spriteBatch.begin();

        // Dibujar el texto en el centro de la pantalla
        font.draw(spriteBatch, layout, (screen_width - layout.width) / 2, (screen_height + layout.height) / 2);

        // Dibujar la imagen en el centro de la pantalla
        float imageX = (screen_width - image.getWidth()) / 2;
        float imageY = (screen_height - image.getHeight()) / 2;
        spriteBatch.draw(image, imageX, imageY);

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
        image.dispose(); // Liberar la memoria de la textura
    }
}
