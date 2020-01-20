package com.mygdx.seabattletest.objects.ship;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.ui.board.utils.GameRules;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class ShipActor extends Actor {

    private GameAssets gameAssets;
    private GameRules gameRules;
    private ShipData shipData;

    public ShipActor(GameAssets gameAssets, GameRules gameRules) {
        this.gameAssets = gameAssets;
        this.gameRules = gameRules;
        shipData = new ShipData(0, 0);
    }

    public void applyShipData(ShipData shipData) {
        this.shipData = shipData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (int i = shipData.getCellPositionY() + shipData.getHeightCells(); i > shipData.getCellPositionY(); i--) {
            for (int j = shipData.getCellPositionX(); j < shipData.getCellPositionX() + shipData.getWidthCells(); j++) {
                batch.draw(gameAssets.ship, Constants.BOARD_CELL_WIDTH * j, Constants.BOARD_CELL_HEIGHT * (gameRules.getBoardHeight() - i),
                        Constants.BOARD_CELL_WIDTH, Constants.BOARD_CELL_HEIGHT);
            }
        }
    }
}