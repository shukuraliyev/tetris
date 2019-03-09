/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

import java.awt.image.BufferedImage;

/**
 *
 * @author Shukur
 */
public class RockTile extends Tile{
    
    public RockTile( int id){
        super(Assets.stone, id);
    }
    
    public boolean isSolid(){
        return true;
    }
}
