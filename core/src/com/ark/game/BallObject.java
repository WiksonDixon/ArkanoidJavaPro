package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BallObject {

    Texture img = new Texture("gfx/BALL.png");
    int x,y,velo_x,velo_y,res_w,res_h,wide,gluedMode;
    SpriteBatch SB;
    PaddleObject tempPaddle;
    Player plr;
    SoundFX sfx;

    public BallObject(SpriteBatch SB,PaddleObject tempPaddle,Player plr,SoundFX sfx) {
        this.SB = SB;
        this.tempPaddle=tempPaddle;
        this.plr = plr;
        this.sfx = sfx;
        res_h=600;
        res_w=800;
        wide=20;
        resetBall();
    }

    /**
     * Ustawienie pilki w poczatkowej pozycji
     */
    public void resetBall()
    {
        x=0;
        y=0;
        velo_x=5;
        velo_y=5;
        gluedMode=1;
    }

    /**
     * Rysowanie pilki
     * @param offset_y Przesuniecie wzgledem osi y
     */
    public void draw(int offset_y)
    {
     SB.draw(img,x,y+offset_y);
    }

    /**
     * Poruszanie piłki przez dodawanie prędkości do współrzędnych
     */
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
            plr.decLive();
            gluedMode = 1;
        }
    }

    /**
     * Funkcja do szybszego testowania gry przez poruszanie pilka
     */
    public void debugMovement()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W))velo_y=5;
        if(Gdx.input.isKeyPressed(Input.Keys.A))velo_x=-5;
        if(Gdx.input.isKeyPressed(Input.Keys.D))velo_x=5;
        if(Gdx.input.isKeyPressed(Input.Keys.S))velo_y=-5;

    }

    /**
     * Kolizja pilki z paletka
     */
    public void colPaddle()
    {
        if(tempPaddle.y+20==y)
        {
            if(x>tempPaddle.x-10&&x< tempPaddle.x+210)
            {
                int temp_velo=(x-tempPaddle.x-100)/15;
                velo_x=temp_velo;
                velo_y=-velo_y;
                if(gluedMode==0)sfx.playSound("bong");
            }
        }

    }

    /**
     * Metoda do poruszania pilki przyklejonej do paletki
     */
    public void gluedBall()
    {
        if(gluedMode==1)
        {
           x=tempPaddle.x+90;
           y=tempPaddle.y+20;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)&&gluedMode!=0)
        {
            gluedMode=0;
            velo_x=5;
            velo_y=5;
        }
    }
}
