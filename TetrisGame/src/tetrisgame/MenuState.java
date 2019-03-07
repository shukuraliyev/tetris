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
public class MenuState extends State{
    
    public MenuState(){
        
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        g.drawImage(Assets.dirt,10,10,null);
    }
    
}
