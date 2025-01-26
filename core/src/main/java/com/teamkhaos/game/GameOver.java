package com.teamkhaos.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends Screens {
    private Texture gameOverImage;
    private SpriteBatch batch;

    public GameOver(Main game) {
        super(game);
        gameOverImage = new Texture(Gdx.files.internal("IMGgame/boxmapping/meme.png"));
        batch = new SpriteBatch();
    }

    @Override
    public void draw(float delta) {
        batch.begin();
        batch.draw(gameOverImage, 0, 0, screen_width, screen_height);
        batch.end();
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
        gameOverImage.dispose();
        batch.dispose();
    }
}
