package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Menu {

    Texture bg = new Texture("gfx/BACKGROUNDMENU.bmp");
    Texture logo = new Texture("gfx/logo.png");
    Texture []options = { new Texture("gfx/opt1.png"),
            new Texture("gfx/opt2.png"),
            new Texture("gfx/opt3.png"),
            new Texture("gfx/opt4.png"),
            new Texture("gfx/opt3off.png")};
    Texture selector = new Texture("gfx/selector.bmp");

    int scroll = 0;
    public int action = 0;
    SpriteBatch SB;
    Integer mode;
    boolean sound = true;
    public Menu(SpriteBatch SB,Integer mode) {
        this.SB = SB;
        this.mode = mode;
    }

    public void draw(int offset_y)
    {
        SB.draw(bg,0,scroll+offset_y);
        scroll--;
        if(scroll<-2400+640)scroll=0;
        SB.draw(logo, 60, 470);
        for (int i = 0; i<4 ; i++)
        {
            SB.draw(options[i],300,300-i*50);
            if(!sound&&i==2)SB.draw(options[4],300,300-2*50);
            if(action==i)SB.draw(selector,460,300-i*50);
        }
    }

    public void setSound()
    {
        sound = !sound;
    }

    public void input()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.UP))action--;
        if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN))action++;

        if(action<0)action=0;
        if(action>3)action=3;
    }

}
