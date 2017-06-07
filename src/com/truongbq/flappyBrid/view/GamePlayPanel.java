package com.truongbq.flappyBrid.view;

import com.truongbq.flappyBrid.manager.GameManager;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class GamePlayPanel extends BaseContainer implements Runnable {
    private GameManager gameManager;
    private boolean isGameBegin = false;
    private boolean isGameOver = false;

    @Override
    protected void initPanel() {
        setLayout(null);
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    protected void initComponents() {
        gameManager = new GameManager();
    }

    @Override
    protected void initListener() {
        KeyAdapter keyAdapter = new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode()== KeyEvent.VK_SPACE){
                    if (isGameOver){
                        gameManager.getWavDie().stopSound();
                        initComponents();
                        isGameOver = false;
                        repaint();
                    }else if (!isGameBegin){
                        startGame();
                    }else{
                        gameManager.flapBird();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        addKeyListener(keyAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        gameManager.drawBackGround(g2D);
        gameManager.drawPipes(g2D);
        gameManager.drawGround(g2D);
        gameManager.drawBird(g2D);
        g2D.setFont(new Font("Arial",Font.BOLD,50));
        g2D.drawString(String.valueOf(gameManager.getScore()), Gui.WIDTH/2,50);

        g2D.setFont(new Font("Times New Roman",Font.BOLD,26));

        if(gameManager.isGameOver()){
            g2D.setColor(Color.WHITE);
            g2D.drawString("GAMEOVER", 200, 250);
            g2D.drawString(String.valueOf("Best: " + gameManager.getHighScore()), 230, 300);
            g2D.drawString("Press space to back ", 170, 350);
        } else if(!isGameBegin){
            g2D.setColor(Color.WHITE);
            g2D.drawString("Press space to play game", 150, 300);
        }


    }

    public void startGame() {
        Thread thread = new Thread(this);
        isGameBegin = true;
        isGameOver = false;
        initComponents();
        thread.start();
    }

    @Override
    public void run() {
        int numOfSleep = 0;
        while (!isGameOver) {
            gameManager.moveBackGround(numOfSleep);
            gameManager.moveGround(numOfSleep);
            gameManager.fallBird(numOfSleep);
            gameManager.movePipes(numOfSleep);

            if (gameManager.isGameOver()){
                isGameOver = true;
                isGameBegin =false;
            }

            numOfSleep++;
            if (numOfSleep == Integer.MAX_VALUE){
                numOfSleep = 0;
            }
            repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

