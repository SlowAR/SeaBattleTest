package com.mygdx.seabattletest.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class GameAssets {

    public SpriteBatch spriteBatch;
    public BitmapFont simpleFont;

    private TextureAtlas textureAtlas;
    public TextureAtlas uiSkinAtlas;
    public TextureRegion background;
    public TextureRegion button;

    public GameAssets() {
        setupObjects();
        loadTexturesRegions();
    }

    private void setupObjects() {
        spriteBatch = new SpriteBatch();
        //simpleFont = new BitmapFont(Gdx.files.internal(Font.SimpleFont));
        textureAtlas = new TextureAtlas(Gdx.files.internal("atlas/textures.atlas"));
        uiSkinAtlas = new TextureAtlas(Gdx.files.internal("ui/uiskin.atlas"));
    }

    public void loadTexturesRegions() {
        background = textureAtlas.findRegion("background");
        button = textureAtlas.findRegion("button");
    }

    public void dispose() {
        simpleFont.dispose();
        spriteBatch.dispose();
    }
}