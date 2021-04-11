package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BallObject {

    Texture img = new Texture("gfx/BALL.png");
    int x,y,velo_x,velo_y,res_w,res_h,wide;
    SpriteBatch SB;
    PaddleObject tempPaddle;


    public BallObject(SpriteBatch SB,PaddleObject tempPaddle) {
        this.SB = SB;
        this.tempPaddle=tempPaddle;
        res_h=600;
        res_w=800;
        wide=20;
        x=0;
        y=0;
        velo_x=5;
        velo_y=5;
    }

    public void draw()
    {
     SB.draw(img,x,y);
    }
    public void movement()
    {
        x+=velo_x;
        y+=velo_y;

        if(x<0)   //lewa
        {
            velo_x=-velo_x;
            x=0;
        }
        if(x>res_w-wide) //prawa
        {
            velo_x=-velo_x;
            x=res_w-wide;
            
        }
        if(y>res_h) //sufit
        {
            velo_y=-velo_y;
            y=res_h;
            
        }
        if(y<0) //dol
        {
            x=400;
            y=300;
            velo_x=0;
            velo_y=0;
           // if(ball->bonus==0)*check=2;
        }
    }
    public void debugMovement()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W))velo_y=5;
        if(Gdx.input.isKeyPressed(Input.Keys.A))velo_x=-5;
        if(Gdx.input.isKeyPressed(Input.Keys.D))velo_x=5;
        if(Gdx.input.isKeyPressed(Input.Keys.S))velo_y=-5;

    }

    public void colPaddle()
    {
        if(tempPaddle.y+20==y)
        {
            if(x>tempPaddle.x-10&&x< tempPaddle.x+210)
            {
                int temp_velo=(x-tempPaddle.x-100)/15;
                velo_x=temp_velo;
                velo_y=-velo_y;
            }
        }

    }
}
