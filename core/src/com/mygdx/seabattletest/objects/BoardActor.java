package com.mygdx.seabattletest.objects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.resources.GameAssets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class BoardActor extends Group {

    private NinePatch boardNinePatch;
    private List<Label> numbersLabelsList;
    private List<Label> lettersLabelsList;

    public BoardActor(GameAssets gameAssets) {
        boardNinePatch = new NinePatch(gameAssets.button, 16, 16, 16, 16);

    }

    public void init(Skin skin) {
        numbersLabelsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Label label = new Label(String.valueOf(i), skin);
            label.setFontScale(0.333f);
            label.setPosition(Constants.BOARD_CELL_WIDTH * (i - 1), getHeight() - Constants.BOARD_CELL_HEIGHT);
            addActor(label);
        }

        lettersLabelsList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            char letter = (char) ((int) 'A' + (i - 1));
            Label label = new Label(String.valueOf(letter), skin);
            label.setFontScale(0.333f);
            label.setPosition(-Constants.BOARD_CELL_WIDTH,
                    getHeight() - Constants.BOARD_CELL_HEIGHT - Constants.BOARD_CELL_HEIGHT * i);
            addActor(label);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        boardNinePatch.draw(batch, getX(), getY(), getWidth(), getHeight());
    }


}