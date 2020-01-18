package com.mygdx.seabattletest.common;

/**
 * Created by SlowAR on 16.01.2020.
 */

public abstract class BaseLogic<V extends GameView> {

    private V view;

    public BaseLogic(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
}