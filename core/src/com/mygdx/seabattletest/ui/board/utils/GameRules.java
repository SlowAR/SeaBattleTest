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

    public GameRules() {
        shipRuleInfos = new ArrayList<>();
    }

    public GameRules setBoardSize(int width, int height) {
        boardWidth = width;
        boardHeight = height;
        return this;
    }

    public GameRules addDefaultShipTypes() {
        shipRuleInfos.add(new ShipRuleInfo(1, 4, 1));
        shipRuleInfos.add(new ShipRuleInfo(1, 3, 2));
        shipRuleInfos.add(new ShipRuleInfo(1, 2, 3));
        shipRuleInfos.add(new ShipRuleInfo(1, 1, 4));
        return this;
    }

    public GameRules addShipType(int widthCells, int heightCells, int amount) {
        shipRuleInfos.add(new ShipRuleInfo(widthCells, heightCells, amount));
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
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
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
}