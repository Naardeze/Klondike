package klondike.pile;

import java.awt.Color;
import javax.swing.JLabel;
import klondike.card.Card;

/*
    empty pile of cards
*/

public class Pile extends JLabel {
    //pile without symbol (waste, tableau)
    public Pile() {}
    
    //pile with symbol (deck, foundation)
    public Pile(String symbol) {
        super(symbol, JLabel.CENTER);
        
        setForeground(new Color(0, 150, 0));
    }
    
    //returns top card
    public Card getCard() {
        return (Card) getComponent(0);
    }
    
    //puts card on top
    public void setCard(Card card) {
        add(card, 0);
    }
    
    //returns if pile is empty or not
    public boolean isEmpty() {
        return getComponentCount() == 0;
    }
    
}
