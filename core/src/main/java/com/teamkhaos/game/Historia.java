package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class Historia extends Screens {
    private Texture winImage;
    private SpriteBatch batch;
    private BitmapFont font;
    private GlyphLayout layout;
    private String message;

    public Historia(Main game) {
        super(game);
        hideButtons(true); // Ocultar los botones al cargar la pantalla de Game Over
        winImage = new Texture(Gdx.files.internal("IMGgame/perdiste.gif"));
        batch = new SpriteBatch();
        font = new BitmapFont(); // Fuente predeterminada de LibGDX
        font.getData().setScale(1); // Escalar la fuente para que sea más visible
        layout = new GlyphLayout();
        message = "Se solicita guardia nocturno en la Escuela Politécnica Nacional\n" +
            "Los Poliperros informan: Existe un virus que enfermó a los poliperros...\n" +
            "No se sabe de momento el motivo de la infección";

        // Cambiar de pantalla después de 2 segundos
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.timer.reset();
                game.setScreen(new PantallaJuego(game));
            }
        }, 4);
    }

    @Override
    public void draw(float delta) {
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        spriteBatch.begin();
        spriteBatch.draw(winImage, 0, 0, screen_width, screen_height);
        layout.setText(font, message);
        font.draw(spriteBatch, layout, (screen_width - layout.width) / 2, (screen_height + layout.height) / 2);
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        // No se necesita actualizar nada por ahora
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
        winImage.dispose();
        batch.dispose();
        font.dispose();
    }
}
