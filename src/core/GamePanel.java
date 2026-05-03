package core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import gameobjects.Player;
//import gameobjects.SelectedCharacter;
import assets.AssetManager; 

public class GamePanel extends JPanel implements KeyListener {
    private GameState state;
    private Player player;
    private AssetManager assetManager;

    public GamePanel(){
        this.state = GameState.SETTING_UP;
        this.assetManager = new AssetManager();

        setFocusable(true);
        addKeyListener(this);

        chooseChar();
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
            case SETTING_UP:
                break;
            case PLAYING:
                // draw game
                //startGame();
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


    private void chooseChar(){
        setLayout(new BorderLayout());

        JPanel characPanel = new JPanel(new BorderLayout());
        JPanel characTitle = new JPanel();
        JPanel characBttn = new JPanel(new GridLayout(1, 5, 10, 10));
            //characBttn.setLayout(new BoxLayout(characBttn, BoxLayout.X_AXIS));
        JPanel buttons = new JPanel(new BorderLayout());
            buttons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        characTitle.add(new JLabel ("CHOOSE CHARACTER"), SwingConstants.CENTER);

        //characters button - i'll be using radio button po
        JRadioButton paopao = new JRadioButton("Paopao"); //remove th ename if not necessary
        JRadioButton flamara = new JRadioButton("Flamara"); //remove th ename if not necessary 
        JRadioButton deia = new JRadioButton("Deia");
        JRadioButton adamus = new JRadioButton("Adamus");
        JRadioButton terra = new JRadioButton("Terra");

        ButtonGroup charGroup = new ButtonGroup();
        charGroup.add(paopao);
        charGroup.add(terra);
        charGroup.add(flamara);
        charGroup.add(adamus);
        charGroup.add(deia);

        characBttn.add(paopao);
        characBttn.add(Box.createHorizontalStrut(40));
        characBttn.add(terra);
        characBttn.add(Box.createHorizontalStrut(40));
        characBttn.add(flamara);
        characBttn.add(Box.createHorizontalStrut(40));
        characBttn.add(adamus);
        characBttn.add(Box.createHorizontalStrut(40));
        characBttn.add(deia);
        characBttn.add(Box.createHorizontalStrut(40));

        JButton next = new JButton("NEXT");
        JButton back = new JButton("BACK");

        buttons.add(back, BorderLayout.WEST);
        buttons.add(next, BorderLayout.EAST);

        characPanel.add(characTitle, BorderLayout.NORTH);
        characPanel.add(buttons, BorderLayout.SOUTH);
        characPanel.add(characBttn, BorderLayout.CENTER);

        add(characPanel, BorderLayout.CENTER);


        //---------------------LOGIC-------------------------
        
        //per character
        if (charGroup.getSelection() == terra){
            //waray pa man classes for each char
        }

        next.addActionListener(e -> {
            chooseMap();
        });

    }

    public void chooseMap(){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

            // incomplete pa 'to
            if (state == GameState.PLAYING && player != null) {
            switch (key) {
                case KeyEvent.VK_W:
                    player.move(0, -5);
                    break;
                case KeyEvent.VK_A:
                    player.move(-5, 0);
                    break;
                case KeyEvent.VK_S:
                    player.move(0, 5);
                    break;
                case KeyEvent.VK_D:
                    player.move(5, 0);
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
