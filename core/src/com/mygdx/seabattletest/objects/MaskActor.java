package com.mygdx.seabattletest.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 19.01.2020.
 */

public class MaskActor extends Actor {

    private TextureRegion maskTexture;

    public MaskActor(GameAssets gameAssets) {
        maskTexture = gameAssets.circleMask;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(maskTexture, getX(), getY());
    }
}