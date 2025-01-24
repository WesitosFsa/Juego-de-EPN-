package com.teamkhaos.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaJuego extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;

    public PantallaJuego(Main game) {
        super(game);
        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "CENTRO");
    }

    @Override
    public void draw(float delta) {
        spriteBatch.begin();
        font.draw(spriteBatch, layout, (screen_width - layout.width) / 2, (screen_height + layout.height) / 2);
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
    }
}
