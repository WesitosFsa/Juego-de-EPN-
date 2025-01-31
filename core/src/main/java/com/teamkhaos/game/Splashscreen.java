package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class Splashscreen extends Screens {
    private Texture logoImage;
    private SpriteBatch batch;
    private BitmapFont font;
    private GlyphLayout layout;
    private String message;

    public Splashscreen(Main game) {
        super(game);
        logoImage = new Texture(Gdx.files.internal("assets/IMGgame/Game_store.png")); // Imagen adicional
        batch = new SpriteBatch();
        font = new BitmapFont(); // Fuente predeterminada de LibGDX
        font.getData().setScale(1); // Escalar la fuente para que sea más visible
        layout = new GlyphLayout();
        message = "Desarrollado por Team Khaos";
        hideButtons(true);
        // Cambiar de pantalla después de 4 segundos
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.timer.reset();
                game.setScreen(new MenuPrincipal(game));
            }
        }, 4);
    }

    @Override
    public void draw(float delta) {
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        spriteBatch.begin();

        // Dibujar la imagen del logo más pequeña y centrada
        float logoWidth = logoImage.getWidth() * 0.1f; // Reducir al 50%
        float logoHeight = logoImage.getHeight() * 0.1f;
        float logoX = (screen_width - logoWidth) / 2;
        float logoY = (screen_height / 2); // Posicionada un poco arriba del texto
        spriteBatch.draw(logoImage, logoX, logoY, logoWidth, logoHeight);

        // Dibujar el mensaje centrado debajo de la imagen
        layout.setText(font, message);
        float textX = (screen_width - layout.width) / 2;
        float textY = logoY - 20; // Espacio entre el logo y el texto
        font.draw(spriteBatch, layout, textX, textY);

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
        logoImage.dispose();
        batch.dispose();
        font.dispose();
    }
}
