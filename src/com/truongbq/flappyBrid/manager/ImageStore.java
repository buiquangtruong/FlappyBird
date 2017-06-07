package com.truongbq.flappyBrid.manager;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class ImageStore {
    public static final Image IMG_BACKGROUND = new ImageIcon(ImageStore.class.getResource("/res/background_1_old.png")).getImage();
    public static final Image IMG_BIRD = new ImageIcon(ImageStore.class.getResource("/res/bird_orange.gif")).getImage();
    public static final Image IMG_PIPE_TOP = new ImageIcon(ImageStore.class.getResource("/res/OngTren1_old.png")).getImage();
    public static final Image IMG_PIPE_BOTTOM= new ImageIcon(ImageStore.class.getResource("/res/OngDuoi1_old.png")).getImage();
    public static final Image IMG_GROUND = new ImageIcon(ImageStore.class.getResource("/res/ground.png")).getImage();
}
