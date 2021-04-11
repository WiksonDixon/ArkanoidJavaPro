package com.ark.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundFX {

    Texture bg = new Texture("gfx/BACKGROUND.bmp");
    int scroll = 0;
    SpriteBatch SB;

    public BackgroundFX(SpriteBatch SB) {
        this.SB = SB;
    }

    public void draw()
    {
    SB.draw(bg,0,scroll);
    scroll--;
    if(scroll<-1800)scroll=0;
    }
}
