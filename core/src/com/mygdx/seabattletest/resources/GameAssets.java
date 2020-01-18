package com.mygdx.seabattletest.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.seabattletest.resources.Font;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class GameAssets {

    public SpriteBatch spriteBatch;
    public BitmapFont simpleFont;

    public GameAssets() {
        setupObjects();
    }

    private void setupObjects() {
        spriteBatch = new SpriteBatch();
        simpleFont = new BitmapFont(Gdx.files.internal(Font.SimpleFont));
    }

    public void dispose() {
        spriteBatch.dispose();
    }
}