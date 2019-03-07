/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.image.BufferedImage;

/**
 *
 * @author liteaf
 */
public class Assets {
    
    private static final int width = 32,height = 32;
    
    public static BufferedImage player,dirt,grass,stone,tree; 
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/squares.png"));
         player = sheet.crop(0, 0, width, height);
         dirt = sheet.crop(width, 0, width, height);
         grass = sheet.crop(2*width, 0, width, height);
         stone = sheet.crop(3*width, 0, width, height);
         tree = sheet.crop(0, height, width, height);
    }
    
}
