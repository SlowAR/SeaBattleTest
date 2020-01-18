package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.GameView;
import com.mygdx.seabattletest.objects.ship.ShipData;

import java.util.List;

/**
 * Created by SlowAR on 16.01.2020.
 */

public interface SeaBattleBoardContract {

    interface View extends GameView {

        void onBoardCreated(int cellsWidth, int cellsHeight, int shipsAmount);

        void placeShips(List<ShipData> shipDataList);
    }

    interface Logic {

        void onAutoButtonClick();
    }
}