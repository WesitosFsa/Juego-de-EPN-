package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Assets {

    public static BitmapFont font;
    public static TextButton.TextButtonStyle txtButtonMenu;
    public static ScrollPane.ScrollPaneStyle scrollPaneMenu;

    // Botones direccionales
    public static TextureRegionDrawable btnUpTexture;
    public static TextureRegionDrawable btnDownTexture;
    public static TextureRegionDrawable btnLeftTexture;
    public static TextureRegionDrawable btnRightTexture;
    public static TextureRegionDrawable btnCentertexture;

    public static TextureRegionDrawable btnUpTexture2;
    public static TextureRegionDrawable btnDownTexture2;
    public static TextureRegionDrawable btnLeftTexture2;
    public static TextureRegionDrawable btnRightTexture2;

    public static void load() {
        font = new BitmapFont();

        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/ui.txt"));

        // Crear botones del menú
        NinePatchDrawable bt1 = new NinePatchDrawable(atlas.createPatch("bt1"));
        NinePatchDrawable bt2 = new NinePatchDrawable(atlas.createPatch("bt2"));
        txtButtonMenu = new TextButton.TextButtonStyle(bt1, bt2, null, font);

        // Estilo del scroll
        NinePatchDrawable knob = new NinePatchDrawable(atlas.createPatch("scroll"));
        scrollPaneMenu = new ScrollPane.ScrollPaneStyle(null, knob, knob, knob, knob);

        // Cargar texturas para los botones direccionales
        btnUpTexture = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_arriba.png")));
        btnDownTexture = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_abajo.png")));
        btnLeftTexture = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_izquierda.png")));
        btnRightTexture = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_derecha.png")));
        btnCentertexture = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_centro_arriba_abajo.png")));
        btnUpTexture2 = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_centro_arriba_abajo.png")));
        btnDownTexture2 = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_centro_arriba_abajo.png")));
        btnLeftTexture2 = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_centro_lados.png")));
        btnRightTexture2 = new TextureRegionDrawable(new TextureRegion(new com.badlogic.gdx.graphics.Texture("controls/boton_centro_lados.png")));
    }

    public static ImageButton createDirectionalButton(TextureRegionDrawable texture) {
        return new ImageButton(texture);
    }
}
