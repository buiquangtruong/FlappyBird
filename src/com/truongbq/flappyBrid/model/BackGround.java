package com.truongbq.flappyBrid.model;

import com.truongbq.flappyBrid.manager.ImageStore;
import com.truongbq.flappyBrid.view.Gui;

import java.awt.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class BackGround extends GameObject{
    public static final int WIDTH = 1152;
    public static final int HEIGHT = 511;
    public BackGround(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics2D graphic2D){
        graphic2D.drawImage(ImageStore.IMG_BACKGROUND,x,y,WIDTH,HEIGHT,null);
    }

    public void move(int numOfSlepp){
        if (numOfSlepp % 5 == 0){
            x--;
            if (x <= -288){
                x=0;
            }
        }
    }
}
