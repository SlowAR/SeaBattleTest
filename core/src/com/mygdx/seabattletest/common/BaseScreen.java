package com.mygdx.seabattletest.common;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.seabattletest.objects.BackgroundActor;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.utils.GameUtils;
import com.mygdx.seabattletest.utils.ScreenListener;

/**
 * Created by SlowAR on 18.01.2020.
 */

public abstract class BaseScreen implements Screen {

    protected GameAssets gameAssets;
    protected ScreenListener screenListener;
    protected SpriteBatch spriteBatch;
    protected Stage stage;
    protected Skin skin;

    protected Actor backgroundActor;

    public BaseScreen(GameAssets gameAssets, ScreenListener screenListener) {
        this.gameAssets = gameAssets;
        this.screenListener = screenListener;
        stage = new Stage(new ExtendViewport(GameUtils.SCREEN_WIDTH_DEFAULT, GameUtils.SCREEN_HEIGHT_DEFAULT));
        skin = new Skin();
        skin.addRegions(gameAssets.uiSkinAtlas);
        skin.load(Gdx.files.internal("ui/uiskin.json"));

        Gdx.input.setInputProcessor(stage);
        spriteBatch = gameAssets.spriteBatch;

        setupGameObjects();
    }

    protected void setupGameObjects() {
        backgroundActor = new BackgroundActor(gameAssets);
        stage.addActor(backgroundActor);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        draw();
        spriteBatch.end();

        stage.act();
        stage.draw();

        spriteBatch.begin();
        lateDraw();
        spriteBatch.end();
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