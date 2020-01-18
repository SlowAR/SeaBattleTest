package com.mygdx.seabattletest.objects.ship;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class ShipData {

    private int cellPositionX;
    private int cellPositionY;
    private int widthCells;
    private int heightCells;

    public ShipData(int cellPositionX, int cellPositionY, int widthCells, int heightCells) {
        this.cellPositionX = cellPositionX;
        this.cellPositionY = cellPositionY;
        this.widthCells = widthCells;
        this.heightCells = heightCells;
    }

    public int getCellPositionX() {
        return cellPositionX;
    }

    public int getCellPositionY() {
        return cellPositionY;
    }

    public int getWidthCells() {
        return widthCells;
    }

    public int getHeightCells() {
        return heightCells;
    }
}