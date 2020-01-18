package com.mygdx.seabattletest.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.utils.GameUtils;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class BackgroundActor extends Actor {

    private TextureRegion background;

    public BackgroundActor(GameAssets gameAssets) {
        background = gameAssets.background;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(background, 0, 0, GameUtils.SCREEN_WIDTH_SPEC, GameUtils.SCREEN_HEIGHT_SPEC);
    }
}