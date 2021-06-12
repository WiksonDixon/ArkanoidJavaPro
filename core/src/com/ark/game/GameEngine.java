package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameEngine {

    boolean debugMode = false;
    int mode = 0;

    SpriteBatch Buffer;
    BackgroundFX bgfx;
    PaddleObject p;
    BallObject b;
    BlockGroup blgr;
    Player plr;
    Hud h;
    Menu m;
    SoundFX sfx = new SoundFX();


    public GameEngine(SpriteBatch buffer) {
        Buffer = buffer;
        bgfx = new BackgroundFX(Buffer);
        p = new PaddleObject(Buffer);
        plr = new Player();
        b = new BallObject(Buffer, p, plr,sfx);
        blgr = new BlockGroup(Buffer, b, plr,sfx);
        h = new Hud(Buffer, plr);
        plr.setObjects(blgr, b, p,sfx);
        m = new Menu(Buffer,mode);
    }

    /**
     * Metoda wyswietlajaca odpowiednio ekran gry lub menu
     */
    public void drawScreen()
    {
       if(mode == 0)drawMenuScreen();
       if(mode == 1)drawGameScreen();
    }

    /**
     * Metoda do obslugi klawiatury w grze lub menu
     */
    public void handleInput()

    {
        if(mode==0)handleMenuInput();
        if(mode==1)handleGameInput();
    }

    /**
     * Metoda determinujaca czy maja dziac sie wydarzenia z okna menu czy gry
     */
    public void Events()
    {
        if(mode==0)menuEvents();
        if(mode==1)gameEvents();
    }

    /**
     * Metoda do rysowania gry
     */
    public void drawGameScreen()
    {
        int offset_y = 40;
        bgfx.draw(offset_y);
        p.draw(offset_y);
        b.draw(offset_y);
        blgr.draw(offset_y);
        h.draw(0,0);
    }

    /**
     * Metoda do sterowania w grze
     */
    public void handleGameInput()
    {
        p.getInput();
        if(Gdx.input.isKeyPressed(Input.Keys.Q)&&Gdx.input.isKeyPressed(Input.Keys.P))debugMode=true;
        if(debugMode)b.debugMovement();
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))mode=0;
    }

    /**
     * Metoda do zdarzen w grze
     */
    public void gameEvents()
    {
        b.movement();
        b.colPaddle();
        b.gluedBall();
        blgr.colBall();
        plr.levelManagement();
        plr.highScoreManagement();
    }

    public void drawMenuScreen()
    {
        m.draw(0);
    }
    public void handleMenuInput(){m.input();}

    /**
     * Metoda do wybierania opcji w menu glownym
     */

    public void menuEvents(){
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
        {
            switch (m.action)
            {
                case 0:
                {
                    p.resetPaddle();
                    plr.newGame();
                    blgr.levelGen(0);
                    b.resetBall();
                    mode = 1;
                    break;
                }
                case 1:
                {
                    mode = 1;
                    break;
                }
                case 2:
                {
                    sfx.sound_set_on_off();
                    m.setSound();
                    break;
                }
                case 3:
                {
                    Gdx.app.exit();
                    break;
                }
            }
        }
    }
}
