package com.ark.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameEngine {

    SpriteBatch Buffer;
    BackgroundFX bgfx;
    PaddleObject p;
    BallObject b;
    BlockGroup blgr;

    public GameEngine(SpriteBatch buffer) {
        Buffer = buffer;
        bgfx = new BackgroundFX(Buffer);
        p = new PaddleObject(Buffer);
        b= new BallObject(Buffer,p);
        blgr = new BlockGroup(Buffer,b);
    }

    public void drawScreen()
    {
        bgfx.draw();
        p.draw();
        b.draw();
        blgr.draw();
    }
    public void handleInput()
    {
        p.getInput();
        b.debugMovement();
    }
    public void gameEvents()
    {
        b.movement();
        b.colPaddle();
        b.gluedBall();
        blgr.colBall();
    }


}
