package com.mygdx.seabattletest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.ui.board.SeaBattleBoardScreen;
import com.mygdx.seabattletest.utils.ScreenListener;
import com.mygdx.seabattletest.utils.ScreenType;

public class SeaBattleGame extends Game implements ScreenListener {

    private GameAssets gameAssets;
    private Screen mainGameScreen;

    @Override
    public void create() {
        gameAssets = new GameAssets();
        switchScreen(ScreenType.Main);
    }

    @Override
    public void dispose() {
        mainGameScreen.dispose();
        gameAssets.dispose();
    }

    @Override
    public void switchScreen(ScreenType screenType) {
        switch (screenType) {
            case Main:
                if (mainGameScreen == null) {
                    mainGameScreen = new SeaBattleBoardScreen(gameAssets, this);
                }
                setScreen(mainGameScreen);
                break;
        }
    }
}