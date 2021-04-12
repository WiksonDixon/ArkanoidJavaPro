package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameEngine {

    SpriteBatch Buffer;
    BackgroundFX bgfx;
    PaddleObject p;
    BallObject b;
    BlockGroup blgr;
    Player plr;
    Hud h;

    boolean debugMode=false;

    public GameEngine(SpriteBatch buffer) {
        Buffer = buffer;
        bgfx = new BackgroundFX(Buffer);
        p = new PaddleObject(Buffer);
        plr = new Player();
        b= new BallObject(Buffer,p,plr);
        blgr = new BlockGroup(Buffer,b,plr);
        h = new Hud(Buffer,plr);
        plr.setObjects(blgr,b,p);
    }

    public void drawScreen()
    {
        int offset_y = 40;
        bgfx.draw(offset_y);
        p.draw(offset_y);
        b.draw(offset_y);
        blgr.draw(offset_y);
        h.draw(0,0);
    }
    public void handleInput()
    {
        p.getInput();
        if(Gdx.input.isKeyPressed(Input.Keys.Q)&&Gdx.input.isKeyPressed(Input.Keys.P))debugMode=true;
        if(debugMode)b.debugMovement();
    }
    public void gameEvents()
    {
        b.movement();
        b.colPaddle();
        b.gluedBall();
        blgr.colBall();
        plr.levelManagement();
        plr.highScoreManagement();
    }


}
