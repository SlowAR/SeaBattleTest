package com.mygdx.seabattletest.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
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
    public TextureRegion ship;
    public TextureRegion circleMask;

    public ShaderProgram maskShader;

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

    private void setupShaders() {
        setupMaskShader();
    }

    private void setupMaskShader() {
        ShaderProgram.pedantic = false;
        maskShader = new ShaderProgram(Gdx.files.internal("shaders/mask.vert"), Gdx.files.internal("shaders/mask.frag"));
        if (!maskShader.isCompiled()) {
            System.err.println(maskShader.getLog());
            System.exit(0);
        }
        spriteBatch.setShader(maskShader);
        maskShader.setUniformi("u_mask", 1);
        Gdx.gl.glActiveTexture(Gdx.gl.GL_TEXTURE1);
        button.getTexture().bind();
        Gdx.gl.glActiveTexture(Gdx.gl.GL_TEXTURE0);
        ship.getTexture().bind();
    }

    public void loadTexturesRegions() {
        button = uiSkinAtlas.findRegion("button");

        background = textureAtlas.findRegion("background");
        ship = textureAtlas.findRegion("ship");
        circleMask = textureAtlas.findRegion("circle_mask");

        setupShaders();
    }

    public void dispose() {
        textureAtlas.dispose();
        maskShader.dispose();
        spriteBatch.dispose();
    }
}