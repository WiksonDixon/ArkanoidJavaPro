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

    /**
     * Rysowanie animowanego tla w grze
     * @param offset_y Przesuniecie wzgledem osi Y
     */
    public void draw(int offset_y)
    {
    SB.draw(bg,0,scroll+offset_y);
    scroll--;
    if(scroll<-1800)scroll=0;
    }
}
