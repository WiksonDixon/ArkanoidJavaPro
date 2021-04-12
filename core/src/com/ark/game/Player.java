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

    public void setObjects(BlockGroup blgr,BallObject ball, PaddleObject paddle,SoundFX sfx) {
        this.blgr = blgr;
        this.ball = ball;
        this.paddle = paddle;
        this.sfx = sfx;
    }

    public void newGame()
    {
        level = 0;
        lives = 3;
        score = 0;
    }
    public boolean checkLevelComplete()
    {
        boolean temp = true;
        for(int i=0;i<blgr.block_count;i++)
            if(blgr.bl[i].health!=0)
                temp=false;
        return temp;
    }
    public void incScore(int n)
    {
        score+=n;
    }
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
    public void highScoreManagement()
    {
        if(score>highscore)highscore=score;
    }
}
