package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gameobjects.Player;
import assets.AssetManager;

public class GamePanel extends JPanel implements KeyListener {
    private GameState state;
    private Player player;
    private AssetManager assetManager;

    public GamePanel(){
        this.state = GameState.MENU;
        this.assetManager = new AssetManager();

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);

        switch (state) {
            case MENU:
                // draw menu
                break;
            case SHOP:
                // draw shop
                break;
            case LEADERBOARD:
                // draw leaderboard
                break;
            case PLAYING:
                // draw game
                break;
            case PAUSED:
                // draw pause screen
                break;
            case GAME_OVER:
                // draw game over screen
                break;
            case WIN:
                // draw win screen
                break;
        }
    } 

    public void startGame() {
        this.state = GameState.PLAYING;
        
        /* threads here */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

            // incomplete pa 'to
            if (state == GameState.PLAYING) {
                switch (key) {
                    case KeyEvent.VK_W:
                        break;
                    case KeyEvent.VK_A:
                        break;
                    case KeyEvent.VK_S:
                        break;
                    case KeyEvent.VK_D:
                        break;
                    case KeyEvent.VK_ESCAPE:
                        state = GameState.PAUSED;
                        break;
                }
            } else if (state == GameState.PAUSED && key == KeyEvent.VK_ESCAPE) {
                state = GameState.PLAYING;
            }        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public GameState getState() { return state; }
    public void setState(GameState state) { this.state = state; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public AssetManager getAssetManager() { return assetManager; }
}
