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

import java.awt.Menu;
//LOGICA DETRAS DE LAS PANTALLAS QUE NOS MUESTRA Y NOS SIRVE PARA REFERENCIAR MAS PANTALLAS COMO BASE

public abstract class Screens extends InputAdapter implements Screen {
    public static final float screen_width = 800;
    public static final float screen_height = 480;

    public static final float world_height = 4.8f;
    public static final float world_width = 8f;

    public Main game;

    public OrthographicCamera oCamUi;
    public OrthographicCamera oCamBOX2D;

    public SpriteBatch spriteBatch;
    public Stage stage;

    public Screens(Main game){
        this.game= game;
        // inicializar el stage se usa el strechviewport porque es sencillo
        stage = new Stage(new StretchViewport(Screens.screen_width,Screens.screen_height));
        // inicializo la camara
        oCamUi = new OrthographicCamera(screen_width,screen_height);
        //centrar la camara a la mitad
        oCamUi.position.set(screen_width / 2f,screen_height/2f,0);

        oCamBOX2D= new OrthographicCamera(world_width,world_height);
        //centrar la camara a la mitad
        oCamBOX2D.position.set(world_width / 2f,world_height/2f,0);
        // input adapter captura eventos y eso lo pasamos al stage el input multiplexer  ayuda a capturar estos eventos y tambien el stage captura eventos
        InputMultiplexer input = new InputMultiplexer(this,stage);
        //paso el imput e inicializo el spritebatch constructor listo
        Gdx.input.setInputProcessor(input);

        spriteBatch = new SpriteBatch();

    }

    //funcion render se llama 60 veces por segundo
    public void render(float delta){
        // nos va ayudar a actualizar todas las fisicas del juego
        update(delta);
        // va actualizar todas la animaciones de los eventos que esten dentro del stage
        stage.act(delta);
        //luego borrar all lo que este en la pantalla
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        draw(delta);

        stage.draw();
    }

    //tiempo
    public abstract void draw(float delta);
    public abstract void update(float delta);
    // si la pantalla cambia de tamaño
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height,true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.ESCAPE || keycode == Input.Keys.BACK){
            if (this instanceof MenuPrincipal){
                Gdx.app.exit();
            }else{
                game.setScreen(new MenuPrincipal(game));
            }
            //Si se esta en el menu principa salgo de la app
            //Si estoy en dentro de un tutorial regreso al menu principal
            //TODO : Implement later
        }
        return super.keyDown(keycode);
    }
}
