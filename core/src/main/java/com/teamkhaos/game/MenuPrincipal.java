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
    private Texture background;  // Imagen de fondo
    private SpriteBatch batch;   // Para dibujar la imagen de fondo

    public MenuPrincipal(Main game) {
        super(game);

        // Ocultar los botones de navegación
        hideButtons(true);

        // Cargar la imagen de fondo
        background = new Texture(Gdx.files.internal("IMGgame/background_menu.png"));
        batch = new SpriteBatch();

        // Crear la tabla para el menú
        Table menu = new Table();
        menu.setFillParent(true);
        menu.defaults().uniform().fillY();

        for (final learn tutorial : learn.values()) {
            TextButton bt1 = new TextButton(tutorial.name, Assets.txtButtonMenu);
            bt1.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
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
        batch.begin();
        batch.draw(background, 0, 0, screen_width, screen_height);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void update(float delta) {}

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
        background.dispose();
        batch.dispose();
    }
}
