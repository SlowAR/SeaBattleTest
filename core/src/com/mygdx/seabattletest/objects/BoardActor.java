package com.mygdx.seabattletest.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.ship.ShipActor;
import com.mygdx.seabattletest.objects.ship.ShipData;
import com.mygdx.seabattletest.resources.GameAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class BoardActor extends Group {

    private NinePatch boardNinePatch;
    private List<ShipActor> shipsList;

    public BoardActor(GameAssets gameAssets) {
        shipsList = new ArrayList<>();
        boardNinePatch = new NinePatch(gameAssets.button, 16, 16, 16, 16);
    }

    public void init(Skin skin, int cellsWidth, int cellsHeight, int shipsAmount) {
        for (int i = 1; i <= cellsWidth; i++) {
            Label label = new Label(String.valueOf(i), skin);
            label.setFontScale(0.333f);
            label.setPosition(Constants.BOARD_CELL_WIDTH * (i - 1), getHeight() - Constants.BOARD_CELL_HEIGHT);
            label.setColor(Color.BLUE);
            addActor(label);
        }

        for (int i = 1; i <= cellsHeight; i++) {
            char letter = (char) ((int) 'A' + (i - 1));
            Label label = new Label(String.valueOf(letter), skin);
            label.setFontScale(0.333f);
            label.setPosition(-Constants.BOARD_CELL_WIDTH,
                    getHeight() - Constants.BOARD_CELL_HEIGHT - Constants.BOARD_CELL_HEIGHT * i);
            label.setColor(Color.BLUE);
            addActor(label);
        }

        createShips(shipsAmount);
    }

    private void createShips(int shipsAmount) {
        for (int i = 0; i < shipsAmount; i++) {
            ShipActor shipActor = new ShipActor();
            shipActor.setPosition(Constants.BOARD_CELL_WIDTH, Constants.BOARD_CELL_HEIGHT);
            addActor(shipActor);
            shipsList.add(shipActor);
        }
    }

    public void placeShips(List<ShipData> shipDataList) {

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        boardNinePatch.draw(batch, getX(), getY(), getWidth(), getHeight());
    }
}