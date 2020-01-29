package com.mygdx.seabattletest.objects.ship;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.seabattletest.common.Constants;
import com.mygdx.seabattletest.objects.MaskActor;
import com.mygdx.seabattletest.resources.GameAssets;
import com.mygdx.seabattletest.ui.board.utils.GameRules;
import com.mygdx.seabattletest.utils.GameUtils;

/**
 * Created by SlowAR on 18.01.2020.
 */

public class ShipActor extends Actor {

    private GameAssets gameAssets;
    private GameRules gameRules;
    private ShipData shipData;

    private MaskActor maskActor;

    public ShipActor(GameAssets gameAssets, GameRules gameRules) {
        this.gameAssets = gameAssets;
        this.gameRules = gameRules;
        shipData = new ShipData(0, 0);
    }

    public void applyShipData(ShipData shipData) {
        this.shipData = shipData;
    }

    public void setMaskActor(MaskActor maskActor) {
        this.maskActor = maskActor;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        ShaderProgram maskShader = gameAssets.maskShader;
        batch.setShader(maskShader);

        for (int i = shipData.getCellPositionY() + shipData.getHeightCells(); i > shipData.getCellPositionY(); i--) {
            for (int j = shipData.getCellPositionX(); j < shipData.getCellPositionX() + shipData.getWidthCells(); j++) {

                float x = Constants.BOARD_CELL_WIDTH * j;
                float y = Constants.BOARD_CELL_HEIGHT * (gameRules.getBoardHeight() - i);
                float width = Constants.BOARD_CELL_WIDTH;
                float height = Constants.BOARD_CELL_HEIGHT;

//                maskShader.setUniformi("u_mask", 1);

                maskShader.setUniformf("u_sizeAtlasTex", gameAssets.circleMask.getTexture().getWidth(), gameAssets.circleMask.getTexture().getHeight());
                maskShader.setUniformf("u_textureRegionPos", gameAssets.ship.getRegionX(), gameAssets.ship.getRegionY());
                maskShader.setUniformf("u_textureRegionSize", gameAssets.ship.getRegionWidth(), gameAssets.ship.getRegionHeight());
                maskShader.setUniformf("u_texturePos", x, y);
                maskShader.setUniformf("u_textureSize", width, height);

                maskShader.setUniformf("u_screenSize", GameUtils.SCREEN_WIDTH_SPEC, GameUtils.SCREEN_HEIGHT_SPEC);
                maskShader.setUniformf("u_maskPos", maskActor.getX(), maskActor.getY());
                maskShader.setUniformf("u_maskSize", maskActor.getWidth(), maskActor.getHeight());

//                maskShader.setUniformf("u_screenSize", GameUtils.SCREEN_WIDTH_SPEC, GameUtils.SCREEN_HEIGHT_SPEC);
//                maskShader.setUniformf("u_maskRegionPos", gameAssets.circleMask.getRegionX(), gameAssets.circleMask.getRegionY());
//                maskShader.setUniformf("u_maskRegionSize", gameAssets.circleMask.getRegionWidth(), gameAssets.circleMask.getRegionHeight());
//                maskShader.setUniformf("u_maskPos", maskActor.getX(), maskActor.getY());
//                maskShader.setUniformf("u_maskSize", maskActor.getWidth(), maskActor.getHeight());

//                gameAssets.circleMaskTexture.bind(1);
//                Gdx.gl.glActiveTexture(Gdx.gl.GL_TEXTURE0);

                batch.draw(gameAssets.ship, x, y, width, height);
            }
        }

        batch.setShader(null);
    }
}