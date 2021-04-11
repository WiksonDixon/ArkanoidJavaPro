package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PaddleObject {

    Texture img = new Texture("gfx/PADDLE.bmp");
    int x=350;
    int y=20;
    int texture_w = 200;
    SpriteBatch SB;

    public PaddleObject(SpriteBatch SB) {
        this.SB = SB;
    }

    void getInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x-=15;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))x+=15;

        if(x<0)x=0;
        if(x>800-texture_w)x=800-texture_w;
    }
    void draw()
    {
        SB.draw(img,x,y);
    }
}
