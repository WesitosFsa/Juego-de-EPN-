package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class PantallaIzquierda extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture background; // Fondo de pantalla
    private Texture dogTexture; // Imagen del perro

    private float elapsedTime; // Tiempo transcurrido desde que comenzó la animación
    private boolean reachedMaxSize = false; // Indica si la imagen alcanzó el tamaño máximo
    private float postMaxTime = 0f; // Tiempo transcurrido después de alcanzar el tamaño máximo

    private final float animationDuration = 6f; // Duración de la animación (6 segundos)
    private final float initialSize = 50f; // Tamaño inicial (pequeño)
    private final float maxSize = 200f; // Tamaño máximo (mediano)
    private final float postMaxDelay = 3f; // Tiempo adicional después de alcanzar el tamaño máximo

    public Main game;

    public PantallaIzquierda(Main game) {
        super(game);
        this.game = game;

        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "IZQUIERDA");

        // Cargar texturas
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/izquierda.png"));
        dogTexture = new Texture(Gdx.files.internal("IMGgame/DogMiddle-removebg-preview.png")); // Imagen del perro
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Calcular el tamaño actual en función del tiempo transcurrido
        float progress = Math.min(elapsedTime / animationDuration, 1f); // Progreso (0 a 1)
        float currentSize = initialSize + (maxSize - initialSize) * progress; // Tamaño interpolado

        // Verificar si alcanzó el tamaño máximo
        if (progress >= 1f) {
            reachedMaxSize = true;
        }

        // Coordenadas para centrar la imagen
        float dogX = (screen_width - currentSize) / 2f;
        float dogY = (screen_height - currentSize) / 2f;

        // Dibujar fondo y, si no está en otra pantalla, dibujar imagen
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, screen_width, screen_height); // Fondo

        if (!reachedMaxSize || postMaxTime < postMaxDelay) {
            spriteBatch.draw(dogTexture, dogX, dogY, currentSize, currentSize); // Imagen con tamaño animado
        }

        game.timer.draw(spriteBatch); // Temporizador
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        // Actualizar el tiempo transcurrido
        elapsedTime += delta;

        // Verificar si la imagen alcanzó el tamaño máximo
        if (reachedMaxSize) {
            // Ocultar los botones al alcanzar el tamaño máximo
            super.hideButtons(true);

            // Incrementar el tiempo después de alcanzar el tamaño máximo
            postMaxTime += delta;

            // Verificar si ha pasado el tiempo de espera adicional
            if (postMaxTime >= postMaxDelay) {
                game.setScreen(new GameOver(game)); // Cambiar a la pantalla de GameOver
            }
        }

        game.timer.update(delta);
    }

    @Override
    public void show() {
        // Reiniciar los valores cuando la pantalla se muestra nuevamente
        elapsedTime = 0f;
        reachedMaxSize = false;
        postMaxTime = 0f;
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        // Si la pantalla se oculta, liberar recursos relacionados con la animación (opcional)
    }

    @Override
    public void dispose() {
        font.dispose();
        background.dispose();
        dogTexture.dispose(); // Liberar memoria de la imagen
    }
}
