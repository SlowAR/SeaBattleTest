package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.BaseLogic;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.ui.board.utils.GameRules;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoard extends BaseLogic<SeaBattleBoardContract.View> implements SeaBattleBoardContract.Logic {

    private GameRules gameRules;

    public SeaBattleBoard(SeaBattleBoardContract.View view) {
        super(view);
    }

    public SeaBattleBoard(SeaBattleBoardContract.View view, GameRules gameRules) {
        super(view);
        this.gameRules = gameRules;
    }

    public SeaBattleBoard build() {
        if (gameRules == null) {
            gameRules = new GameRules()
                    .setBoardSize(Constants.DEFAULT_BOARD_SIZE, Constants.DEFAULT_BOARD_SIZE)
                    .addDefaultShipTypes()
                    .setOneCellShipsBorder()
                    .build();
        }
        getView().onBoardCreated(gameRules.getBoardWidth(), gameRules.getBoardHeight(), gameRules.getShipsAmount());
        return this;
    }

    @Override
    public void onAutoButtonClick() {
        List<ShipData> shipDataList = new ArrayList<>();
        //place ships logic
        getView().placeShips(shipDataList);
    }

    public void changeGameRules(GameRules gameRules) {
        throw new IllegalStateException("not implemented!");
    }
}