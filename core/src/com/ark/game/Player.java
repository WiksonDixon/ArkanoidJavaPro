package com.ark.game;

public class Player {

    int level, lives, score, highscore;
    BlockGroup blgr;
    BallObject ball;
    PaddleObject paddle;
    SoundFX sfx;

    Player()
    {
        highscore=0;
        newGame();
    }

    /**
     * Ustawienie referencji do klas
     * @param blgr Klasa tla
     * @param ball Klasa pilki
     * @param paddle Klasa paletki
     * @param sfx Klasa efektow dzwiekowych
     */
    public void setObjects(BlockGroup blgr,BallObject ball, PaddleObject paddle,SoundFX sfx) {
        this.blgr = blgr;
        this.ball = ball;
        this.paddle = paddle;
        this.sfx = sfx;
    }

    /**
     * Ustawienie wartosci poczatkowych do gry
     */
    public void newGame()
    {
        level = 0;
        lives = 3;
        score = 0;
    }

    /**
     * Sprawdza czy poziom jest ukonczony
     * @return true gdy poziom jest ukonczony, false jesli rozgrywka wciaz trwa
     */
    public boolean checkLevelComplete()
    {
        boolean temp = true;
        for(int i=0;i<blgr.block_count;i++)
            if(blgr.bl[i].health!=0)
                temp=false;
        return temp;
    }

    /**
     * Zwiekszanie wyniku
     * @param n Wartosc o jaka ma sie zwiekszyc wynik
     */
    public void incScore(int n)
    {
        score+=n;
    }

    /**
     * Zmniejszanie ilosci zyc i obsluga zakonczenia gry
     */
    public void decLive()
    {
        lives--;
        sfx.playSound("livelost");
        if(lives==0)
        {
            sfx.playSound("lost");
            blgr.levelGen(0);
            newGame();
        }
    }

    /**
     * Metoda do obslugi przechodzenia miedzy poziomami przy ukonczeniu ich
     */
    public void levelManagement()
    {
        if(checkLevelComplete())
        {
            sfx.playSound("win");
            level++;
            ball.resetBall();
            paddle.resetPaddle();
            blgr.levelGen(level);
        }
    }

    /**
     * Metoda do ustawiania nowego najwyzszego wyniku
     */
    public void highScoreManagement()
    {
        if(score>highscore)highscore=score;
    }
}
