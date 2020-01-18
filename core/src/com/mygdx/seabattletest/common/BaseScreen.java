package com.mygdx.seabattletest.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 18.01.2020.
 */

public abstract class BaseScreen implements Screen {

    protected GameAssets gameAssets;
    protected SpriteBatch spriteBatch;
    protected Stage stage;
    protected Skin skin;

    public BaseScreen(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
        stage = new Stage(new ExtendViewport(800, 480));
        skin = new Skin();
        skin.add("default-font", gameAssets.simpleFont);
        skin.load(Gdx.files.internal("ui/uiskin.json"));

        spriteBatch = gameAssets.spriteBatch;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        draw();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        lateDraw();
    }

    public void draw() {
    }

    public void lateDraw() {
    }

    @Override
    public void resize(int width, int height) {
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
        skin.dispose();
        stage.dispose();
    }
}