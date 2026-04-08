import javax.swing.*;
import java.awt.*;

public class MainContainer extends JFrame {

    JPanel mainPanel;
    CardLayout cardLayout;

    GameLauncher gameLaunch;
    GameSecondPage secondPage;
    GamePanel gamePanel;

    public MainContainer(){
        setTitle("EncanFrogger");
        setSize(850, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        
        gameLaunch = new GameLauncher(this);
        secondPage = new GameSecondPage(this);
        gamePanel = new GamePanel();

        mainPanel.add(gameLaunch, "Launch");
        mainPanel.add(secondPage, "SecondPage");
        mainPanel.add(gamePanel, "Game");

        add(mainPanel);

        launchGame();

        setVisible(true);
    }

    public void launchGame(){
        cardLayout.show(mainPanel, "Launch");
    }

    public void showSecondPage(){
        cardLayout.show(mainPanel, "SecondPage");
    }

    public void startGame(){
        cardLayout.show(mainPanel, "Game");
    }

    public void menuGame(){
        cardLayout.show(mainPanel, "SecondPage"); 
    }

    public static void main(String[] args){
        new MainContainer();
    }
}
