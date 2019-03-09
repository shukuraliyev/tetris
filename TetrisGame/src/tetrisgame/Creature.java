/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.Graphics;

/**
 *
 * @author Shukur
 */
public class Creature extends Entity {
    
    public static final int DEFAULT_HEALTH = 10; 
    public static final float DEFAULT_SPEED = 3.0f; 
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;
    
    protected int health;
    protected float speed;
    protected float xMove,yMove;
    
    public Creature(float x,float y,int width,int height){
        super(x,y,width,height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
    }
    
    public void move(){
        x+=xMove;
        y+=yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }

    @Override
    public void tick() {
       
    }

    @Override
    public void render(Graphics g) {
        
    }
    
    
    
}
