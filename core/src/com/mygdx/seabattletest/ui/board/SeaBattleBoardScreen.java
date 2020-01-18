package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.BaseScreen;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoardScreen extends BaseScreen implements SeaBattleBoardContract.View {

    private SeaBattleBoardContract.Logic seaBattleBoard;

    public SeaBattleBoardScreen(GameAssets gameAssets) {
        super(gameAssets);
        seaBattleBoard = new SeaBattleBoard(this).build();
    }

    @Override
    public void setupBoard(int width, int height) {
        //board actor set parameters
    }

    @Override
    public void draw() {
        super.draw();
        spriteBatch.begin();

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}