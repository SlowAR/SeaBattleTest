package com.mygdx.seabattletest.objects.ship;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class ShipActor extends Actor {

    private GameAssets gameAssets;
    private ShipData shipData;

    public ShipActor(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
        shipData = new ShipData(0, 0);
    }

    public void applyShipData(ShipData shipData) {
        this.shipData = shipData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (int i = shipData.getCellPositionY() + 1; i < shipData.getCellPositionY() + shipData.getHeightCells() - 1; i++) {
            for (int j = shipData.getCellPositionX() + 1; j < shipData.getCellPositionX() + shipData.getWidthCells() - 1; j++) {
                batch.draw(gameAssets.circleMask, Constants.BOARD_CELL_WIDTH * j, Constants.BOARD_CELL_HEIGHT * i,
                        Constants.BOARD_CELL_WIDTH, Constants.BOARD_CELL_HEIGHT);
            }
        }
    }
}