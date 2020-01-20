package com.mygdx.seabattletest.ui.board;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.seabattletest.common.BaseScreen;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.BoardActor;
import com.mygdx.seabattletest.objects.MaskActor;
import com.mygdx.seabattletest.objects.ship.ShipActor;
import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.utils.ScreenListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoardScreen extends BaseScreen implements SeaBattleBoardContract.View {

    private SeaBattleBoardContract.Logic seaBattleBoard;

    private BoardActor boardActor;
    private TextButton autoButton;
    private List<ShipActor> shipsList;
    private Actor maskActor;

    public SeaBattleBoardScreen(GameAssets gameAssets, ScreenListener screenListener) {
        super(gameAssets, screenListener);
        shipsList = new ArrayList<>();
        seaBattleBoard = new SeaBattleBoard(this).build();
    }

    @Override
    protected void setupGameObjects() {
        super.setupGameObjects();
        boardActor = new BoardActor(gameAssets);
        stage.addActor(boardActor);

        maskActor = new MaskActor(gameAssets);
        //stage.addActor(maskActor);
    }

    @Override
    public void onBoardCreated(int cellsWidth, int cellsHeight, int shipsAmount) {
        boardActor.setPosition(Constants.BOARD_CELL_WIDTH * 2, Constants.BOARD_CELL_HEIGHT);
        boardActor.setSize(Constants.BOARD_CELL_WIDTH * cellsWidth, Constants.BOARD_CELL_HEIGHT * cellsHeight);
        boardActor.init(skin, cellsWidth, cellsHeight);
        createShips(shipsAmount);
        setupUi();
    }

    private void createShips(int shipsAmount) {
        for (int i = 0; i < shipsAmount; i++) {
            ShipActor shipActor = new ShipActor();
            shipActor.setPosition(Constants.BOARD_CELL_WIDTH, Constants.BOARD_CELL_HEIGHT);
            stage.addActor(shipActor);
            shipsList.add(shipActor);
        }
    }

    private void setupUi() {
        autoButton = new TextButton("Auto", skin);
        autoButton.setPosition(boardActor.getX() + boardActor.getWidth() + Constants.BOARD_CELL_WIDTH, boardActor.getY());
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
    public void placeShips(List<ShipData> shipDataList) {

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