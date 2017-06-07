package com.truongbq.flappyBrid.model;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class GameObject {
    protected int x;
    protected int y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
