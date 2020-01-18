package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.BaseLogic;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.ui.board.utils.GameRules;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoard extends BaseLogic<SeaBattleBoardContract.View> implements SeaBattleBoardContract.Logic {

    private GameRules gameRules;

    public SeaBattleBoard(SeaBattleBoardContract.View view) {
        super(view);
    }

    public SeaBattleBoard setGameRules(GameRules gameRules) {
        this.gameRules = gameRules;
        return this;
    }

    public SeaBattleBoard build() {
        if (gameRules == null) {
            gameRules = new GameRules()
                    .setBoardSize(Constants.DEFAULT_BOARD_SIZE, Constants.DEFAULT_BOARD_SIZE)
                    .setOneCellShipsBorder()
                    .build();
        }
        getView().setupBoard(gameRules.getBoardWidth(), gameRules.getBoardHeight());
        return this;
    }

    @Override
    public void onAutoButtonClick() {
    }
}