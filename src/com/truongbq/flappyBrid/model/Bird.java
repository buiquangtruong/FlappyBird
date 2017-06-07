package com.truongbq.flappyBrid.model;

import com.truongbq.flappyBrid.manager.ImageStore;
import com.truongbq.flappyBrid.view.Gui;

import java.awt.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class Bird extends GameObject {
    public static final int SIZE = 40;
    private  float a=9.8f;
    private Rectangle rectangle;
    private boolean die;
    private int y0;
    private float t;
    public Bird(int x, int y) {
        super(x, y);
        rectangle = new Rectangle(x,y,SIZE,SIZE);
        die = false;
        y0=y;
        t=0;
    }

    public void draw(Graphics2D graphic2D){
        graphic2D.drawImage(ImageStore.IMG_BIRD,x,y,SIZE,SIZE,null);
    }

    public void fall(int numOfSlepp){
        if (numOfSlepp % 10 ==0 && y <= BackGround.HEIGHT- Ground.HEIGHT){
            y= (int) (y0 + 0.5*a*t*t);
            t+=0.1;
            rectangle.setLocation(x,y);
        }

    }

    public void flap(){
        if (y<=0 ){
            return;
        }
        y-=30;
        y0=y;
        t=0;
        rectangle.setLocation(x,y);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public boolean isDie() {
        return die;
    }

    public void setDie(boolean die) {
        this.die = die;
    }
}
