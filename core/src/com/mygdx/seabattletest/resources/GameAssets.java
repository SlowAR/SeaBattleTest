package com.mygdx.seabattletest.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.seabattletest.utils.GameUtils;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class GameAssets {

    public SpriteBatch spriteBatch;

    private TextureAtlas textureAtlas;
    public TextureAtlas uiSkinAtlas;
    public TextureRegion background;
    public TextureRegion button;

    public GameAssets() {
        setupObjects();
        loadTexturesRegions();
        GameUtils.initValues();
    }

    private void setupObjects() {
        spriteBatch = new SpriteBatch();
        textureAtlas = new TextureAtlas(Gdx.files.internal("atlas/textures.atlas"));
        uiSkinAtlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
    }

    public void loadTexturesRegions() {
        background = textureAtlas.findRegion("background");
        button = textureAtlas.findRegion("button");
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}