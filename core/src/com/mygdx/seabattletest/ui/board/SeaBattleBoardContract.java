package com.mygdx.seabattletest.ui.board;

import com.mygdx.seabattletest.common.GameView;

/**
 * Created by SlowAR on 16.01.2020.
 */

public interface SeaBattleBoardContract {

    interface View extends GameView {

        void setupBoard(int width, int height);
    }

    interface Logic {

        void onAutoButtonClick();
    }
}