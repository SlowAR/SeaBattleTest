package com.mygdx.seabattletest.ui.board;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.seabattletest.common.BaseScreen;
import com.mygdx.seabattletest.resources.GameAssets;

/**
 * Created by SlowAR on 16.01.2020.
 */

public class SeaBattleBoardScreen extends BaseScreen implements SeaBattleBoardContract.View {

    private SeaBattleBoardContract.Logic seaBattleBoard;
    private TextButton autoButton;

    public SeaBattleBoardScreen(GameAssets gameAssets) {
        super(gameAssets);
        seaBattleBoard = new SeaBattleBoard(this).build();
        setupUi();
    }

    private void setupUi() {
        autoButton = new TextButton("Auto", skin);
        autoButton.setPosition(100, 100);
        stage.addActor(autoButton);
    }

    @Override
    public void setupBoard(int width, int height) {
        //board actor set parameters
    }

    @Override
    public void draw() {
        super.draw();
        spriteBatch.begin();
        spriteBatch.draw(gameAssets.background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}