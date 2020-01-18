package com.mygdx.seabattletest.utils;

import com.badlogic.gdx.Gdx;
import com.mygdx.seabattletest.common.Constants;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class GameUtils {

    public static final float SCREEN_WIDTH_DEFAULT = 800;
    public static final float SCREEN_HEIGHT_DEFAULT = 480;
    public static float RATIO_DEFAULT;
    public static float SCREEN_WIDTH_SPEC;
    public static float SCREEN_HEIGHT_SPEC;

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
}