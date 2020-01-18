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
    public TextureRegion circleMask;

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
        button = uiSkinAtlas.findRegion("button");

        background = textureAtlas.findRegion("background");
        circleMask = textureAtlas.findRegion("circle_mask");
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}