package com.mygdx.seabattletest.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class BoardActor extends Actor {

    private NinePatch boardNinePatch;

    public BoardActor(GameAssets gameAssets) {
        boardNinePatch = new NinePatch(gameAssets.button, 16, 16, 16, 16);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        boardNinePatch.draw(batch, getX(), getY(), getWidth(), getHeight());
    }
}