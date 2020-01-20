package com.mygdx.seabattletest.utils;

import com.badlogic.gdx.Gdx;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.ui.board.utils.GameRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class GameUtils {

    public static final float SCREEN_WIDTH_DEFAULT = 800;
    public static final float SCREEN_HEIGHT_DEFAULT = 480;
    public static float RATIO_DEFAULT;
    public static float SCREEN_WIDTH_SPEC;
    public static float SCREEN_HEIGHT_SPEC;

    private static Random random = new Random();

    public static void initValues() {
        RATIO_DEFAULT = SCREEN_WIDTH_DEFAULT / SCREEN_HEIGHT_DEFAULT;
        float ratioSpec = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        if (RATIO_DEFAULT > ratioSpec) {
            SCREEN_WIDTH_SPEC = SCREEN_WIDTH_DEFAULT;
            SCREEN_HEIGHT_SPEC = (float) Gdx.graphics.getHeight() / ((float) Gdx.graphics.getWidth() / SCREEN_WIDTH_DEFAULT);
        } else if (RATIO_DEFAULT < ratioSpec) {
            SCREEN_WIDTH_SPEC = (float) Gdx.graphics.getWidth() / ((float) Gdx.graphics.getHeight() / SCREEN_HEIGHT_DEFAULT);
            SCREEN_HEIGHT_SPEC = SCREEN_HEIGHT_DEFAULT;
        } else {
            SCREEN_WIDTH_SPEC = SCREEN_WIDTH_DEFAULT;
            SCREEN_HEIGHT_SPEC = SCREEN_HEIGHT_DEFAULT;
        }
        Constants.BOARD_CELL_WIDTH = SCREEN_WIDTH_SPEC / Constants.BACKGROUND_CELLS_COLUMN_AMOUNT;
        Constants.BOARD_CELL_HEIGHT = SCREEN_HEIGHT_SPEC / Constants.BACKGROUND_CELLS_ROW_AMOUNT;
    }

    /**
     * @param from from parameter inclusive
     * @param to   to parameter inclusive
     * @return - value between [from, to]
     */
    public static int getRandomRange(int from, int to) {
        return random.nextInt(to + 1) - from;
    }

    public static void main(String[] args) {
        GameRules gameRules = new GameRules()
                .setBoardSize(10, 10)
                .addDefaultShipTypes()
                .build();

        ShipData shipData = new ShipData(3, 1);
        shipData.setHorizontal(true);
        shipData.setCellPositionX(3);
        shipData.setCellPositionY(5);

        List<ShipData> shipDataList = new ArrayList<>();
        shipDataList.add(shipData);

        printSeaBoard(gameRules, shipDataList);
    }

    public static void printSeaBoard(GameRules gameRules, List<ShipData> shipDataList) {
        int[][] board = new int[gameRules.getBoardWidth()][gameRules.getBoardHeight()];

        for (ShipData shipData : shipDataList) {
            for (int i = shipData.getCellPositionY(); i < shipData.getCellPositionY() + shipData.getHeightCells(); i++) {
                for (int j = shipData.getCellPositionX(); j < shipData.getCellPositionX() + shipData.getWidthCells(); j++) {
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < gameRules.getBoardHeight(); i++) {
            System.out.print(i + ") ");
            for (int j = 0; j < gameRules.getBoardWidth(); j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}