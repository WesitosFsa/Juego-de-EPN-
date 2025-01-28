package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.teamkhaos.game.utils.learn;

public class MenuPrincipal extends Screens {

    ScrollPane scroll;
    private Texture background1;  // Capa de fondo más cercana
    private Texture background2;  // Capa de fondo más lejana
    private Texture background3; // Capa extra
    private Texture Logo;
    private SpriteBatch batch;    // Para dibujar las imágenes
    private float bg1Y, bg2Y, bg3Y;    // Posiciones verticales de las capas
    private float bg1Speed = 0.5f;     // Velocidad de movimiento de la capa 1
    private float bg2Speed = 0.2f;     // Velocidad de movimiento de la capa 2
    private float bg3Speed = 0.1f;     // Velocidad de movimiento de la capa 3

    private Music menuMusic; // Para la música de fondo
    private Sound clickSound; // agregar efectos de sonido en los botones si se requiere
    public Main game;
    public MenuPrincipal(Main game) {
        super(game);
        this.game = game;  // Guardamos la instancia de Main para acceder al temporizador

        // Cargar los archivos de audio
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/audio_prueba.mp3"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("audio/audio_boton.mp3"));

        // Configurar la música de fondo
        menuMusic.setLooping(true); // La música de fondo se repetirá en bucle
        menuMusic.setVolume(0.4f);  // Ajustar el volumen (0.0f a 1.0f)

        // Reproducir música de fondo
        menuMusic.play();
        // Ocultar los botones de navegación
        hideButtons(true);

        // Cargar las imágenes de fondo
        background1 = new Texture(Gdx.files.internal("filtros/filtro1.png"));
        background2 = new Texture(Gdx.files.internal("filtros/filtro2.png"));
        background3 = new Texture(Gdx.files.internal("filtros/filtro3.png"));
        batch = new SpriteBatch();
        // Inicializar las posiciones de las capas
        bg1Y = 0;
        bg2Y = 0;
        bg3Y = 0;
        // Crear la tabla para el menú
        Table menu = new Table();
        menu.setFillParent(true);
        menu.defaults().uniform().fillY();

        for (final learn tutorial : learn.values()) {
            TextButton bt1 = new TextButton(tutorial.name, Assets.txtButtonMenu);
            bt1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.escenemusic.play();
                    clickSound.play();  // Reproducir el sonido al hacer clic
                    menuMusic.stop();  // Detener la música cuando se hace clic en el botón
                    game.timer.reset();
                    game.setScreen(new Historia(game));
                }
            });
            menu.row().padTop(20).height(50);
            menu.add(bt1).fillX();
        }

        // Botón para salir del juego
        TextButton exitButton = new TextButton("Salir", Assets.txtButtonMenu);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();  // Reproducir el sonido al hacer clic
                Gdx.app.exit();
            }
        });
        menu.row().padTop(20).height(50);
        menu.add(exitButton).fillX();

        scroll = new ScrollPane(menu, Assets.scrollPaneMenu);
        scroll.setSize(500, screen_height);
        scroll.setPosition(150, 0);
        stage.addActor(scroll);
    }

    @Override
    public void draw(float delta) {
        // Mover las capas de fondo hacia abajo
        bg1Y -= bg1Speed; // Capa más cercana se mueve más rápido
        bg2Y -= bg2Speed; // Capa más lejana se mueve más lento
        bg3Y -= bg3Speed; // Capa extra

        // Si la capa alcanza el final de la pantalla, reiniciar su posición
        if (bg1Y <= -screen_height) {
            bg1Y = 0;
        }
        if (bg2Y <= -screen_height) {
            bg2Y = 0;
        }
        if (bg3Y <= -screen_height) {
            bg3Y = 0;
        }

        // Dibujar las capas de fondo
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);
        spriteBatch.begin();

        // Fondo más lejano (background3)
        spriteBatch.draw(background3, 0, bg3Y, screen_width, screen_height);
        spriteBatch.draw(background3, 0, bg3Y + screen_height, screen_width, screen_height);

        // Fondo intermedio (background2)
        spriteBatch.draw(background2, 0, bg2Y, screen_width, screen_height);
        spriteBatch.draw(background2, 0, bg2Y + screen_height, screen_width, screen_height);

        // Fondo más cercano (background1)
        spriteBatch.draw(background1, 0, bg1Y, screen_width, screen_height);
        spriteBatch.draw(background1, 0, bg1Y + screen_height, screen_width, screen_height);

        spriteBatch.end();
    }
    @Override
    public void update(float delta) {}

    @Override
    public void show() {

    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}
    @Override
    public void hide() {}

    @Override
    public void dispose() {
        background1.dispose();  // Liberar memoria de las texturas
        background2.dispose();
        background3.dispose();
        menuMusic.stop();  // Detener la música
        menuMusic.dispose();  // Liberar el recurso de la música
        clickSound.dispose();  // Liberar el recurso del sonido de clic
    }
}
