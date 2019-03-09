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
public class GameState extends State {
    
    private Player player;
    
    public GameState(Game game){
        super(game);
        player = new Player(game,20,30);
    }
    
    @Override
    public void tick(){
        player.tick();
    }
    
    @Override
    public void render(Graphics g){
        player.render(g);
        Tile.tiles[0].render(g, 0, 0);
    }
    
}
