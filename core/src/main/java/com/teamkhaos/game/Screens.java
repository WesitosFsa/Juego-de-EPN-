package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import java.util.HashMap;


public abstract class Screens extends InputAdapter implements Screen {
    public static final float screen_width = 800;
    public static final float screen_height = 480;

    public static final float world_height = 4.8f;
    public static final float world_width = 8f;

    public Main game; // Referencia a la clase principal del juego

    public OrthographicCamera oCamUi;
    public OrthographicCamera oCamBOX2D;

    public SpriteBatch spriteBatch;
    public Stage stage;
    private HashMap<String, Screens> pantallasAdyacentes;

    public Screens(Main game) {
        this.game = game; // Inicializamos la referencia al juego principal

        // Inicializar el stage con StretchViewport
        stage = new Stage(new StretchViewport(Screens.screen_width, Screens.screen_height));

        // Inicializar cámaras
        oCamUi = new OrthographicCamera(screen_width, screen_height);
        oCamUi.position.set(screen_width / 2f, screen_height / 2f, 0);

        oCamBOX2D = new OrthographicCamera(world_width, world_height);
        oCamBOX2D.position.set(world_width / 2f, world_height / 2f, 0);

        // Configurar InputMultiplexer para manejar eventos
        InputMultiplexer input = new InputMultiplexer(this, stage);
        Gdx.input.setInputProcessor(input);

        spriteBatch = new SpriteBatch();
        pantallasAdyacentes = new HashMap<>();
    }

    public void setPantallaAdyacente(String direccion, Screens pantalla) {
        pantallasAdyacentes.put(direccion, pantalla);
    }

    public void cambiarPantalla(String direccion) {
        if (pantallasAdyacentes.containsKey(direccion)) {
            game.setScreen(pantallasAdyacentes.get(direccion));
        }
    }

    // Método render que se llama cada frame
    public void render(float delta) {
        update(delta); // Actualiza la lógica
        stage.act(delta); // Actualiza el stage

        // Limpia la pantalla
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        draw(delta); // Dibuja contenido personalizado
        stage.draw(); // Dibuja el stage
    }

    public abstract void draw(float delta);
    public abstract void update(float delta);

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                cambiarPantalla("arriba");
                break;
            case Input.Keys.DOWN:
                cambiarPantalla("abajo");
                break;
            case Input.Keys.LEFT:
                cambiarPantalla("izquierda");
                break;
            case Input.Keys.RIGHT:
                cambiarPantalla("derecha");
                break;
            case Input.Keys.ESCAPE:
            case Input.Keys.BACK:
                if (this instanceof MenuPrincipal) {
                    Gdx.app.exit();
                } else {
                    game.setScreen(new MenuPrincipal(game));
                }
                break;
        }
        return super.keyDown(keycode);
    }
}
