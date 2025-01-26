package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;
import java.util.List;

public abstract class Screens implements Screen {
    public static final float screen_width = 800;
    public static final float screen_height = 480;
    public static final float world_height = 4.8f;
    public static final float world_width = 8f;

    public Main game;
    public OrthographicCamera oCamUi;
    public OrthographicCamera oCamBOX2D;
    public SpriteBatch spriteBatch;
    public Stage stage;
    private List<ImageButton> buttons;

    public Screens(Main game) {
        this.game = game;
        stage = new Stage(new StretchViewport(Screens.screen_width, Screens.screen_height));
        oCamUi = new OrthographicCamera(screen_width, screen_height);
        oCamUi.position.set(screen_width / 2f, screen_height / 2f, 0);
        oCamBOX2D = new OrthographicCamera(world_width, world_height);
        oCamBOX2D.position.set(world_width / 2f, world_height / 2f, 0);
        Gdx.input.setInputProcessor(new InputMultiplexer(stage));
        spriteBatch = new SpriteBatch();

        buttons = new ArrayList<>(); // Inicializamos la lista de botones
        Assets.load(); // Cargar los recursos desde Assets
        createControls(); // Agregar los botones siempre visibles
    }

    private void createControls() {
        float btnSize = 40f;
        float margin = 20f;
        float posX = margin;
        float posY = margin;

        ImageButton btnUp = Assets.createDirectionalButton(Assets.btnUpTexture);
        ImageButton btnDown = Assets.createDirectionalButton(Assets.btnDownTexture);
        ImageButton btnLeft = Assets.createDirectionalButton(Assets.btnLeftTexture);
        ImageButton btnRight = Assets.createDirectionalButton(Assets.btnRightTexture);
        ImageButton btnCenter = Assets.createDirectionalButton(Assets.btnCentertexture);

        btnUp.setSize(btnSize, btnSize);
        btnDown.setSize(btnSize, btnSize);
        btnLeft.setSize(btnSize, btnSize);
        btnRight.setSize(btnSize, btnSize);
        btnCenter.setSize(btnSize, btnSize);

        btnUp.setPosition(posX + btnSize, posY + btnSize * 2);
        btnDown.setPosition(posX + btnSize, posY);
        btnLeft.setPosition(posX, posY + btnSize);
        btnRight.setPosition(posX + btnSize * 2, posY + btnSize);
        btnCenter.setPosition(posX + btnSize, posY + btnSize);

        // Listeners para los botones
        btnUp.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PantallaArriba(game));
            }
        });
        btnDown.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PantallaAbajo(game));
            }
        });
        btnLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PantallaIzquierda(game));
            }
        });
        btnRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PantallaDerecha(game));
            }
        });
        btnCenter.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new PantallaJuego(game));
            }
        });

        // Añadir los botones al escenario y a la lista
        stage.addActor(btnUp);
        stage.addActor(btnDown);
        stage.addActor(btnLeft);
        stage.addActor(btnRight);
        stage.addActor(btnCenter);

        buttons.add(btnUp);
        buttons.add(btnDown);
        buttons.add(btnLeft);
        buttons.add(btnRight);
        buttons.add(btnCenter);
    }

    // Función para ocultar los botones
    public void hideButtons(boolean hide) {
        for (ImageButton button : buttons) {
            button.setVisible(!hide);
        }
    }

    public void render(float delta) {
        update(delta);
        stage.act(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        draw(delta);
        stage.draw();
    }

    public abstract void draw(float delta);
    public abstract void update(float delta);

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
