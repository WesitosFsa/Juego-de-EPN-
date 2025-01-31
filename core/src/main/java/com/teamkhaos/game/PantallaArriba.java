package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.util.Random;

public class PantallaArriba extends Screens {

    private BitmapFont font;
    private GlyphLayout layout;
    private Texture background; // Nueva textura para la imagen
    private Texture randomImage;  // Imagen que aparecerá aleatoriamente
    private Rectangle imageBounds; // Para controlar la posición y tamaño de la imagen
    private float imageScale = 0.1f; // Escala inicial de la imagen
    private float imageGrowthRate = 0.01f; // Tasa de crecimiento de la imagen
    private boolean isImageVisible = false; // Controla si la imagen está visible
    private boolean isWaitingForGameOver = false; // Controla si estamos esperando antes del game over
    private float gameOverWaitTime = 3f; // Tiempo de espera antes del game over
    private float timeUntilNextImage = 5f; // Tiempo hasta que aparezca la próxima imagen
    private Random random;
    public Main game;
    public PantallaArriba(Main game) {
        super(game);
        this.game = game;  // Guardamos la instancia de Main para acceder al temporizador
        hideButtons2(true, btnCenter,btnUp,btnLeft,btnRight,btnUp2,btnLeft2,btnRight2);
        font = new BitmapFont();
        layout = new GlyphLayout();
        layout.setText(font, "ARRIBA");

        // Cargar el fondo y la imagen aleatoria
        background = new Texture(Gdx.files.internal("IMGgame/boxmapping/arriba.png"));
        randomImage = new Texture(Gdx.files.internal("IMGgame/susto2.png"));
        imageBounds = new Rectangle(0, 0, randomImage.getWidth() * imageScale, randomImage.getHeight() * imageScale);

        random = new Random();
    }

    @Override
    public void draw(float delta) {
        // Configurar la cámara
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);

        // Dibujar el fondo
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, screen_width, screen_height);

        // Dibujar la imagen aleatoria si está visible
        if (isImageVisible) {
            // Calcular la posición centrada
            float centerX = (screen_width - imageBounds.width) / 2;
            float centerY = (screen_height - imageBounds.height) / 2;

            // Dibujar la imagen en el centro
            spriteBatch.draw(randomImage, centerX, centerY, imageBounds.width, imageBounds.height);
        }

        game.timer.draw(spriteBatch);  // Dibujar el temporizador global
        spriteBatch.end();
    }

    @Override
    public void update(float delta) {
        game.timer.update(delta);  // Usamos el temporizador global

        if (isWaitingForGameOver) {
            // Reducir el tiempo de espera antes del Game Over
            gameOverWaitTime -= delta;
            game.escenemusic.stop();
            game.escenemusic.dispose();
            if (gameOverWaitTime <= 0) {
                game.horrorsound.play();
                game.setScreen(new GameOver(game)); // Cambiar a la pantalla de Game Over después de esperar 3 segundos
            }
            return; // No procesar nada más mientras esperamos el Game Over
        }

        // Si la imagen está visible, hacerla crecer
        if (isImageVisible) {
            imageBounds.width = randomImage.getWidth() * imageScale;
            imageBounds.height = randomImage.getHeight() * imageScale;

            // Aumentar el tamaño de la imagen
            imageScale += imageGrowthRate;

            // Comprobar si la imagen alcanza el tamaño crítico
            if (imageBounds.height > screen_height * 0.5f) {
                // Iniciar el período de espera para el Game Over
                super.hideButtons(true);
                isWaitingForGameOver = true;
                isImageVisible = true;

                return;
            }
        }

        // Verificar si el jugador hizo clic en la imagen
        if (Gdx.input.isTouched() && isImageVisible) {
            float centerX = (screen_width - imageBounds.width) / 2;
            float centerY = (screen_height - imageBounds.height) / 2;
            if (imageBounds.contains(Gdx.input.getX() - centerX, screen_height - Gdx.input.getY() - centerY)) {
                isImageVisible = false; // Eliminar la imagen si se hace clic en ella
            }
        }

        // Verificar el temporizador para mostrar una nueva imagen aleatoria
        timeUntilNextImage -= delta;
        if (timeUntilNextImage <= 0) {
            isImageVisible = true; // Hacer visible la imagen
            imageScale = 0.1f; // Restablecer el tamaño de la imagen
            imageBounds.setWidth(randomImage.getWidth() * imageScale);
            imageBounds.setHeight(randomImage.getHeight() * imageScale);

            // Reiniciar el temporizador para la próxima aparición
            timeUntilNextImage = random.nextFloat() * 5 + 3; // Aparece después de 3-8 segundos aleatorios
        }

        if (game.timer.isGameOver()) {
            game.escenemusic.stop();
            game.WinSound.play();
            game.escenemusic.dispose();
            game.setScreen(new Ganaste(game)); // Cambiar a la pantalla de "Ganaste"
        }
    }

    @Override
    public void show() {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        font.dispose();
        background.dispose();
        randomImage.dispose(); // Liberar la memoria de la imagen
    }
}
