package com.ark.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundFX {

    float volume = 100;

    Sound bong = Gdx.audio.newSound(Gdx.files.internal("sfx/BONG.wav"));
    Sound destroy = Gdx.audio.newSound(Gdx.files.internal("sfx/DESTROY.wav"));
    Sound livelost = Gdx.audio.newSound(Gdx.files.internal("sfx/LIVELOST.wav"));
    Sound lost = Gdx.audio.newSound(Gdx.files.internal("sfx/LOST.wav"));
    Sound win = Gdx.audio.newSound(Gdx.files.internal("sfx/WIN.wav"));
    Sound background = Gdx.audio.newSound(Gdx.files.internal("sfx/bgsound.mp3"));


    public boolean sound_set = true;

    public SoundFX() {
        background.play((float)5);
    }

    public void sound_set_on_off()
    {
        sound_set=!sound_set;
        if(!sound_set)background.stop();
        else background.play((float)5);
    }

    public void playSound(String s)
    {
        if(!sound_set)return;

        if(s.equals("bong"))bong.play(volume);
        if(s.equals("destroy"))destroy.play(volume);
        if(s.equals("livelost"))livelost.play(volume);
        if(s.equals("lost"))lost.play(volume);
        if(s.equals("win"))win.play(volume);
    }
}
