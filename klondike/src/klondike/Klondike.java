package klondike;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

final public class Klondike extends JDialog {
    //auto complete -> tableau piles facing up and deck and waste empty
    final public static JButton AUTO = new JButton("AUTO");

    //turn 1 or 3 cards
    public enum GameType {
        Turn_1(1), Turn_3(3);
        
        final private int value;
        
        GameType(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
    }

    //current game
    private Game game = new Game(GameType.Turn_1);
    
    private Klondike() {
        setTitle("Klondike");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Game");
        
        for (GameType gameType : GameType.values()) {
            menu.add(gameType.name()).addActionListener(e -> {
                game = new Game(gameType);
                
                setContentPane(game);
                validate();
            });
        }
        
        AUTO.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        AUTO.addActionListener(e -> {
            AUTO.setVisible(false);
            
            game.removeMouseListener(game);
            new Thread(game).start();
        });
        
        menuBar.add(menu);
        menuBar.add(AUTO);
        
        setJMenuBar(menuBar);
        setContentPane(game);        

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new Klondike();
    }
    
}
