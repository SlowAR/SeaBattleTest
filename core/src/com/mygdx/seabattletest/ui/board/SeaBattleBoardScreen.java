package com.mygdx.seabattletest.ui.board;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.seabattletest.common.BaseScreen;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.BoardActor;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoardScreen extends BaseScreen implements SeaBattleBoardContract.View {

    private SeaBattleBoardContract.Logic seaBattleBoard;

    private BoardActor boardActor;
    private TextButton autoButton;

    public SeaBattleBoardScreen(GameAssets gameAssets) {
        super(gameAssets);
        seaBattleBoard = new SeaBattleBoard(this).build();
        setupUi();
    }

    @Override
    protected void setupGameObjects() {
        super.setupGameObjects();
        boardActor = new BoardActor(gameAssets);
        boardActor.setPosition(Constants.BOARD_CELL_WIDTH * 2, Constants.BOARD_CELL_HEIGHT);
        boardActor.setSize(Constants.BOARD_CELL_WIDTH * 10, Constants.BOARD_CELL_HEIGHT * 10);
        stage.addActor(boardActor);
        boardActor.init(skin);
    }

    private void setupUi() {
        autoButton = new TextButton("Auto", skin);
        autoButton.setPosition(boardActor.getX() + boardActor.getWidth(), boardActor.getY());
        autoButton.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                seaBattleBoard.onAutoButtonClick();
            }
        });
        stage.addActor(autoButton);
    }

    @Override
    public void setupBoard(int width, int height) {
        //board actor set parameters
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}