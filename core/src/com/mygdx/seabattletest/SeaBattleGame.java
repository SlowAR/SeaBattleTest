package com.mygdx.seabattletest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.ui.board.SeaBattleBoardScreen;

public class SeaBattleGame extends Game {

    private GameAssets gameAssets;
    private Screen mainGameScreen;

    @Override
    public void create() {
        gameAssets = new GameAssets();
        mainGameScreen = new SeaBattleBoardScreen(gameAssets);     //TODO fabric
        setScreen(mainGameScreen);
    }

    @Override
    public void dispose() {
        mainGameScreen.dispose();
        gameAssets.dispose();
    }
}