package com.ark.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.w3c.dom.Text;

public class BlockGroup {

    int res_w,res_h,block_count=70;
   SpriteBatch SB;
   Texture[] img=
    {
                new Texture("gfx/BLOCK1.bmp"),
                new Texture("gfx/BLOCK2.bmp"),
                new Texture("gfx/BLOCK3.bmp"),
                new Texture("gfx/BLOCK4.bmp"),
                new Texture("gfx/BLOCK5.bmp"),
                new Texture("gfx/BLOCK6.bmp"),
                new Texture("gfx/BLOCK7.bmp")
    };
    BlockObject[] bl =  new BlockObject[70];
    BallObject ball;

    public BlockGroup(SpriteBatch SB,BallObject ball) {
        res_h=600;
        res_w=800;
        this.SB = SB;
        this.ball = ball;

        for(int i=0;i<block_count;i++)
            bl[i]=new BlockObject();

        for(int i=0;i<block_count;i++)
        {
            bl[i].x = 0 + (i % (res_w / 80)) * 80;
            bl[i].y = res_h - (70 + (i / (res_w / 80)) * 30);
            bl[i].health = 1;
        }
    }
    public void draw()
    {
        for(int i=0;i<block_count;i++)
        {
            if(bl[i].health==0)continue;
            switch (i%7)
            {
                case 0: SB.draw(img[0],bl[i].x,bl[i].y); break;
                case 1: SB.draw(img[1],bl[i].x,bl[i].y); break;
                case 2: SB.draw(img[2],bl[i].x,bl[i].y); break;
                case 3: SB.draw(img[3],bl[i].x,bl[i].y); break;
                case 4: SB.draw(img[4],bl[i].x,bl[i].y); break;
                case 5: SB.draw(img[5],bl[i].x,bl[i].y); break;
                case 6: SB.draw(img[6],bl[i].x,bl[i].y); break;
            }
        }

    }
    public void colBall()
    {
        int ball_point_x=ball.x+10,ball_point_y=ball.y+10,    change_y_velo,change_x_velo;
        int i;
        change_y_velo=0;    /* Zmienne przechowujace wartosc 1 lub 0 w przypadku gdy pilka sie zderzyla i trzeba zmienic kierunek predkosci */
        change_x_velo=0;
        for(i=0;i<block_count;i++) /* Sprawdzanie kolizji dla kazdego bloczka*/
        {

            if((bl[i].y+30==ball_point_y-10)&&bl[i].health!=0)
            {
                if((ball_point_x>=bl[i].x)&&(ball_point_x<=bl[i].x+80))   /*Warunki zderzenia bloczku z pilka*/
                {
                    bl[i].health=bl[i].health-1;
                    change_y_velo=1;    /* Zmiana znaku predkosci */
                }

            }
            if((bl[i].y==ball_point_y+10)&&bl[i].health!=0)
            {
                if((ball_point_x>=bl[i].x)&&(ball_point_x<=bl[i].x+80))
                {
                    bl[i].health=bl[i].health-1;
                    change_y_velo=1;
                }
            }
            if((bl[i].x+80==ball_point_x-10)&&bl[i].health!=0)
            {
                if((ball_point_y>=bl[i].y)&&(ball_point_y<=bl[i].y+30))
                {
                    bl[i].health=bl[i].health-1;
                    change_x_velo=1;
                }

            }
            if((bl[i].x==ball_point_x+10)&&bl[i].health!=0)
            {
                if((ball_point_y>=bl[i].y)&&(ball_point_y<=bl[i].y+30))
                {
                    bl[i].health=bl[i].health-1;
                    change_x_velo=1;
                }
            }
        }

        if(change_y_velo==1)ball.velo_y=-ball.velo_y;
        if(change_x_velo==1) ball.velo_x=-ball.velo_x;

    }



}
