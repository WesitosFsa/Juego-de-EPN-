package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuPrincipal extends Screens {

    private Skin skin;
    private Stage stage;

    public MenuPrincipal(Main game) {
        super(game);
    }

    @Override
    public void show() {
        // Carga del Skin
        skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
        skin.load(Gdx.files.internal("uiskin.json"));


        // Crear un botón "Continuar"
        TextButton continuarButton = new TextButton("Continuar", skin);
        continuarButton.setPosition(Screens.screen_width / 2f - continuarButton.getWidth() / 2f,
            Screens.screen_height / 2f - continuarButton.getHeight() / 2f);
        continuarButton.addListener(event -> {
            game.setScreen(new PantallaJuego(game)); // Cambia a la pantalla del juego
            return true;
        });

        // Añadir el botón al stage
        stage = new Stage(new ScreenViewport());
        stage.addActor(continuarButton);

        // Configurar el input processor para el stage
        Gdx.input.setInputProcessor(stage);
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
    public void draw(float delta) {
        stage.draw();
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
