package com.truongbq.flappyBrid.view;

import javax.swing.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public abstract class BaseContainer extends JPanel {
    public BaseContainer(){
        initPanel();
        initListener();
        initComponents();
    }

    protected abstract void initPanel();
    protected abstract void initComponents();
    protected abstract void initListener();
}
