package com.truongbq.flappyBrid.model;

import com.truongbq.flappyBrid.manager.ImageStore;
import com.truongbq.flappyBrid.view.Gui;

import java.awt.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class Ground extends GameObject {

    public static final int WIDTH = 1152;
    public static final int HEIGHT = 97;
    private int x2;
    public Ground(int x, int y) {
        super(x, y);
        x2=x+830;
    }

    public void draw(Graphics2D graphic2D){
        graphic2D.drawImage(ImageStore.IMG_GROUND,x,y,WIDTH,HEIGHT,null);
        graphic2D.drawImage(ImageStore.IMG_GROUND,x2,y,WIDTH,HEIGHT,null);

    }

    public void movie(int numOfSlepp){
        if (numOfSlepp % 5 == 0){
            x--;
            x2--;
            if (x <= 0 ){
                x2=x+830;
            }
            if (x2<= 0){
                x= x2 +830;
            }
        }
    }
}
