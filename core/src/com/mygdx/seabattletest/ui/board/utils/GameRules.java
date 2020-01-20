package com.mygdx.seabattletest.ui.board.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class GameRules {

    private int boardWidth;
    private int boardHeight;
    private List<ShipRuleInfo> shipRuleInfos;
    private boolean isHaveOneCellBorder;

    public GameRules() {
        shipRuleInfos = new ArrayList<>();
    }

    public GameRules setBoardSize(int width, int height) {
        boardWidth = width;
        boardHeight = height;
        return this;
    }

    public GameRules addDefaultShipTypes() {
        int additionalSize = isHaveOneCellBorder ? 2 : 0;
        shipRuleInfos.add(new ShipRuleInfo(1 + additionalSize, 4 + additionalSize, 1));
        shipRuleInfos.add(new ShipRuleInfo(1 + additionalSize, 3 + additionalSize, 2));
        shipRuleInfos.add(new ShipRuleInfo(1 + additionalSize, 2 + additionalSize, 3));
        shipRuleInfos.add(new ShipRuleInfo(1 + additionalSize, 1 + additionalSize, 4));
        return this;
    }

    public GameRules addShipType(int widthCells, int heightCells, int amount) {
        int additionalSize = isHaveOneCellBorder ? 2 : 0;
        shipRuleInfos.add(new ShipRuleInfo(widthCells + additionalSize, heightCells + additionalSize, amount));
        return this;
    }

    public GameRules setOneCellShipsBorder() {
        isHaveOneCellBorder = true;
        return this;
    }

    public GameRules build() {
        if (boardWidth <= 0) {
            throw new IllegalStateException("Board width cannot be less or equal zero!");
        }
        if (boardHeight <= 0) {
            throw new IllegalStateException("Board height cannot be less or equal zero!");
        }
        if (getShipsAmount() == 0) {
            throw new IllegalStateException("Board cannot exist without any ship!");
        }
        return this;
    }

    public int getBoardWidth() {
        return isHaveOneCellBorder ? (boardWidth + 2) : boardWidth;
    }

    public int getBoardHeight() {
        return isHaveOneCellBorder ? (boardHeight + 2) : boardHeight;
    }

    public List<ShipRuleInfo> getShipsTypes() {
        return shipRuleInfos;
    }

    public int getShipsAmount() {
        int ships = 0;
        for (ShipRuleInfo shipRuleInfo : shipRuleInfos) {
            ships += shipRuleInfo.getAmount();
        }
        return ships;
    }

    public boolean isHaveOneCellBorder() {
        return isHaveOneCellBorder;
    }
}