package com.truongbq.flappyBrid.model;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Truong KL on 4/24/2017.
 */
public class WavPlayer {
    private Clip clip;

    public WavPlayer(String name) {
        try {
            URL url= getClass().getResource("/res/raw/"+ name + ".wav");
            AudioInputStream stream = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(stream);

        }catch (UnsupportedAudioFileException |LineUnavailableException | IOException e){
            e.printStackTrace();
        }

    }

    public void playSound(){
        if (clip != null ){
            stopSound();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stopSound(){
        if (clip != null && clip.isRunning()){
            clip.stop();
        }
    }

    public void loop(int count){
        clip.loop(count); // count = 0 -> chạy 1 lần, = 2 -> 3 lần, = -1 -> vô hạn

    }
}
