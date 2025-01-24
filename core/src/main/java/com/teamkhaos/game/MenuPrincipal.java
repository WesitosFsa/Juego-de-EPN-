package com.teamkhaos.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.teamkhaos.game.utils.learn;

public class MenuPrincipal extends Screens{

    ScrollPane scroll;

    public MenuPrincipal(Main game) {
        super(game);

        // Crear la tabla para el menu

        Table menu = new Table();
        menu.setFillParent(true);
        menu.defaults().uniform().fillY();

        // TODO: Agregar botones del menu

        for (final learn tutorial : learn.values()){
            TextButton bt1 = new TextButton(tutorial.name, Assets.txtButtonMenu);
            bt1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    // MenuPrincipal.this.game.setScreen();
                }
            });
            // Agregar al menu el boton bt1
            menu.row().padTop(20).height(50);
            menu.add(bt1).fillX();
        }

        scroll = new ScrollPane(menu, Assets.scrollPaneMenu);
        scroll.setSize(500, screen_height);
        scroll.setPosition(150, 0);
        stage.addActor(scroll);

    }

    @Override
    public void draw(float delta) {

    }

    @Override
    public void update(float delta) {

    }

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

    }
}
