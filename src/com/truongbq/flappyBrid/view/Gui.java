package com.truongbq.flappyBrid.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class Gui extends JFrame {
    public final static int WIDTH = 600;
    public final static int HEIGHT = 511;

    public Gui(){
        initGui();
        initComs();
    }

    private void initGui(){
        setSize(WIDTH,HEIGHT);
        setLayout(new CardLayout());
        setTitle("FLAPPY BIRD");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComs(){
        GamePlayPanel gamePlayPanel = new GamePlayPanel();
        add(gamePlayPanel);
    }
}
