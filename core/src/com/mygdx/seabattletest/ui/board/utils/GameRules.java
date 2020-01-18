package com.mygdx.seabattletest.ui.board.utils;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class GameRules {

    private int boardWidth;
    private int boardHeight;
    private boolean isHaveOneCellBorder;

    public GameRules setBoardSize(int width, int height) {
        boardWidth = width;
        boardHeight = height;
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
        return this;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public boolean isHaveOneCellBorder() {
        return isHaveOneCellBorder;
    }
}