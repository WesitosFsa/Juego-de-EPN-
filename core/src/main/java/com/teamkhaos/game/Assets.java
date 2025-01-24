package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public class Assets {

    // Crear variable font
    public static BitmapFont font;
    // Crear boton
    public static TextButton.TextButtonStyle txtButtonMenu;
    // Crear scroll
    public static ScrollPane.ScrollPaneStyle scrollPaneMenu;


    // Inicizalizar variables
    public static void load(){
        font = new BitmapFont();

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("android/assets/data/ui.txt"));

        //Crear los botones

        NinePatchDrawable bt1 = new NinePatchDrawable(atlas.createPatch("bt1"));
        NinePatchDrawable bt2 = new NinePatchDrawable(atlas.createPatch("bt2"));
        txtButtonMenu = new TextButton.TextButtonStyle(bt1, bt2, null, font);

        // Estilo scroll

        NinePatchDrawable knob = new NinePatchDrawable(atlas.createPatch("scroll"));
        scrollPaneMenu = new ScrollPane.ScrollPaneStyle(null, knob, knob, knob, knob);
    }
}































