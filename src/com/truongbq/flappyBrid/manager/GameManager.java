package com.truongbq.flappyBrid.manager;

import com.truongbq.flappyBrid.model.*;
import com.truongbq.flappyBrid.view.Gui;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Truong KL on 4/20/2017.
 */
public class GameManager {
    private BackGround backGround;
    private Ground ground;
    private Bird bird;
    private ArrayList<Pipe> pipes;
    private boolean gameOver = false;
    private WavPlayer wavFlap;
    private WavPlayer wavHit;
    private WavPlayer wavPoint;
    private WavPlayer wavDie;
    private int score;
    private int highScore;

    public GameManager() {
        backGround = new BackGround(0,0);
        ground = new Ground(0, BackGround.HEIGHT - Ground.HEIGHT);
        bird = new Bird((Gui.WIDTH- Bird.SIZE) /2 , (Gui.HEIGHT - Bird.SIZE)/2);
        initPipes();
        wavFlap = new WavPlayer("flap");
        wavHit = new WavPlayer("hit");
        wavPoint = new WavPlayer("point");
        wavDie = new WavPlayer("die");
        score =0;

        try{
            String path = getClass().getResource("/res/data/highScore.txt").getPath();
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            line = br.readLine();
            if (line == null){
                highScore =0;
            }else {
                highScore = Integer.parseInt(line);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void initPipes(){
        pipes = new ArrayList<>();
        Random random = new Random();
        for (int i= 0;i<5;i++){
            int yPipe = -250 - (random.nextInt(30) * 10);
            Pipe p = new Pipe(Gui.WIDTH +10 + 300 * i, yPipe);
            pipes.add(p);
        }
    }

    public void drawBackGround(Graphics2D graphics2D){
        backGround.draw(graphics2D);
    }

    public void moveBackGround(int numOfSleep){
        if (!bird.isDie()){
            backGround.move(numOfSleep);
        }
    }

    public void drawGround(Graphics2D graphics2D){
        ground.draw(graphics2D);
    }

    public void moveGround(int numOfSleep){
        if (!bird.isDie()){
            ground.movie(numOfSleep);
        }
    }

    public void drawBird(Graphics2D graphics2D){
        bird.draw(graphics2D);
    }

    public void flapBird(){
        if (!bird.isDie()){
            bird.flap();
            wavFlap.playSound();
        }

    }

    public void fallBird(int numOfSleep){
        bird.fall(numOfSleep);
        if (bird.getY() + Bird.SIZE >= ground.getY() ){
            gameOver=true;
            wavDie.playSound();

            if (score > highScore){
                highScore = score;

                try{
                    String path = getClass().getResource("/res/data/highScore.txt").getPath();
                    File file = new File(path);
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                    bw.write(String.valueOf(highScore));

                    bw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void drawPipes(Graphics2D graphics2D){
        for (int i=0;i<pipes.size();i++){
            pipes.get(i).draw(graphics2D);
        }
    }

    public void movePipes(int numOfSleep){
        if (!bird.isDie()){
            for (int i=0;i<pipes.size();i++){
                pipes.get(i).move(numOfSleep);

                /*Rectangle r1 = bird.getRectangle().intersection(pipes.get(i).getRecPipeTop());
                Rectangle r2 = bird.getRectangle().intersection(pipes.get(i).getRecPipeBottom());
                if (r1.getX() >= 5 || r1.getY()>= 5 || r2.getX() >=5 || r2.getY()>= 5){
                        wavHit.playSound();
                        bird.setDie(true);
                }
                */

                if (bird.getRectangle().intersects(pipes.get(i).getRecPipeTop()) ||
                        bird.getRectangle().intersects(pipes.get(i).getRecPipeBottom())){
                    wavHit.playSound();
                    bird.setDie(true);

                }

                if ((bird.getX()+ Bird.SIZE)  == (pipes.get(i).getX() + Pipe.WIDTH)){
                    if (numOfSleep % 5 ==0){
                        score++;
                        wavPoint.playSound();
                    }
                }

                if (pipes.get(i).getX() <= 0 - Pipe.WIDTH ){
                    pipes.remove(i);

                    Random random = new Random();
                    int yPipe = -250 - random.nextInt(30) * 10;
                    Pipe p = new Pipe(pipes.get(pipes.size() -1 ).getX() +300, yPipe);
                    pipes.add(p);
                }
            }
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public WavPlayer getWavDie() {
        return wavDie;
    }
}
