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
    private ShipData shipData;

    private int oneCellBorderOffset;
    private int boardHeight;

    public ShipActor(GameAssets gameAssets, GameRules gameRules) {
        this.gameAssets = gameAssets;
        shipData = new ShipData(0, 0);
        oneCellBorderOffset = gameRules.isHaveOneCellBorder() ? 2 : 0;
        boardHeight = gameRules.getBoardHeight() - (gameRules.isHaveOneCellBorder() ? 2 : 0);
    }

    public void applyShipData(ShipData shipData) {
        this.shipData = shipData;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (int i = shipData.getCellPositionY() + shipData.getHeightCells() - oneCellBorderOffset; i > shipData.getCellPositionY(); i--) {
            for (int j = shipData.getCellPositionX(); j < shipData.getCellPositionX() + shipData.getWidthCells() - oneCellBorderOffset; j++) {
                batch.draw(gameAssets.circleMask, Constants.BOARD_CELL_WIDTH * j, Constants.BOARD_CELL_HEIGHT * (boardHeight - i),
                        Constants.BOARD_CELL_WIDTH, Constants.BOARD_CELL_HEIGHT);
            }
        }
    }
}