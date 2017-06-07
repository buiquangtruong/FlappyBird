package com.truongbq.flappyBrid.model;

/**
 * Created by Truong KL on 4/21/2017.
 */

import com.truongbq.flappyBrid.manager.ImageStore;

import java.awt.*;
public class Pipe extends GameObject {
    public static final int WIDTH=64;
    public static final int HEIGHT = 540;
    public static final int DISTANCE = 100;
    private Rectangle recPipeTop;
    private Rectangle recPipeBottom;

    public Pipe(int x, int y) {
        super(x, y);
        recPipeTop = new Rectangle(x,y,WIDTH,HEIGHT);
        recPipeBottom = new Rectangle(x,y + HEIGHT + DISTANCE,WIDTH,HEIGHT);
    }

    public void move(int numOfSleep){
        if (numOfSleep % 5 ==0){
            x--;
            recPipeTop.setLocation(x,y);
            recPipeBottom.setLocation(x,y + HEIGHT + DISTANCE);
        }
    }

    public void draw(Graphics2D graphic2D){
        graphic2D.drawImage(ImageStore.IMG_PIPE_TOP,x,y,WIDTH,HEIGHT,null);
        graphic2D.drawImage(ImageStore.IMG_PIPE_BOTTOM,x,y+HEIGHT+DISTANCE,WIDTH,HEIGHT,null);
    }

    public Rectangle getRecPipeTop() {
        return recPipeTop;
    }

    public Rectangle getRecPipeBottom() {
        return recPipeBottom;
    }
}
