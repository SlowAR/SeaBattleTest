package com.mygdx.seabattletest.objects.ship;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class ShipData {

    private int cellPositionX;
    private int cellPositionY;
    private int widthCells;
    private int heightCells;
    private boolean isHorizontal = true;

    public ShipData(int widthCells, int heightCells) {
        this.widthCells = widthCells;
        this.heightCells = heightCells;
    }

    public void setCellPositionX(int cellPositionX) {
        this.cellPositionX = cellPositionX;
    }

    public void setCellPositionY(int cellPositionY) {
        this.cellPositionY = cellPositionY;
    }

    public void setWidthCells(int widthCells) {
        this.widthCells = widthCells;
    }

    public void setHeightCells(int heightCells) {
        this.heightCells = heightCells;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public int getCellPositionX() {
        return cellPositionX;
    }

    public int getCellPositionY() {
        return cellPositionY;
    }

    public int getWidthCells() {
        return isHorizontal ? widthCells : heightCells;
    }

    public int getHeightCells() {
        return isHorizontal ? heightCells : widthCells;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public boolean isOverlaps(ShipData shipData) {
        boolean xAxisOverlaps = (cellPositionX + widthCells < shipData.getCellPositionX()) &&
                (cellPositionX > shipData.getCellPositionX() + shipData.getWidthCells());
        boolean yAxisOverlaps = (cellPositionY + heightCells < shipData.getCellPositionY()) &&
                (cellPositionY > shipData.getCellPositionY() + shipData.getHeightCells());
        return xAxisOverlaps && yAxisOverlaps;
    }
}