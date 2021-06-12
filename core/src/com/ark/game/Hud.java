package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Hud {
    Texture imgHud = new Texture("gfx/hud.png");
    Texture imgHeart = new Texture("gfx/HEART.png");
    Player p;
    SpriteBatch SB;
    BitmapFont f = new BitmapFont();


    public Hud(SpriteBatch SB,Player p) {
        this.p = p;
        this.SB = SB;
        f.setColor(Color.YELLOW);
    }

    /**
     * Metoda rysujaca interfejs uzytkownika w grze
     * @param x Wspolrzedne X do rysowania
     * @param y Wspolrzedne Y do rysowania
     */
    public void draw(int x,int y)
    {
        SB.draw(imgHud,x,y);
        for(int i=0;i<p.lives;i++)SB.draw(imgHeart,x+20*(i+1),y+10);
        f.draw(SB,"LEVEL: "+String.valueOf(p.level+1),(float)(x+90),(float)(y+25));
        f.draw(SB,"SCORE: "+String.valueOf(p.score),(float)(x+460),(float)(y+25));
        f.draw(SB,"HIGH SCORE: "+String.valueOf(p.highscore),(float)(x+630),(float)(y+25));
    }
}
