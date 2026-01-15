import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GameFrame
 */
public class GameFrame extends JFrame {
    CardLayout cardlayout = new CardLayout();
    JPanel panel = new JPanel(cardlayout);
    
    GamePanel gamePanel = new GamePanel();
    MenuPanel menuPanel;

    GameFrame(){
        menuPanel = new MenuPanel(() -> {
            cardlayout.show(panel, "Game");
            gamePanel.startGame();
            gamePanel.requestFocusInWindow();
        });
        
        panel.add(menuPanel, "START");
        panel.add(gamePanel, "GAME");

        this.add(panel);
        this.setTitle("Snake Game V2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        cardlayout.show(panel, "START");
    }
}