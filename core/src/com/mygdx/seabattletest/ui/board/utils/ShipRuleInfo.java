package com.mygdx.seabattletest.ui.board.utils;

/**
 * Created by SlowAR on 19.01.2020.
 */

public class ShipRuleInfo {

    private int widthCells;
    private int heightCells;
    private int amount;

    public ShipRuleInfo(int widthCells, int heightCells, int amount) {
        this.widthCells = widthCells;
        this.heightCells = heightCells;
        this.amount = amount;
    }

    public int getWidthCells() {
        return widthCells;
    }

    public int getHeightCells() {
        return heightCells;
    }

    public void changeSize(int widthCells, int heightCells) {
        this.widthCells = widthCells;
        this.heightCells = heightCells;
    }

    public int getAmount() {
        return amount;
    }
}