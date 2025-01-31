package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
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

    public ImageButton btnUp = Assets.createDirectionalButton(Assets.btnUpTexture);
    public ImageButton btnDown = Assets.createDirectionalButton(Assets.btnDownTexture);
    public ImageButton btnLeft = Assets.createDirectionalButton(Assets.btnLeftTexture);
    public ImageButton btnRight = Assets.createDirectionalButton(Assets.btnRightTexture);
    public ImageButton btnCenter = Assets.createDirectionalButton(Assets.btnCentertexture);
    public ImageButton btnUp2 = Assets.createDirectionalButton(Assets.btnUpTexture2);
    public ImageButton btnDown2 = Assets.createDirectionalButton(Assets.btnDownTexture2);
    public ImageButton btnLeft2 = Assets.createDirectionalButton(Assets.btnLeftTexture2);
    public ImageButton btnRight2 = Assets.createDirectionalButton(Assets.btnRightTexture2);

    public Main game;
    public OrthographicCamera oCamUi;
    public OrthographicCamera oCamBOX2D;
    public SpriteBatch spriteBatch;
    public Stage stage;
    private List<ImageButton> buttons;
    private Sound clickSound;

    public Screens(Main game) {
        this.game = game;
        stage = new Stage(new StretchViewport(Screens.screen_width, Screens.screen_height));
        oCamUi = new OrthographicCamera(screen_width, screen_height);
        oCamUi.position.set(screen_width / 2f, screen_height / 2f, 0);
        oCamBOX2D = new OrthographicCamera(world_width, world_height);
        oCamBOX2D.position.set(world_width / 2f, world_height / 2f, 0);
        Gdx.input.setInputProcessor(new InputMultiplexer(stage));
        spriteBatch = new SpriteBatch();

        clickSound = Gdx.audio.newSound(Gdx.files.internal("audio/audio_boton.mp3"));

        buttons = new ArrayList<>(); // Inicializamos la lista de botones
        Assets.load(); // Cargar los recursos desde Assets
        createControls(); // Agregar los botones siempre visibles
    }

    private void createControls() {
        float btnSize = 40f; // Tamaño de los botones
        float margin = 20f; // Margen para evitar que los botones estén pegados al borde de la pantalla
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();


        btnUp.setSize(btnSize, btnSize);
        btnDown.setSize(btnSize, btnSize);
        btnLeft.setSize(btnSize, btnSize);
        btnRight.setSize(btnSize, btnSize);
        btnCenter.setSize(btnSize, btnSize);
        btnUp2.setSize(btnSize, btnSize);
        btnDown2.setSize(btnSize, btnSize);
        btnLeft2.setSize(btnSize, btnSize);
        btnRight2.setSize(btnSize, btnSize);

        // Posicionar los botones en los extremos de la pantalla
        btnUp.setPosition((screenWidth - btnSize) / 2, screenHeight - btnSize - margin); // Centro arriba
        btnDown.setPosition((screenWidth - btnSize) / 2, margin); // Centro abajo
        btnLeft.setPosition(margin, (screenHeight - btnSize) / 2); // Izquierda centro
        btnRight.setPosition(screenWidth - btnSize - margin, (screenHeight - btnSize) / 2); // Derecha centro
        btnCenter.setPosition((screenWidth - btnSize) / 2, (screenHeight - btnSize) / 2); // Centro de la pantalla
        btnUp2.setPosition((screenWidth - btnSize) / 2, screenHeight - btnSize - margin);
        btnDown2.setPosition((screenWidth - btnSize) / 2, margin); // Centro abajo
        btnLeft2.setPosition(margin, (screenHeight - btnSize) / 2); // Izquierda centro
        btnRight2.setPosition(screenWidth - btnSize - margin, (screenHeight - btnSize) / 2); // Derecha centro

        // Listeners para los botones
        btnUp.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaArriba(game));
            }
        });
        btnDown.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaAbajo(game));
            }
        });
        btnLeft.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaIzquierda(game));
            }
        });
        btnRight.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaDerecha(game));
            }
        });
        btnUp2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaJuego(game));
            }
        });
        btnDown2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaJuego(game));
            }
        });
        btnLeft2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaJuego(game));
            }
        });
        btnRight2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                clickSound.play();
                game.setScreen(new PantallaJuego(game));
            }
        });

        // Añadir los botones al escenario y a la lista
        stage.addActor(btnUp);
        stage.addActor(btnDown);
        stage.addActor(btnLeft);
        stage.addActor(btnRight);
        stage.addActor(btnUp2);
        stage.addActor(btnRight2);
        stage.addActor(btnLeft2);
        stage.addActor(btnDown2);





        buttons.add(btnUp);
        buttons.add(btnDown);
        buttons.add(btnLeft);
        buttons.add(btnRight);
        buttons.add(btnUp2);
        buttons.add(btnRight2);
        buttons.add(btnLeft2);
        buttons.add(btnDown2);

    }


    // Función para ocultar los botones
    public void hideButtons(boolean hide) {
        for (ImageButton button : buttons) {
            button.setVisible(!hide);
        }
    }
    // Función para ocultar botones específicos
    public void hideButtons2(boolean hide, ImageButton... buttonsToHide) {
        // Si no se especifican botones, no hacer nada
        if (buttonsToHide == null || buttonsToHide.length == 0) {
            return;
        }

        // Ocultar solo los botones especificados
        for (ImageButton button : buttonsToHide) {
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

    @Override
    public void dispose() {
        clickSound.dispose();
    }
}
