package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PaddleObject {

    Texture img = new Texture("gfx/PADDLE.bmp");
    int x=300;
    int y=20;
    int texture_w = 200;
    SpriteBatch SB;

    public PaddleObject(SpriteBatch SB) {
        this.SB = SB;
        resetPaddle();
    }

    /**
     * Ustawienie poczatkowej pozycji paletki
     */
    public void resetPaddle()
    {
        x=300;
        y=20;
    }

    /**
     * Sterowanie paletka przy uzyciu klawiatury
     */
    void getInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) x-=15;
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))x+=15;

        if(x<0)x=0;
        if(x>800-texture_w)x=800-texture_w;
    }

    /**
     * Rysowanie paletki
     * @param offset_y Przesuniecie wzgledem Y
     */
    void draw(int offset_y)
    {
        SB.draw(img,x,y+offset_y);
    }
}
