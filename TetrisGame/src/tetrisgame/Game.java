/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author liteaf
 */
public class Game implements Runnable{
    
    private Display display;
    
    private int width, heigth;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    private BufferedImage testImage;
    
    //States
    private State gameState;
    private State menuState;
    
    public Game(String title,int width,int heigth){
        
        this.width = width;
        this.heigth = heigth;
        this.title = title;    
    }
    
    private void init(){
        display = new Display( title, width, heigth);
        Assets.init();
        
        gameState = new GameState();
        menuState = new MenuState();
        State.setState(gameState);
        
    }
    
    int x = 0;
    
    private void tick(){
        if(State.getState() != null)
            State.getState().tick();
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();                            //Don't know
        // Clear Screen
        g.clearRect(0, 0, width, heigth);        
        //Draw Here!
        
        g.drawImage(Assets.grass,x,10,null);
        if(State.getState() != null)
            State.getState().render(g);
        
        //End Drawing!
        bs.show();
        g.dispose();
    }
    
    public void run(){
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;
        
        while(running){
            now = System.nanoTime();
            delta +=(now-lastTime)/timePerTick;
            timer +=now-lastTime;
            lastTime = now;
            
            if(delta>=1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if(timer>=1000000000){
                System.out.println(ticks);
                timer = 0;
                ticks = 0;
            }
        }
        stop();
    }
    
    public synchronized void start(){
        if(running)
            return;
        thread = new Thread(this); 
        thread.start();
        running  = true;
    }
    
    public synchronized void stop(){
        if(!running)
            running  = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
