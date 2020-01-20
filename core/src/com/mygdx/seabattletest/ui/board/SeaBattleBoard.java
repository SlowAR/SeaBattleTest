package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.BaseLogic;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.ui.board.utils.GameRules;
import com.mygdx.seabattletest.ui.board.utils.PlacementGenerator;
import com.mygdx.seabattletest.ui.board.utils.ShipPlacementGenerator;
import com.mygdx.seabattletest.utils.GameUtils;

import java.util.List;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoard extends BaseLogic<SeaBattleBoardContract.View> implements SeaBattleBoardContract.Logic {

    private GameRules gameRules;
    private PlacementGenerator shipPlacementGenerator;

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
                    .build();
        }
        shipPlacementGenerator = new ShipPlacementGenerator(gameRules);
        getView().onBoardCreated(gameRules);
        return this;
    }

    @Override
    public void onAutoButtonClick() {
        List<ShipData> shipDataList = shipPlacementGenerator.generate();
        getView().placeShips(shipDataList);
    }

    public void changeGameRules(GameRules gameRules) {
        throw new IllegalStateException("not implemented!");
    }
}