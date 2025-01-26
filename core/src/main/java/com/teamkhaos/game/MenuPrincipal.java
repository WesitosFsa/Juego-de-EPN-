package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
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
    private SpriteBatch batch;    // Para dibujar las imágenes
    private float bg1X, bg2X;    // Posiciones de las capas
    private float bg1Speed = 0.1f; // Velocidad de movimiento de la capa 1
    private float bg2Speed = 0.05f; // Velocidad de movimiento de la capa 2


    public MenuPrincipal(Main game) {
        super(game);

        // Ocultar los botones de navegación
        hideButtons(true);

        // Cargar las imágenes de fondo
        background1 = new Texture(Gdx.files.internal("IMGgame/background_menu_near.png"));
        background2 = new Texture(Gdx.files.internal("IMGgame/background_menu_far.png"));
        batch = new SpriteBatch();
        // Inicializar las posiciones de las capas
        bg1X = 0;
        bg2X = 0;
        // Crear la tabla para el menú
        Table menu = new Table();
        menu.setFillParent(true);
        menu.defaults().uniform().fillY();

        for (final learn tutorial : learn.values()) {
            TextButton bt1 = new TextButton(tutorial.name, Assets.txtButtonMenu);
            bt1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.timer.reset();
                    game.setScreen(new PantallaJuego(game));
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
        // Mover las capas de fondo
        bg1X -= bg1Speed; // Capa más cercana se mueve más rápido
        bg2X -= bg2Speed; // Capa más lejana se mueve más lento

        // Si la capa alcanza el final de la pantalla, reiniciar su posición
        if (bg1X <= -screen_width) {
            bg1X = 0;
        }
        if (bg2X <= -screen_width) {
            bg2X = 0;
        }

        // Dibujar las capas de fondo
        oCamUi.update();
        spriteBatch.setProjectionMatrix(oCamUi.combined);
        spriteBatch.begin();


        spriteBatch.draw(background2, bg2X, 0, screen_width, screen_height); // Fondo lejano
        spriteBatch.draw(background2, bg2X + screen_width, 0, screen_width, screen_height); // Repetir fondo lejano
        spriteBatch.draw(background1, bg1X, 0, screen_width, screen_height); // Fondo cercano
        spriteBatch.draw(background1, bg1X + screen_width, 0, screen_width, screen_height); // Repetir fondo cercano
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
    }
}
