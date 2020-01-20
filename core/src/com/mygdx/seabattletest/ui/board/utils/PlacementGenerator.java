package com.mygdx.seabattletest.ui.board.utils;

import com.mygdx.seabattletest.objects.ship.ShipData;

import java.util.List;

/**
 * Created by SlowAR on 19.01.2020.
 */

public interface PlacementGenerator {

    List<ShipData> generate();
}