package com.mygdx.seabattletest.ui.board.utils;

import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.utils.GameUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 19.01.2020.
 */

public class ShipPlacementGenerator implements PlacementGenerator {

    private GameRules gameRules;
    private int oldPositionX;
    private int oldPositionY;

    public ShipPlacementGenerator(GameRules gameRules) {
        this.gameRules = gameRules;
    }

    @Override
    public List<ShipData> generate() {
        List<ShipData> shipDataList = new ArrayList<>();
        List<ShipRuleInfo> shipRuleInfos = gameRules.getShipsTypes();

        for (ShipRuleInfo shipRuleInfo : shipRuleInfos) {
            for (int i = 0; i < shipRuleInfo.getAmount(); i++) {
                ShipData shipData = new ShipData(shipRuleInfo.getWidthCells(), shipRuleInfo.getHeightCells());
                shipData.setHorizontal(GameUtils.getRandomRange(0, 1) == 1);
                int x = oldPositionX = GameUtils.getRandomRange(0, gameRules.getBoardWidth() - shipData.getWidthCells());
                int y = oldPositionY = GameUtils.getRandomRange(0, gameRules.getBoardHeight() - shipData.getHeightCells());
                shipData.setCellPositionX(x);
                shipData.setCellPositionY(y);
                verifyPlacement(shipData, shipDataList);
                shipDataList.add(shipData);
                isRotatedForFix = false;
            }
        }
        return shipDataList;
    }

    public void verifyPlacement(ShipData currentShipData, List<ShipData> placedShips) {
        if (hasPlacementConflict(currentShipData, placedShips)) {
            fixPosition(currentShipData, placedShips);
        }
    }

    private boolean hasPlacementConflict(ShipData currentShipData, List<ShipData> placedShips) {
        boolean hasConflict = false;
        for (ShipData placedShip : placedShips) {
            hasConflict = currentShipData.isOverlaps(placedShip);
            if (hasConflict) {
                break;
            }
        }
        return hasConflict;
    }

    private boolean isRotatedForFix = false;

    private void fixPosition(ShipData currentShipData, List<ShipData> placedShips) {
        int boardLimitX = gameRules.getBoardWidth() - currentShipData.getWidthCells();
        int boardLimitY = gameRules.getBoardHeight() - currentShipData.getHeightCells();
        if (currentShipData.getCellPositionX() + 1 > boardLimitX) {
            currentShipData.setCellPositionX(0);
            if (currentShipData.getCellPositionY() + 1 > boardLimitY) {
                currentShipData.setCellPositionY(0);
            } else {
                currentShipData.setCellPositionY(currentShipData.getCellPositionY() + 1);
            }
        } else {
            currentShipData.setCellPositionX(currentShipData.getCellPositionX() + 1);
        }

        if (currentShipData.getCellPositionX() == oldPositionX && currentShipData.getCellPositionY() == oldPositionY) {
            if (isRotatedForFix) {
                GameUtils.printSeaBoard(gameRules, placedShips);
                throw new IllegalStateException("Cannot find the place for ship!");
            } else {
                currentShipData.setHorizontal(!currentShipData.isHorizontal());
                isRotatedForFix = true;
            }
        }

        verifyPlacement(currentShipData, placedShips);
    }
}